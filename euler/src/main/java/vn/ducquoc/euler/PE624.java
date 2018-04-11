package vn.ducquoc.euler;

import java.math.*;
import java.util.*;

/**
 * <h2>Two heads are better than one</h2>
 *
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=624</a>
 */
@SuppressWarnings("unused")
public class PE624 {

  public static long MAX_N = (long) 1e18; //1_000_000_000_000_000_000L;
  public static long MOD_PRIME = (long) 1e9 + 9; //1000000009L;

  public static void main(String[] args) {

    System.out.println("P(2)=" + Arrays.toString(calcP(2, 109)) + " -> Q=" + calcQ(2, 109));
    System.out.println("P(3)=" + Arrays.toString(calcP(3, 109)) + " -> Q=" + calcQ(3, 109));
    System.out.println("P(5)=" + Arrays.toString(calcP(5, 109)) + " -> Q=" + calcQ(5, 109));
    System.out.println("P(6)=" + Arrays.toString(calcP(6, 109)) + " -> Q=" + calcQ(6, 109));

    long start = System.nanoTime();
    long result = calcQ(MAX_N, MOD_PRIME);
    System.out.println("Time in milliseconds: " + (System.nanoTime() - start) / 1e6);
    System.out.println(new Throwable().getStackTrace()[0].getFileName().replace(".java", "") + ": " + result);
  }

  public static long[] calcP(Number n, long mod) {
    long number = n.longValue();
    number %= mod;
    if (number > Integer.MAX_VALUE) { // array limit, if necessary use HashMap<Long, Long>
      number = Integer.MAX_VALUE - 1;
    }
    long[] a = new long[(int) number + 1];
    long[] b = new long[(int) number + 1];
    a[1] = 1; if (number > 1) a[2] = 3; if (number > 2) a[3] = 9; //if (number > 3) a[4] = 33;
    b[1] = 1; if (number > 1) b[2] = 5; if (number > 2) b[3] = 31; //if (number > 3) b[4] = 145;
    for (int i = 4; i <= number; i++) {
      a[i] = 4 * a[i - 1] - a[i - 2];
      b[i] = 5 * b[i - 1] + 2 * b[i - 2] - 20 * b[i - 3] - 16 * b[i - 4];
    }

    return new long[]{a[(int) number], b[(int) number]};
  }

  public static long calcQ(Number n, long mod) {
    long number = n.longValue();

    // built-in P(n), faster than sqrt(5) approach
    long[] retrievalFib = fiboRetrievalTo(number, mod);
    long modPow = Util.integerModPow(2, number, mod);
    long u = (number % 2 == 0) ? 1 : (mod - 1);
    // a=2^n*F(n−1)−(−1)^n                // a[] { 0, 1, 3, 9, 33, ... }
    long a = (modPow * retrievalFib[0] + mod - u) % mod;
    // b=4^n−2^n*(F(n)+2*F(n−1))+(−1)^n   // b[] { 0, 1, 5, 31, 145, ... }
    long b = (modPow * modPow + (mod - modPow) * (retrievalFib[1] + 2 * retrievalFib[0]) + u) % mod;
    long result = Util.integerModInverse(b, mod) * a % mod; // a == b * result % mod

    return result;
  }

  public static long[] fiboRetrievalTo(long n, long mod) {
    long[] fibP = {1, 0, 0, 1};

    for (long[] fibF = {0, 1, 1, 1}; n > 0; fibF = mulMod(fibF, fibF, mod), n /= 2) {
      if (n % 2 == 1) {
        fibP = mulMod(fibP, fibF, mod);
      }
    }

    return new long[]{fibP[0], fibP[2]};
  }

  public static long[] mulMod(long[] a, long[] b, long mod) {

    return new long[]{
            (a[0] * b[0] + a[1] * b[2]) % mod,
            (a[0] * b[1] + a[1] * b[3]) % mod,
            (a[2] * b[0] + a[3] * b[2]) % mod,
            (a[2] * b[1] + a[3] * b[3]) % mod
    };
  }

}
