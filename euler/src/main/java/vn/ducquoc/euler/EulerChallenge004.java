package vn.ducquoc.euler;

/**
 * Finds the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=4</a>
 */
//@SuppressWarnings("unused")
public class EulerChallenge004 implements EulerChallenge {

  public static final long MAX_004 = 1000L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long maxProduct = 0;
    long lowerBound = MAX_004 / 10;
    for (long i = MAX_004 - 2; i > lowerBound; i--) {
      for (long j = MAX_004 - 1; j > i; j--) {
        if (i * j > maxProduct && Util.isPalindrome(String.valueOf(i * j))) {
          maxProduct = i * j;
        }
      }
    }
    return maxProduct;
  }

  private long doMorePragmatic() { // M.P
    return doStraightImmediately();
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

}
