package vn.ducquoc.euler;

/**
 * Finds the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=5</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge005 implements EulerChallenge {

  public static final long MAX_005 = 20L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long commonMultiple = 1;
    for (int i = 2 ; i < MAX_005; i++) {
      commonMultiple = Util.lowestCommonMultiple(i, commonMultiple);
    }
    return commonMultiple;
  }

  private long doMorePragmatic() { // M.P
    long commonMultiple = 1;
    for (int i = 11 ; i < MAX_005; i++) {
      commonMultiple = Util.lowestCommonMultiple(i, commonMultiple);
    }
    return commonMultiple;
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

}
