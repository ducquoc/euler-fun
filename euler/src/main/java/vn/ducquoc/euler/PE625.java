package vn.ducquoc.euler;

import java.math.*;
import java.util.*;

/**
 * <h2>Gcd sum</h2>
 *
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=625</a>
 */
@SuppressWarnings("unused")
public class PE625 {

  public static long MAX_N = (long) 1e7; //100_000_000_000L;
  public static long MOD_PRIME = 998244353; //1000_000_009L;

  public static void main(String[] args) {

    System.out.println("G(10)=" + calcG(10, MOD_PRIME));

    long start = System.nanoTime();
    long result = calcG(MAX_N, MOD_PRIME); // 2^64 or 10^11 is easier for Python/StdC++ than Java (64-bit long)
    System.out.println("Time in milliseconds: " + (System.nanoTime() - start) / 1e6);
    System.out.println(new Object() {}.getClass().getEnclosingClass().getSimpleName() + ": " + result);
  }
/*
G(10)=122
G(100)=18065
G(1000)=2475190
G(10000)=317257140
G(100000)=783912038
G(1000000)=668281525
G(10000000)=825808541
G(100000000)=29807134
G(1000000000)=590372741
G(2000000000)=865252543
G(3000000000)=522531962
G(3037000499)=288585128
G(3037000500)=134680349
G(35068e5)=802156175
G(35069e5)=45879894
G(55e8)=3060729
G(56e8)=729860265
G(100e8)=288516859
*/

  public static long calcG(Number n, long mod) {
    long number = n.longValue(), result = 0;

    result = sumGcdSummationModR(number, mod);

    return result % mod;
  }

