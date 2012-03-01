package vn.ducquoc.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds the product of the Pythagorean triplet {a, b, c}, for which<br/>
 * a + b + c = 1000.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=9</a>
 */
 @SuppressWarnings("unused")
public class EulerChallenge027 implements EulerChallenge {

  public static final long MAX_027 = 1000L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long resultProduct = 0;
    int mostConsecutivePrimeNum = 0;
    for (long a = 1 - MAX_027; a < MAX_027; a++) {
      for (long b = 1 - MAX_027; b < MAX_027; b++) {
        int consecutivePrimeNums = quaraticConsecutivePrimes(a, b).size();
        if (mostConsecutivePrimeNum < consecutivePrimeNums) {
          mostConsecutivePrimeNum = consecutivePrimeNums;
          resultProduct = a * b;
        }
      }
    }

    return resultProduct;
  }

  private long doMorePragmatic() { // M.P
    long resultProduct = 0;
    int mostConsecutivePrimeNum = 0;
    for (long b = 0; b < MAX_027; b++) {
      if (Util.isPrime(b) == false) {
        break;
      }
      for (long a = 1 - MAX_027; a < MAX_027; a++) {
        int consecutivePrimeNums = quaraticConsecutivePrimes(a, b).size();
        if (mostConsecutivePrimeNum < consecutivePrimeNums) {
          mostConsecutivePrimeNum = consecutivePrimeNums;
          resultProduct = a * b;
        }
      }
    }

    return resultProduct;
  }

  private long doLessEngineering() { // L.E
    long resultProduct = 0;
    int mostConsecutivePrimeNum = 0;
    for (long b = 0; b < MAX_027; b++) {
      if (Util.isPrime(b) == false) {
        break;
      }
      for (long a = 1 - MAX_027; a < MAX_027; a = a + 2) {
        int consecutivePrimeNums = quaraticConsecutivePrimes(a, b).size();
        if (mostConsecutivePrimeNum < consecutivePrimeNums) {
          mostConsecutivePrimeNum = consecutivePrimeNums;
          resultProduct = a * b;
        }
      }
    }

    return resultProduct;
  }

  //
  // HELPERS
  //
  private List<Long> quaraticConsecutivePrimes(long a, long b) {
    List<Long> result = new ArrayList<Long>();
    long quadraticValue = 0;
    for (int i = 0; i < 1000; i++) {
      quadraticValue = i * i + a * i + b;
      if (Util.isPrime(quadraticValue) == false) {
        break;
      }
      result.add(quadraticValue);
    }
    return result;
  }
}