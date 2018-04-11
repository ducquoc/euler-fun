package vn.ducquoc.euler;

import java.util.ArrayList;
import java.util.List;

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
      return a;
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

  public static void main(String[] args) {
//    System.out.println(lowestCommonMultiple(7, 90));
//    System.out.println(lowestCommonMultiple(35, 90));
//    System.out.println(lowestCommonMultiple(-2, 90));
//    System.out.println("Prime: " + isPrime(" 103 "));
//    System.out.println("Prime: " + isPrime("32416190071"));
//    System.out.println("Prime: " + isPrime("9223372036854775837"));
    System.out.println("modPow: " + integerModPow(7, 2, 20)); // 7^2 mod 20 == 9
    System.out.println("modPow: " + integerModPow(5, 3, 20)); // 5^3 mod 20 == 5
    System.out.println("modPow: " + integerModPow(-16, 8, 800)); // (-16)^8 mod 800 == 96
    System.out.println("modInverse: " + integerModInverse(7, 20)); // 7*3 mod 20 == 1
    System.out.println("modInverse: " + integerModInverse(3, 11)); // 3*4 mod 11 == 1
    System.out.println("modInverse: " + integerModInverse(42, 2017)); // 42*1969 mod 2017 == 1
    System.out.println("sumSquares: " + sumSquares1ToN(5)); // 1^2 + 2^2 + 3^2 + 4^2 + 5^2
    System.out.println("sumSquaresMod: " + sumSquares1ToN(5, 7)); // (1^2 + 2^2 + 3^2 + 4^2 + 5^2) % 7
  }

}
