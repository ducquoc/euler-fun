package vn.ducquoc.euler;

/**
 * <h2>Sum of squares of divisors</h2>
 *
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=401</a>
 */
@SuppressWarnings("unused")
public class PE401 {

  public static long MAX_N = (long) 1e15; //1_000_000_000_000_000L;
  public static long MOD = (long) 1e9; //1000000000L;

  public static void main(String[] args) {

    System.out.println("SIGMA2(2): " + sumSigma2(2, MOD));
    System.out.println("SIGMA2(3): " + sumSigma2(3, MOD));
    System.out.println("SIGMA2(6): " + sumSigma2(6, MOD));

    long start = System.nanoTime();
    long result = sumSigma2(MAX_N, MOD); //1450ms - 3200 ms on my laptop
    System.out.println("Time in milliseconds: " + (System.nanoTime() - start) / 1e6);
    System.out.println(new Object() {}.getClass().getEnclosingClass().getSimpleName() + ": " + result);
  }

  private static long sumSigma2(Number n, long mod) {
    long result = 0, number = n.longValue(), lim = (long) Math.sqrt(number);
    long ssqNiMemoize, ssqNi = Util.sumSquares1ToN(number, mod);
    for (long i = 1; i <= lim; i++) {
      result = (result + (number / i) * i % mod * i) % mod;
      ssqNiMemoize = Util.sumSquares1ToN(number / (i + 1), mod);
      result = (result + (ssqNi - ssqNiMemoize) * i) % mod;
      ssqNi = ssqNiMemoize;
    }
    if (result < 0) result += mod;
    return result;
  }

}
