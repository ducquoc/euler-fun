package vn.ducquoc.euler;

/**
 * Finds the product of the Pythagorean triplet {a, b, c}, for which<br/>
 * a + b + c = 1000.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=9</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge009 implements EulerChallenge {

  public static final long MAX_009 = 1000L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long tripletProduct = 0;
    for (long a = 1; a < MAX_009; a++) {
      for (long b = a + 1; b <= MAX_009; b++) {
        if ((a*a + b*b) == (MAX_009 - a - b)*(MAX_009 - a - b)) {
          tripletProduct = a * b * (MAX_009 - a - b);
          break;
        }
      }
    }

    return tripletProduct;
  }

  private long doMorePragmatic() { // M.P
    long tripletProduct = 0;
    long upperBoundForSmallest = MAX_009 / 3;
    long upperBoundForMiddle = MAX_009 / 2;
    for (long a = 1; a < upperBoundForSmallest; a++) {
      for (long b = a + 1; b < upperBoundForMiddle; b++) {
        if ((a*a + b*b) == (MAX_009 - a - b)*(MAX_009 - a - b)) {
          tripletProduct = a * b * (MAX_009 - a - b);
          break;
        }
      }
    }

    return tripletProduct;
  }

  private long doLessEngineering() { // L.E
    long tripletProduct = 0;
    long upperBoundForSmallest = MAX_009 / 3;
    long upperBoundForMiddle = MAX_009 / 2;
    for (long a = 1; a < upperBoundForSmallest; a++) {
      for (long b = a + 1; b < upperBoundForMiddle; b++) {
        if ((a * b) == MAX_009 * (a + b - MAX_009 / 2)) {
          tripletProduct = a * b * (MAX_009 - a - b);
          break;
        }
      }
    }

    return tripletProduct;
  }

}