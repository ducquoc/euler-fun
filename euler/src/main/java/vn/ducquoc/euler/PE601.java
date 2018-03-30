package vn.ducquoc.euler;

/**
 * <h2>Divisibility streaks</h2>
 *
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=601</a>
 */
@SuppressWarnings("unused")
public class PE601 {

  public static void main(String[] args) {

    System.out.println("p(3,14)=" + p(3, 14));
    System.out.println("p(6,10^6)=" + p(6, integerPow(10, 6)));
    long start = System.nanoTime();
    long result = 0;
    for (int i = 1; i <= 31; i++) { // Java 8: LongStream or IntStream faster
      result += p(i, integerPow(4, i));
    }
    System.out.println("Time in milliseconds: " + (System.nanoTime() - start) / 1e6);
    System.out.println("PE601: " + result);
  }

  private static long p(long numberOfStreaksS, long upperBoundN) {
    long lcm = 1;
    for (long i = 1; i < numberOfStreaksS + 1; i++) {
      lcm = lowestCommonMultiple(lcm, i);
    }
    // with 1 < n < N, divisible streaks, we have 1 <= n-1 <= N-2
    return (upperBoundN - 2) / lcm - (upperBoundN - 2) / lowestCommonMultiple(lcm, numberOfStreaksS + 1);
  }

  public static long lowestCommonMultiple(long a, long b) {
    return a * b / greatestCommonDivisor(a, b);
  }

  public static long greatestCommonDivisor(long a, long b) {
    return (b == 0) ? a : greatestCommonDivisor(b, a % b);
  }

  public static long integerPow(long a, long b) {
    return (b == 0) ? 1 : a * integerPow(a, b - 1);
  }

}
