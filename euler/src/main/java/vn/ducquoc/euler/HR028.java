package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler028</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR028 {

  public static void main(String args[]) {
    int t, N, K, M;
    DScanner in = new DScanner(System.in);

    t = in.nextInt();
    while (t-- >0) {
      java.math.BigInteger n = new java.math.BigInteger(in.next());
      n = n.subtract(java.math.BigInteger.ONE);
      n = n.divide(java.math.BigInteger.valueOf(2));

      java.math.BigInteger p1 = n.pow(3);
      p1 = p1.multiply(java.math.BigInteger.valueOf(16));
      java.math.BigInteger p2 = n.pow(2);
      p2 = p2.multiply(java.math.BigInteger.valueOf(30));
      java.math.BigInteger p3 = n.multiply(java.math.BigInteger.valueOf(26));
      java.math.BigInteger res = p1.add(p2).add(p3).add(java.math.BigInteger.valueOf(3));
      res = res.divide(java.math.BigInteger.valueOf(3));
      System.out.println(res.mod(java.math.BigInteger.valueOf(1000000007)));
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
