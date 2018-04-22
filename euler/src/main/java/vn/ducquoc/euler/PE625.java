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

  public static long MAX_N = (long) 1e11; //100_000_000_000L;
  public static long MOD_PRIME = 998244353; //1000000009L;

  public static void main(String[] args) {

    System.out.println("G(10)=" + calcG(10, MOD_PRIME));
    System.out.println("G(100)=" + calcG(100, MOD_PRIME));

    long start = System.nanoTime();
    long result = calcG(MAX_N, MOD_PRIME); // a few hours, to be improved
    System.out.println("Time in milliseconds: " + (System.nanoTime() - start) / 1e6);
    System.out.println(new Object() {}.getClass().getEnclosingClass().getSimpleName() + ": " + result);
  }

  public static long calcG(Number n, long mod) {
    long number = n.longValue(), result = 0;

//    long sqrtN = (long) Math.sqrt(number);
//    for (long i = 1; i <= sqrtN; i++) {
//      result = (result + i * sumPhiTotient(number / i)) % mod;
//    }
//    for (long i = 1; i < sqrtN; i++) {
//      result = (result + (sum1ToN(number / i) - sum1ToN(number / (i + 1))) * sumPhiTotient(i)) % mod;
//    }

    for (long i = 1; i <= number; i++) {
      result = (result + (number / i) * (number / i + 1) / 2 * phiTotient(i)) % mod;
    }

    return result % mod;
  }

  public static long sum1ToN(long number) { // triangular number
    return number * (number + 1) / 2;
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

  public static long sumPhiTotient(long number) {
    long result = 0;
    for (int i = 1; i <= number; i++) {
      result += phiTotient(i);
    }
    return result;
  }

  public static void printR(Object... varArgs) {
    System.out.println(Arrays.deepToString(varArgs));
  }

}
