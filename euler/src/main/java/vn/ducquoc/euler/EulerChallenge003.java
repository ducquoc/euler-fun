package vn.ducquoc.euler;

/**
 * Finds the largest prime factor of the number 600851475143.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=3</a>
 */
//@SuppressWarnings("unused")
public class EulerChallenge003 implements EulerChallenge {

  public static final long MAX_003 = 600851475143L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    java.util.List<Long> factors = Util.primeFactors(MAX_003);

    return factors.get(factors.size() - 1);
  }

  private long doMorePragmatic() { // M.P
    return doStraightImmediately();
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

}
