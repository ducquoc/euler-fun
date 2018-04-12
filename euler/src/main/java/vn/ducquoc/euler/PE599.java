package vn.ducquoc.euler;

import java.math.*;
import java.util.*;

/**
 * <h2>Distinct Colourings of a Rubik's Cube</h2>
 *
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=599</a>
 */
@SuppressWarnings("unused")
public class PE599 {

  public static long MAX_N = (long) 10;

  public static void main(String[] args) {

    System.out.println("distinctRubikCubeColors(2): " + distinctRubikCubeColors(2));

    long start = System.nanoTime();
    long result = distinctRubikCubeColors(MAX_N); //0.45 ms - 0.65 ms on my laptop
    System.out.println("Time in milliseconds: " + (System.nanoTime() - start) / 1e6);
    System.out.println(new Object() {}.getClass().getEnclosingClass().getSimpleName() + ": " + result);
  }

  private static long distinctRubikCubeColors(Number n) {
    long result = 0, number = n.longValue();
    long singleCorners3DiffColors = binomialNChooseK(number, 3) * 2; // n * (n-1) * (n-2) / 3;
    long corners2DiffColors = binomialNChooseK(number, 2) * 2; // n * (n-1);
    long sameColor = binomialNChooseK(number, 1); // n;

    long total = singleCorners3DiffColors + corners2DiffColors + sameColor;

    long allCombinations = binomialNChooseK(total+8-1, 8); // C(347,8)
    long noSameCombinations = binomialNChooseK(total+8-1-sameColor, 8); // C(347-10,8)
    result = allCombinations + 2 * noSameCombinations; // (all - same) + 3 * same;

    return result;
  }

  public static long binomialNChooseK(long n, long k) {
    long res = 1;
    long base = 1;
    for (long i = 1; i <= k; i++) base *= i;
    for (long i = 1; i <= k; i++) {
      res *= (n + 1 - i);
      long gcd = Util.greatestCommonDivisor(res, base);
      base /= gcd;
      res /= gcd;
    }
    return res;
  }

}
