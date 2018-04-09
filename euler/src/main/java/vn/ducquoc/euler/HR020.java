package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler020</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR020 {

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner(System.in);
    t = in.nextInt();

    while (t-- > 0) {
      N = in.nextInt();
      java.math.BigInteger bi = java.math.BigInteger.ONE;
      for (int j = 2; j <= N; j++) {
        bi = bi.multiply(java.math.BigInteger.valueOf(j));
      }
      System.out.println(getDigitSum(bi));
    }

    if (in != null)
      in.close();
  }

  public static long getDigitSum(java.math.BigInteger bi) {
    int digit = 0;
    long sum = 0;
    while (bi.compareTo(java.math.BigInteger.ZERO) == 1) {
      digit = bi.mod(java.math.BigInteger.valueOf(10)).intValue();
      sum += digit;
      bi = bi.divide(java.math.BigInteger.valueOf(10));
    }
    return sum;
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
