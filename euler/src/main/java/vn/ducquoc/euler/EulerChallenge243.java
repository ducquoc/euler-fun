package vn.ducquoc.euler;

/**
 * The resilience of a denominator, R(d), is defined as the ratio of its proper
 * fractions that cannot be cancelled down;
 * <p>
 * for example, R(12) = 4/11 , R(16) = 6/15, R(60) = 8/59
 * </p>
 * Finds the smallest denominator d, having a resilience R(d) < 15499/94744 .
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=243</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge243 implements EulerChallenge {

  public static final long NUMERATOR_243 = 15499;
  public static final long DENOMINATOR_243 = 94744;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long result = 0;
    long upperBound = NUMERATOR_243 * DENOMINATOR_243;
    double fractionValue = NUMERATOR_243 * 1.0 / DENOMINATOR_243;// 1.0 / 4 ;
    for (long i = 2; i < upperBound; i++) {
      double resilience = (resilientFractions(i) * 1.0 / (i - 1));
      if (resilience < fractionValue) {
        result = i;
        break;
      }
    }

    return result;
  }

  private long doMorePragmatic() { // M.P
    long result = 0;
    long upperBound = NUMERATOR_243 * DENOMINATOR_243;
    double fractionValue = NUMERATOR_243 * 1.0 / DENOMINATOR_243;// 1.0 / 5;
    for (long i = 2*3*5; i < upperBound; i = i + 30) {
      double resilience = (phi(i) * 1.0 / (i - 1));
      if (resilience < fractionValue) {
        result = i;
        break;
      }
    }

    return result;
  }

  private long doLessEngineering() { // L.E
    long result = 0;
    long upperBound = NUMERATOR_243 * DENOMINATOR_243;
    double fractionValue = NUMERATOR_243 * 1.0 / DENOMINATOR_243;// 1.0 / 6;
    for (long i = 2*3*5*7*11; i < upperBound; i = i + 2310) {
      double resilience = (phiTotient(i) * 1.0 / (i - 1));
      if (resilience < fractionValue) {
        result = i;
        break;
      }
    }

    return result;
  }

  //
  // HELPERS
  //
  private long resilientFractions(long denominator) {
    long count = 0;
    for (long i = 1; i < denominator; i++) {
      if (Util.greatestCommonDivisor(i, denominator) == 1) {
        count = count + 1;
      }
    }
    return count;
  }

  public long phi(long number) {
    java.util.List<Long> factors = Util.distinct(Util.primeFactors(number));
    int factorsLength = factors.size(); //unnecessary to check size 0 or 1

    double totientFactor = 1;
    for (int i = 0; i < factorsLength; i++) {
      totientFactor = totientFactor * (1 - 1.0 / factors.get(i));
    }
    return (long) (totientFactor * number);
  }

  public long phiTotient(long number) {
    long result = number;
    for (int i = 2; i * i <= number; ++i) {
      if (number % i == 0) {
        result -= result / i;
      }
      while (number % i == 0)
        number /= i;
    }
    if (number > 1) {
      result -= result / number;
    }
    return result;
  }

}