package vn.ducquoc.euler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 * </p>
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=007</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge007 implements EulerChallenge {

  public static final long MAX_007 = 10001L;

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    int[] primesNth = Util.primeNth(MAX_007);

    return primesNth[(int) MAX_007];
  }

  private long doMorePragmatic() { // M.P
    return doStraightImmediately();
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

}