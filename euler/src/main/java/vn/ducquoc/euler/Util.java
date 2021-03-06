package vn.ducquoc.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Helper class for solving the problems in <b><a href="http://projecteuler.net">ProjectEuler</a></b>.
 * 
 * @author ducquoc
 *
 * @see vn.ducquoc.jutil.MathUtil
 * @see org.apache.commons.math.util.MathUtils
 * @see com.google.common.MathUtil
 */
public class Util {

  public static long sum1ToN(long number) {
    return number * (number + 1) / 2;
  }

  public static long sumMultiples(long divisor, long upperBound) {
    return divisor * sum1ToN(upperBound / divisor);
  }

  public static boolean isPrime(long number) {
    if (number < 2)
      return false;

    double sqrtNumber = Math.sqrt((double) number);
    for (long i = 2; i <= sqrtNumber; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrime(String numberText) {
    if (numberText == null) return false;

    //Long.MAX_VALUE==649657L*92737*337*127*73*7*7;//+30
    return new java.math.BigInteger(numberText.trim()).isProbablePrime(64);
  }

  public static List<Long> primeFactors(long number) {
    List<Long> factors = new ArrayList<Long>();
    for (long i = 2; i <= number; i++) {
      while (number % i == 0) {
        factors.add(i);
        number = number / i;
      }
    }
    return factors;
  }

  /**
   * @param num
   * @return isPrime[i] indicates whether i is prime, for 0 <= i <= n.
   */
  public static boolean[] primeProbArr(Number num) {
    long n = num.longValue();
    if (n < 0)
      throw new IllegalArgumentException("Negative array size");
    boolean[] result = new boolean[(int) (n + 1)];
    if (n >= 2)
      result[2] = true;
    for (int i = 3; i <= n; i += 2)
      result[i] = true;
    // Sieve of Eratosthenes
    for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
      if (result[i]) {
        // Note: i * i does not overflow
        for (int j = i * i; j <= n; j += i << 1)
          result[j] = false;
      }
    }
    return result;
  }

  /**
   * @param n
   * @return prime numbers less than or equal to n, in ascending order.
   */
  public static int[] primeIntTo(int n) {
    boolean[] primeCheckArr = primeProbArr(n);
    int count = 0;
    for (boolean b : primeCheckArr) {
      if (b) {
        count++;
      }
    }

    int[] result = new int[count];
    for (int i = 0, j = 0; i < primeCheckArr.length; i++) {
      if (primeCheckArr[i]) {
        result[j] = i;
        j++;
      }
    }
    return result;
  }

  /**
   * @param n
   * @return prime numbers less than or equal to n, in ascending order.
   */
  public static long[] primeLongTo(long n) {
    boolean[] primeCheckArr = primeProbArr(n);
    int count = 0;
    for (boolean b : primeCheckArr) {
      if (b) {
        count++;
      }
    }

    long[] result = new long[count];
    for (int i = 0, j = 0; i < primeCheckArr.length; i++) {
      if (primeCheckArr[i]) {
        result[j] = i;
        j++;
      }
    }
    return result;
  }

  /**
   * @param primeOrder
   * @return prime numbers at the order (-th) up to primeOrder
   */
  public static int[] primeNth(Number primeOrder) {
    int n = primeOrder.intValue();
    int[] primesNth = new int [n+1];
    primesNth[0] = 1;// natural index: primesNth[1]=2;
    for (int i = 1, num=2; i <= n; num++) {
      if (isPrime(num)) {
        primesNth[i] = num;
        i++;
      }
    }
    return primesNth;
  }

  public static long greatestCommonDivisor(long a, long b) {
    if (b == 0)
      return a; // assumption a > b, otherwise return non-zero: if (a == 0 || b == 0) return a+b;
    return greatestCommonDivisor(b, a % b);
  }

  public static long lowestCommonMultiple(long a, long b) {
    return a * b / greatestCommonDivisor(a, b);
  }

  public static long integerPow(long a, long b) {
    long result = 1; //return (b == 0) ? 1 : a * integerPow(a, b - 1);
    for (long i = 0; i < b; i++) {
      result *= a;
    }
    return result;
  }

  public static List<Long> distinct(List<Long> source) {
    List<Long> dest = new ArrayList<Long>();
    for (int i = 0, s = source.size(); i < s ; i++) {
      Long num = source.get(i);
      if (!dest.contains(num)) {
        dest.add(num);
      }
    }
    return dest;
  }

  public static boolean isPalindrome(String str) {
    // return new StringBuilder(str).reverse().toString().equals(str);
    int strLength = str.length();
    for (int i = 0; i < strLength / 2; i++) {
      if (str.charAt(i) != str.charAt(strLength - 1 - i))
        return false;
    }
    return true;
  }

  public static long phi(long number) {
    java.util.List<Long> factors = Util.distinct(Util.primeFactors(number));
    int factorsLength = factors.size(); // unnecessary to check size 0 or 1

    double totientFactor = 1;
    for (int i = 0; i < factorsLength; i++) {
      totientFactor = totientFactor * (1 - 1.0 / factors.get(i));
    }
    return (long) (totientFactor * number);
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

  /**
   * C(n,k) == n! / ((k!) * (n-k)!)
   */
  public static long binomialNChooseK(long n, long k) {
    long res = 1;
    long base = 1;
    for (long i = 1; i <= k; i++) base *= i;
    for (long i = 1; i <= k; i++) {
      res *= (n + 1 - i);
      long gcd = greatestCommonDivisor(res, base);
      base /= gcd;
      res /= gcd;
    }
    return res;
  }

  /**
   * base ^ exp % mod == retVal
   */
  public static long integerModPow(long base, long exp, long mod) {
    if (exp == 0)
      return 1;
    long p = integerModPow(base, exp / 2, mod) % mod;
    p = (p * p) % mod;
    return (exp % 2 == 0) ? p : (base * p) % mod;
  }

  /**
   * (base * retVal) % mod == 1 (given mod and base are co-primes)
   */
  public static long integerModInverse(long base, long mod) {
    long i = mod, v = 0, d = 1; // extended Euclid Algorithm Assumption: co-prime gcd(base, mod) = 1
    while (base > 0) {
      long t = i / base, x = base; // t is quotient
      base = i % x; // base is remainder now, Euclid algo
      i = x;
      x = d;
      d = v - t * x; // now update v and d for next loop
      v = x;
    }
    v %= mod; // v should be positive, only v == 0 when mod == 1
    return (v < 0) ? (v + mod) : v;
  }

  public static long slowModInverse(long base, long mod) {
    base = base % mod;
    for (long x = 1; x < mod; x++)
      if ((base * x) % mod == 1)
        return x;
    return 1;
  }

  /**
   * (base * retVal) % mod == 1 (given mod is prime)
   */
  public static long primeModInverse(long base, long mod) {
    long g = greatestCommonDivisor(base, mod);
    return (g != 1) ? slowModInverse(base, mod) : integerModPow(base, mod - 2, mod);
  }

  public static long sumSquares1ToN(long number) {
    return number * (number + 1) * (2 * number + 1) / 6;
  }

  public static long sumSquares1ToN(long number, long mod) {
    number %= mod;
    long a1 = number, a2 = number + 1, a3 = 2 * number + 1;

    if (a1 % 2 == 0) a1 >>= 1; else a2 >>= 1; // div 2
    if (a1 % 3 == 0) a1 /= 3; else if (a2 % 3 == 0) a2 /= 3; else a3 /= 3; // div 3

    return a1 * a2 % mod * a3 % mod; // n*(n+1)*(2*n+1)/6 % mod
  }

  public static long sumSquaresMod(long n, long mod) {
    n %= mod;
    long n1 = n+1, n2 = n+n1;

    switch ((int) (n%6)) {
      case 0: return n/6 * n1 % mod * n2 % mod;
      case 1: return n * n1/2 % mod * n2/3 % mod;
      case 2: return n/2 * n1/3 % mod * n2 % mod;
      case 3: return n/3 * n1/2 % mod * n2 % mod;
      case 4: return n/2 * n1 % mod * n2/3 % mod;
      case 5: return n  * n1/6 % mod * n2 % mod;
      default: return 0; // unreachable
    }
  }

  public static long sumGcd(long n) { // not very optimal yet, can be improved
    int[] array = new int[(int) n + 1]; // array[0] ignored

    for (int i = 1; i <= n / 2; i++) {
      if (n % i == 0) {
        for (int j = i; j <= n; j += i) {
          array[j] = i;
        }
      }
    }

    long sum = n;
    for (int i = 1; i < n; i++) {
      sum += array[i];
    }

    return sum;
  }

  public static long sumGcdSummation(long n) { // not very optimal yet, can be improved
    long result = 0;
    for (long i = 1; i <= n; i++) {
      result = (result + phiTotient(i) * sum1ToN(n / i));
    }

    return result;
  }

  public static long[] phiTotientArr(long n) {
    long[] phi = new long[(int) (n + 1)];
    phi[1] = 1;
    for (int i = 2; i < n; i++) {
      if (phi[i] == 0) {
        phi[i] = i - 1;
        for (int j = (i << 1); j < n; j += i) {
          if (phi[j] == 0)
            phi[j] = j;

          phi[j] = (phi[j] / i) * (i - 1);
        }
      }
    }
    return phi;
  }

  public static Map<Long,Long> phiTotientSieve(long length) {
    HashMap<Long,Long> phiTotientLookup = new HashMap<Long, Long>();
    for (long i = 0; i <= length; i++)
      phiTotientLookup.put(i, i);
    for (long i = 2; i <= length; i++) {
      if (phiTotientLookup.get(i) == i) {
        phiTotientLookup.put(i, i - 1);
        for (long j = i + i; j <= length; j += i) {
          phiTotientLookup.put(j, phiTotientLookup.get(j) / i);
          phiTotientLookup.put(j, phiTotientLookup.get(j) * (i - 1));
        }
      }
    }
    return phiTotientLookup;
  }

  public static int mobiusSquareFree(long n) {
    if (n == 1) return 1;

    long p = 0;
    if (n % 2 == 0) {
      n = n / 2;
      p++;

      // If 2^2 also divides N
      if (n % 2 == 0)
        return 0;
    }

    for (int i = 3; i <= n; i = i + 2) {
      if (n % i == 0) {
        n = n / i;
        p++;

        // If i^2 also divides N
        if (n % i == 0)
          return 0;
      }
    }

    // All prime factors are contained only once Return 1 if p is even else -1
    return (p % 2 != 0) ? -1 : 1;
  }

  public static long sumPhiTotient(long number) {
    long result = 0;
    for (int i = 1; i <= number; i++) {
      result += phiTotient(i);
      //result += sum1ToN(number / i) * mobiusSquareFree(i);
      //result += phiTotientLookup.get(i);
    }

    return result;
  }

  public static long factorial(long n) {
    long result = 1, recursivePart = n;
    while (recursivePart-- > 1) {
      result = result * recursivePart;
    }
    return result;
  }

  public static void main(String[] args) {
//    System.out.println(lowestCommonMultiple(7, 90));
//    System.out.println(lowestCommonMultiple(35, 90));
//    System.out.println("Prime: " + isPrime(" 103 "));
//    System.out.println("Prime: " + isPrime("32416190071"));
//    System.out.println("Prime: " + isPrime("9223372036854775837"));
//    System.out.println("binomial coefficient: " + binomialNChooseK(11, 3));
//    System.out.println("modPow: " + integerModPow(7, 2, 20)); // 7^2 mod 20 == 9
//    System.out.println("modPow: " + integerModPow(5, 3, 20)); // 5^3 mod 20 == 5
//    System.out.println("modPow: " + integerModPow(-16, 8, 800)); // (-16)^8 mod 800 == 96
//    System.out.println("modInverse: " + integerModInverse(7, 20)); // 7*3 mod 20 == 1
//    System.out.println("modInverse: " + integerModInverse(3, 11)); // 3*4 mod 11 == 1
//    System.out.println("modInverse: " + integerModInverse(42, 2017)); // 42*1969 mod 2017 == 1
//    System.out.println("sumSquares: " + sumSquares1ToN(5)); // 1^2 + 2^2 + 3^2 + 4^2 + 5^2
//    System.out.println("sumSquaresMod: " + sumSquares1ToN(5, 7)); // (1^2 + 2^2 + 3^2 + 4^2 + 5^2) % 7
//    System.out.println("sumGcdSummation: " + sumGcdSummation(10));
//    System.out.println("phiTotient: " + phiTotient(10));
//    System.out.println("sumPhiTotient: " + sumPhiTotient(10));

    Function<Long, Long> factorialFunct = Util::factorial;
    Function<Long, Long> testMemoFunct = Util.Memoizer.memoize(factorialFunct);
    System.out.println("memoizeFunc(5)= " + testMemoFunct.apply(5L));
    System.out.println("memoizeFunc(5)= " + testMemoFunct.apply(5L));
    Memoizer<Long, Long> testMemoizer = Util.Memoizer.fromFunction(n -> Util.factorial(n));
    System.out.println("memoizeGet(6)= " + testMemoizer.get(6L));
    System.out.println("memoizeGet(6)= " + testMemoizer.get(6L));
  }

  public static class Memoizer<T, R> {

    private Function<T, R> internalFunction;
    protected final Map<T, R> lookup = new ConcurrentHashMap<>();
    private Function<T, R> memoizeInternal(final Function<T, R> function) { //separate instance, not static
      internalFunction = function;
      return input -> lookup.computeIfAbsent(input, internalFunction::apply);
    }

    public static <T, R> Function<T, R> memoize(final Function<T, R> function) { //expose static method
      Memoizer instance = new Memoizer<T, R>();
      return instance.memoizeInternal(function);
    }

    public static <T, R> Memoizer<T, R> fromFunction(final Function<T, R> function) {
      Memoizer memoizer = new Memoizer<T, R>();
      memoizer.memoizeInternal(function);
      return memoizer;
    }

    public R get(T input) {
      if (internalFunction != null) lookup.computeIfAbsent(input, internalFunction); // apply(input)
      return lookup.get(input);
    }

    // bi-function is equivalent to recursive function to function
    public static <T1, T2, R> BiFunction<T1, T2, R> memoize(final BiFunction<T1, T2, R> biFunc) {
      final BiFunction<T1, T2, Supplier<R>> biFuncSupplier = (x, y) -> () -> biFunc.apply(x, y);
      final Function<T1, Function<T2, R>> transformed
              = Memoizer.memoize(
              x -> Memoizer.memoize(
                      y -> biFuncSupplier.apply(x, y).get()));
      return (x, y) -> transformed.apply(x).apply(y);
    }

    // likewise, we can memoize TriFunction<T1,T2,T3,R> instead of Function<T1, Function<T2, Function<T3, R>>>
  }

}
