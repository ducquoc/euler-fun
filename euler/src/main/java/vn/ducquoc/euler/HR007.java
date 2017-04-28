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
public class HR007 {

  public static void main(String[] args) {
    long N;
    DScanner in = new DScanner();
    int t = in.nextInt();

    int[] primesNth = primeNth(10001);// max N
    for (int a0 = 0; a0 < t; a0++) {
      N = in.nextInt();
      System.out.println(primesNth[(int) N]);
    }

    if (in != null)
      in.close();
  }

  /**
   * @param primeOrder
   * @return prime numbers at the order (-th) up to primeOrder
   */
  public static int[] primeNth(Number primeOrder) {
    int n = primeOrder.intValue();
    int[] primesNth = new int[n + 1];
    primesNth[0] = 1;// natural index: primesNth[1]=2;
    for (int i = 1, num = 2; i <= n; num++) {
      if (isPrime(num)) {
        primesNth[i] = num;
        i++;
      }
    }
    return primesNth;
  }

  public static boolean isPrime(long number) {
    if (number < 2)
      return false;

    double sqrtNumber = Math.sqrt((double) number);
    for (long i = 2; i <= sqrtNumber; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
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
