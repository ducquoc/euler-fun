package vn.ducquoc.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for solving the problems in <b>ProjectEuler</b>.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net</a>
 */
public class Util {

  public static long sum1ToN(long number) {
    return number * (number - 1) / 2;
  }

  public static long sumMultiples(long divisor, long upperBound) {
    return divisor * sum1ToN(upperBound / divisor);
  }

  public static boolean isPrime(long number) {
    if (number < 2)
      return false;

    double sqrtNumber = Math.sqrt((double) number);
    for (long i = 2; i <= sqrtNumber; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static List<Long> primeFactors(long number) {
    List<Long> factors = new ArrayList<Long>();
    for (long i = 2; i <= number; i++) {
      while (number % i == 0) {
        factors.add(i);
        number = number / i;
      }
    }
    return factors;
  }

//  public static void main(String[] args) {
//    System.out.println(primeFactors(0));
//    System.out.println(primeFactors(1));
//    System.out.println(primeFactors(2));
//    System.out.println(primeFactors(3));
//    System.out.println(primeFactors(4));
//    System.out.println(primeFactors(5));
//    System.out.println(primeFactors(6));
//    System.out.println(primeFactors(7));
//    System.out.println(primeFactors(8));
//    System.out.println(primeFactors(9));
//    System.out.println(primeFactors(100));
//    System.out.println(primeFactors(-1));
//  }

}
