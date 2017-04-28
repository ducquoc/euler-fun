package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler007</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR010 {

  public static void main(String[] args) {
    int N, K;
    long[] primesSum = primeSumTo(1000001);// max N
    DScanner in = new DScanner();
    int t = in.nextInt();

    for (int a0 = 0; a0 < t; a0++) {
      N = in.nextInt();
      System.out.println(primesSum[N]);
    }

    if (in != null)
      in.close();
  }

  public static boolean[] primeProbArr(Number num) {
    long n = num.longValue();
    if (n < 0)
      throw new IllegalArgumentException("Negative array size");
    boolean[] result = new boolean[(int) (n + 1)];
    if (n >= 2)
      result[2] = true;
    for (int i = 3; i <= n; i += 2)
      result[i] = true;
    // Sieve of Eratosthenes
    for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
      if (result[i]) { // Note: i * i does not overflow
        for (int j = i * i; j <= n; j += i << 1)
          result[j] = false;
      }
    }
    return result;
  }

  public static long[] primeSumTo(int n) {
    boolean[] primeCheckArr = primeProbArr(n);

    long[] primeSum = new long[primeCheckArr.length];
    for (int i = 2; i < primeCheckArr.length; i++) {
      primeSum[i] = primeSum[i - 1];
      if (primeCheckArr[i]) {
        primeSum[i] += i;
      }
    }
    return primeSum;
  }

  private static String readLn(BufferedReader buff) throws IOException {
    String line = buff.readLine();
    while (line == null || line.trim().length() == 0) {
      line = buff.readLine();
    }
    return line;
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

    long nextLong() {
      return Long.valueOf(nextToken());
    }

    double nextDouble() {
      return Double.valueOf(nextToken());
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
  }

}
