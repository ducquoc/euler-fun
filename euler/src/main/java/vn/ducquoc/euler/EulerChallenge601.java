package vn.ducquoc.euler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.*;

/**
 * <h2>Divisibility streaks</h2>
 *
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=601</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge601 implements EulerChallenge {

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long result = 0;
    for (int i = 1; i <= 31; i++) {
      result += p(i, (long) Math.pow(4, i));
    }

    return result;
  }

  private long doMorePragmatic() { // M.P
    long result = 0;
    result = doStraightImmediately();

    return result;
  }

  private long doLessEngineering() { // L.E
    long result = 0;
    result = doMorePragmatic();

    return result;
  }

  //
  // HELPERS
  //
  public static void main(String[] args) {
    // quick debug
    System.out.println("p(3,14)=" + p(3, 14));
    System.out.println("p(6,10^6)=" + p(6, (long) Math.pow(10, 6)));
  }

  private static long p(long numberOfStreaksS, long upperBoundN) {
    long lcm = 1;
    for (long i = 1; i < numberOfStreaksS + 1; i++) {
      lcm = Util.lowestCommonMultiple(lcm, i);
    }
    upperBoundN = upperBoundN - 2; //tricky, without " - 2" the p(6,10^6) still correct but p(i,4^i) not correct
    return (upperBoundN) / lcm - (upperBoundN) / Util.lowestCommonMultiple(lcm, numberOfStreaksS + 1);
  }

}
