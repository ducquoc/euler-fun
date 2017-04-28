package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler003</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR003 {

  public static void main(String[] args) {
    long N;
    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    try {
      int t = Integer.valueOf(readLn(buff));// prefer valueOf over parseInt

      while (t-- > 0) {
        N = Long.valueOf(readLn(buff));
        long i = 2;
        while (i <= Math.sqrt(N)) {
          if (N % i == 0) {
            while (N % i == 0) {
              N /= i;
            }
            if (N == 1) {
              N = i;
              break;
            }
          } else {
            i++;
          }
        }
        System.out.println(N);
      }

      if (buff != null)
        buff.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
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
