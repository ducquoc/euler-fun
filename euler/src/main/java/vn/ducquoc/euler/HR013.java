package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler013</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR013 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int N, K;
    DScanner in = new DScanner();

    N = in.nextInt();
    java.math.BigInteger sum = java.math.BigInteger.ZERO;
    for (int i = 0; i < N; i++) {
      java.math.BigInteger bi = new java.math.BigInteger(in.nextToken());
      sum = sum.add(bi);
    }

    System.out.println(sum.toString().substring(0, 10));

    if (in != null)
      in.close();
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
