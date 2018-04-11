package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler025</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR025 {

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();
    // pre-compute for many testcases

    while (t-- > 0) {
      N = in.nextInt();
      if (N == 1)
        System.out.println(1);
      else {
        int numberOfDigitsEncountered = 0;
        int nthFibonacci = 1;
        while (numberOfDigitsEncountered < N) {
          double rootFive = Math.sqrt(5);
          double logFiveOverTwo = Math.log10(rootFive);
          double digits = nthFibonacci * Math.log10((1 + rootFive) / 2)
              - logFiveOverTwo;
          int ds = (int) digits + 1;
          if (ds == N)
            break;
          numberOfDigitsEncountered = ds;
          nthFibonacci += 1;
        }
        System.out.println(nthFibonacci);
      }
    }

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

    long nextLong() {
      return Long.valueOf(next());
    }

    double nextDouble() {
      return Double.valueOf(next());
    }

  }

}
