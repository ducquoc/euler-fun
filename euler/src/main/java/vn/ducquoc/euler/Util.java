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

  public static long greatestCommonDivisor(long a, long b) {
    if (b == 0)
      return a;
    return greatestCommonDivisor(b, a % b);
  }

  public static long lowestCommonMultiple(long a, long b) {
    return a * b / greatestCommonDivisor(a, b);
  }

  public static List<Long> distinct(List<Long> source) {
    List<Long> dest = new ArrayList<Long>();
    for (int i = 0; i < source.size() ; i++) {
      Long num = source.get(i);
      if (!dest.contains(num)) {
        dest.add(num);
      }
    }
    return dest;
  }

//  public static void main(String[] args) {
//    System.out.println(lowestCommonMultiple(0, 1));
//    System.out.println(lowestCommonMultiple(1, 9));
//    System.out.println(lowestCommonMultiple(7, 90));
//    System.out.println(lowestCommonMultiple(35, 90));
//    System.out.println(lowestCommonMultiple(-2, 90));
//  }

}
