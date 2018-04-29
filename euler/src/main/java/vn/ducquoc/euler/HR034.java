package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler034</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR034 {

  public static void main(String args[]) {
    int t, N, K, M;
    DScanner in = new DScanner(System.in);

    t = in.nextInt();
    // pre-compute
    long result = 0;
    if (t < 10)
      System.out.println(0);
    else {
      for (int i = 10; i <= t; i++) {
        int temp = i;
        java.math.BigInteger factorialSum = java.math.BigInteger.ZERO;
        while (temp != 0) {
          int digit = temp % 10;
          factorialSum = factorialSum.add(getFactorial(digit));
          temp /= 10;
        }
        if (factorialSum.mod(java.math.BigInteger.valueOf(i)).compareTo(java.math.BigInteger.ZERO) == 0)
          result += i;
      }
      System.out.println(result);
    }
  }

  public static java.math.BigInteger getFactorial(int n) {
    java.math.BigInteger bi = java.math.BigInteger.ONE;
    for (int j = 2; j <= n; j++) {
      bi = bi.multiply(java.math.BigInteger.valueOf(j));
    }
    return bi;
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
