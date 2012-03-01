package vn.ducquoc.euler;

/**
 * Finds the sum of all (unique) multiples of 3 and 5 below 1000.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=1</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge001 implements EulerChallenge {

  public static final long MAX_001 = 1000;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long sum = 0;
    for (int i = 3; i < MAX_001; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    return sum;
  }

  private long doMorePragmatic() { // M.P
    long sum = 0;
    for (int i = 3; i < MAX_001; i = i + 3) {
      sum += i;
    }
    for (int i = 5; i < MAX_001; i = i + 5) {
      if (i % 3 != 0) {
        sum += i;
      }
    }
    return sum;
  }

  private long doLessEngineering() { // L.E
    return sumMultiples(3, MAX_001) + sumMultiples(5, MAX_001) - sumMultiples(15, MAX_001);
  }

  //
  // HELPERS
  //
  private long sumMultiples(long divisor, long upperBound) {
    return divisor * sum1ToN(upperBound / divisor);
  }

  private long sum1ToN(long number) {
    return number * (number - 1) / 2;
  }

}
