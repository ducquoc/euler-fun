package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler015</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR015 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();

    while (t-- > 0) {
      N = in.nextInt();
      M = in.nextInt();
      java.math.BigInteger nPlusMfact = bigFactorial(N + M);
      java.math.BigInteger nFact = bigFactorial(N);
      java.math.BigInteger mFact = bigFactorial(M);
      java.math.BigInteger nFactIntoMFact = nFact.multiply(mFact);
      java.math.BigInteger res = nPlusMfact.divide(nFactIntoMFact);
      java.math.BigInteger modVal = java.math.BigInteger.valueOf(1000000007);
      System.out.println(res.mod(modVal));
    }

    if (in != null)
      in.close();
  }

  public static java.math.BigInteger bigFactorial(int n) {
    java.math.BigInteger fact = java.math.BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      fact = fact.multiply(java.math.BigInteger.valueOf(i));
    }
    return fact;
  }

  public static class DScanner {// Dummy Scanner not DqScanner
    java.io.BufferedReader br;
    java.util.StringTokenizer st;

    public DScanner() {
      br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    }

    public DScanner(java.io.InputStream is) {// file/resource
      br = new java.io.BufferedReader(new java.io.InputStreamReader(
          new java.io.DataInputStream(is)));
    }

    public String nextToken() {// no nextLine() : prefer br.readLine()
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new java.util.StringTokenizer(br.readLine());
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.valueOf(nextToken());
    }

    public void close() {
      if (br != null) {
        try {
          br.close();
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
      }
    }

    long nextLong() {
      return Long.valueOf(nextToken());
    }

    double nextDouble() {
      return Double.valueOf(nextToken());
    }

  }

}
