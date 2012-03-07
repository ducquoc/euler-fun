package vn.ducquoc.euler;

/**
 * Finds the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=6</a>
 */
//@SuppressWarnings("unused")
public class EulerChallenge006 implements EulerChallenge {

  public static final long MAX_006 = 100L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long sumSquares = 0;
    long sum = 0;
    for (int i = 1; i <= MAX_006; i++) {
      sum += i;
      sumSquares += (i * i);
    }
    return sum * sum - sumSquares;
  }

  private long doMorePragmatic() { // M.P
    return doStraightImmediately();
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

}
