package vn.ducquoc.euler;

/**
 * Finds the sum of the even-valued terms in Fibonacci sequence
 * <p>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * </p>
 * whose values do not exceed 4000000.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=2</a>
 */
//@SuppressWarnings("unused")
public class EulerChallenge002 implements EulerChallenge {

  public static final long MAX_002 = 4000000L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long sum = 0;
    long firstFibo = 1;
    long secondFibo = 2;
    while (firstFibo < MAX_002) {
      if (firstFibo % 2 == 0) {
        sum += firstFibo;
      }
      long thirdFibo = firstFibo + secondFibo;
      firstFibo = secondFibo;
      secondFibo = thirdFibo;
    }
    return sum;
  }

  private long doMorePragmatic() { // M.P
    return doStraightImmediately();
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

}
