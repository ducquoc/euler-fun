package vn.ducquoc.euler;

/**
 * Finds the sum of all (unique) multiples of 3 and 5 from 1 to 1000.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=1</a>
 */
public class EulerChallenge001 implements EulerChallenge {

  public static final long MAX_001 = 1000;

  private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(EulerChallenge001.class);

  public void solveMe() {
    LOG.info("*** Solve it with S.I M.P L.E in mind");

    long result = doStraightImmediately();

    LOG.info(String.format("*** Result is : %d", result));
  }

  private long doStraightImmediately() { //S.I
    long sum = 0;
    for (int i = 3; i < MAX_001; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    return sum;
  }

  @SuppressWarnings("unused")
  private long doMP() { //M.P
    return doStraightImmediately();
  }

  @SuppressWarnings("unused")
  private long doLE() { //L.E
    return doStraightImmediately();
  }

}
