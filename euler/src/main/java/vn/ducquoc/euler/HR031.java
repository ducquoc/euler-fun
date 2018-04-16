package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler031</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR031 {

  public static void main(String args[]) {
    int t, N, K, M;
    DScanner in = new DScanner(System.in);

    t = in.nextInt();
    //pre-compute
    M = 100000;
    java.math.BigInteger[] ways = new java.math.BigInteger[M + 1];
    for (int i = 1; i < ways.length; i++)
      ways[i] = java.math.BigInteger.ZERO;
    ways[0] = java.math.BigInteger.ONE;

    int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
    for (int i = 0; i < coinSizes.length; i++) {
      for (int j = coinSizes[i]; j <= M; j++) {
        ways[j] = ways[j].add(ways[j - coinSizes[i]]);
      }
    }

    for (int k = 0; k < t; k++) {
      N = in.nextInt();
      System.out.println(ways[N].mod(java.math.BigInteger.valueOf(1000000007)));
    }
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

    public String next() {// no nextLine() : prefer br.readLine()
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
      return Integer.valueOf(next());
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

    //long nextLong() { return Long.valueOf(next()); }
    //double nextDouble() { return Double.valueOf(next()); }
    //String nextLine() throws IOException { return br.readLine(); }
  }

}