  public static long sumGcdSummationModR(long number, long mod) { // Reality
    long result = 0;
    BigInteger bigRes = BigInteger.ZERO;
    BigInteger MOD = BigInteger.valueOf(mod);
    long sqrtN = (long) Math.sqrt(number);
    for (long i = 1; i <= sqrtN; i++) {
      //result = (result + i * cacheSums(number / i) % mod) % mod;
      bigRes = bigRes.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(cacheSums(number / i))));
      //bigRes = bigRes.mod(MOD);
    }
    long sqrtRemainder = number / sqrtN, iNext = number, iMemoize; // memoize trick, same as in PE401 sumSigma2
    for (long i = 1; i < sqrtRemainder; i++) {
      iMemoize = iNext; // faster than using array/map for pair (n/i) and n/(i+1)
      iNext = number / (i + 1);
      //result = (result + cacheSums(i) % mod * ((iMemoize + iNext + 1) * (iMemoize - iNext)) / 2 % mod) % mod;
      bigRes = bigRes.add(BigInteger.valueOf(cacheSums(i))
              .multiply(BigInteger.valueOf(iMemoize).add(BigInteger.valueOf(iNext).add(BigInteger.ONE))
                      .multiply(BigInteger.valueOf(iMemoize - iNext))
                      .divide(BigInteger.valueOf(2)))
              );
      //bigRes = bigRes.mod(MOD);
    }
    result = bigRes.mod(MOD).longValue();

    return result;
  }

  public static Map<Long, Long> mertensLookup = new HashMap<Long, Long>();
  public static long cacheSums(long number) { //check Mertens/Pillai function
    Long v = mertensLookup.get(number);
    if (v != null) return v;
    long result = 0;
    long sqrtN = (long) Math.sqrt(number);
    if (number < Integer.MAX_VALUE) {
      result = number * (number + 1) / 2;
      for (long i = 2; i <= sqrtN; i++) {
        result -= cacheSums(number / i);
      }
      for (long i = 1; i < number / sqrtN; i++) {
        result -= cacheSums(i) * (number / i - number / (i + 1));
      }
    } else { // I hate this long limitation - 3x performance degradation - but has to live with it for now
      BigInteger bigNum = BigInteger.valueOf(number);
      BigInteger bigRes = bigNum.multiply(BigInteger.ONE.add(bigNum)).divide(BigInteger.valueOf(2));
      for (long i = 2; i <= sqrtN; i++) {
        bigRes = bigRes.subtract(BigInteger.valueOf(cacheSums(number / i)));
      }
      for (long i = 1; i < number / sqrtN; i++) {
        BigInteger iMemoize = BigInteger.valueOf(number / i);
        BigInteger iNext = BigInteger.valueOf(number / (i + 1));
        bigRes = bigRes.subtract(BigInteger.valueOf(cacheSums(i)).multiply(iMemoize.subtract(iNext)));
      }
      result = bigRes.longValue();
    }
    v = result;
    mertensLookup.put(number, v);
    return v;
  }

  public static long sumGcdSummationModSI(long number, long mod) { // Straight Immediately
    long result = 0;
    for (long i = 1; i <= number; i++) {
      result = (result + sum1ToN(number / i) * phiTotient(i)) % mod;
    }

    return result;
  }

  public static long sumGcdSummationModMP(long number, long mod) { // More Pragmatic
    long result = 0;
    long sqrtN = (long) Math.sqrt(number);
    phiTotientLookup = phiTotientSieve(number); //cache for sumPhiTotient()
    for (long i = 1; i <= sqrtN; i++) {
      result = (result + i * cacheSumPhiTotient(number / i)) % mod;
    }
    for (long i = 1; i < sqrtN; i++) {
      result = (result + (sum1ToN(number / i) - sum1ToN(number / (i + 1))) * cacheSumPhiTotient(i) % mod) % mod;
    }

    return result;
  }

  public static long sumGcdSummationModLE(long number, long mod) { // Less Engineering
    long result = 0;
    long sqrtN = (long) Math.sqrt(number);
    long smallLookup[] = new long[(int) sqrtN + 1]; //2 * sumPhiTotient(i) - 1;
    smallLookup[1] = 1;
    for (int k = 2; k <= sqrtN; k++) {
      long s = k * k;
      int sqrtK = (int) Math.sqrt(k);
      for (int i = 1; i <= sqrtK; i++) {
        s -= (smallLookup[i] * (k / i - k / (i + 1)) % mod);
      }
      for (int i = 2; i <= k / (sqrtK + 1); i++) {
        s -= smallLookup[k / i];
      }
      smallLookup[k] = s % mod;
    }
    HashMap<Long, Long> resLookup = new HashMap<Long, Long>();
    for (long i = sqrtN; i > 0; i--) {
      if (i != number / i) {
        long k = number / i;
        long kRemainder = k % mod;
        long s = kRemainder * kRemainder;
        long sqrtK = (long) Math.sqrt(k);
        for (long j = 1; j <= sqrtK; j++) {
          s -= (smallLookup[(int) j] * ((k / j - k / (j + 1)) % mod) % mod);
        }
        for (long j = 2; j <= k / (sqrtK + 1); j++) {
          if (k / j <= sqrtK) {
            s -= smallLookup[(int) (k / j)];
          } else {
            s -= resLookup.get(k / j) == null ? smallLookup[(int) (k / j)] : resLookup.get(k / j);
          }
        }
        resLookup.put(k, s % mod);
      } else {
        resLookup.put(i, smallLookup[(int) i]);
      }
    }

    result = sum1ToNMod(number, mod);
    for (int i = 1; i <= sqrtN; i++) {
      result += (i * resLookup.get(number / i) % mod);
      result %= mod;
    }
    for (int i = 1; i <= number / (sqrtN + 1); i++) {
      result += (smallLookup[i] * (sum1ToNMod(number / i, mod) - sum1ToNMod(number / (i + 1), mod)) % mod);
      result %= mod;
    }
    long invMod = mod / 2 + 1; //499122177
    result = result * invMod % mod;

    return result;
  }

  public static long sum1ToN(long number) { // triangular number
    return number * (number + 1) / 2;
  }

  public static Map<Long, Long> sum1ToNLookup = new HashMap<Long, Long>();
  public static long cacheSum1ToN(long number) {
    Long v = sum1ToNLookup.get(number);
    if (v != null) return v;
    v = sum1ToN(number);
    sum1ToNLookup.put(number, v);
    return v;
  }

  public static long memoizeSum1ToN(long number) {
    Long v = sum1ToNLookup.get(number);
    if (v == null) {
      v = sum1ToN(number);
      sum1ToNLookup.put(number, v);
    }
    return v;
  }

  public static long putSum1ToN(long number) {
    sum1ToNLookup.putIfAbsent(number, sum1ToN(number));
    return sum1ToNLookup.get(number);
  }

  public static long computeSum1ToN(long number) {
    return sum1ToNLookup.computeIfAbsent(number, k -> sum1ToN(k));
  }

  public static long computeRefSum1ToN(long number) {
    return sum1ToNLookup.computeIfAbsent(number, PE625::sum1ToN);
  }

  public static long phiTotient(long number) {
    long result = number;
    for (int i = 2; i * i <= number; ++i) {
      if (number % i == 0) {
        result -= result / i;
      }
      while (number % i == 0)
        number /= i;
    }
    if (number > 1) {
      result -= result / number;
    }
    return result;
  }

  public static HashMap<Long,Long> phiTotientLookup = new HashMap<Long, Long>();// = phiTotientSieve(MAX_N);
  public static HashMap<Long,Long> phiTotientSieve(long length) {
    HashMap<Long,Long> phiTotientLookup = new HashMap<Long, Long>();
    for (long i = 0; i <= length; i++)
      phiTotientLookup.put(i, i);
    for (long i = 2; i <= length; i++) {
      if (phiTotientLookup.get(i) == i) {
        phiTotientLookup.put(i, i - 1);
        for (long j = i + i; j <= length; j += i) {
          //phi[j] /= i;
          phiTotientLookup.put(j, phiTotientLookup.get(j) / i);
          //phi[j] *= i - 1;
          phiTotientLookup.put(j, phiTotientLookup.get(j) * (i - 1));
        }
      }
    }
    return phiTotientLookup;
  }

  public static long sumPhiTotient(long number) {
    long result = 0;
    for (long i = 1; i <= number; i++) {
      //result += phiTotient(i);
      //result += Util.mobiusSquareFree(i) * sum1ToN(number / i);
      result += phiTotientLookup.get(i);
    }

    return result;
  }

  public static Map<Long, Long> sumPhiTotientLookup = new HashMap<Long, Long>();
  public static long cacheSumPhiTotient(long number) {
    Long v = sumPhiTotientLookup.get(number);
    if (v != null) return v;
    v = sumPhiTotient(number);
    sumPhiTotientLookup.put(number, v);
    return v;
  }

  public static Map<Long, Integer> mobiusLookup = new HashMap<Long, Integer>();
  public static int cacheMobius(long number) {
    Integer v = mobiusLookup.get(number);
    if (v != null) return v;
    v = Util.mobiusSquareFree(number);
    mobiusLookup.put(number, v);
    return v;
  }

  public static long sum1ToNMod(long number, long mod) {
    if (number % 2 == 0) {
      return (number / 2 % mod) * ((number + 1) % mod) % mod;
    }
    return ((number + 1) / 2 % mod) * (number % mod) % mod;
  }

  public static void printR(Object... varArgs) {
    System.out.println(Arrays.deepToString(varArgs));
  }

}
