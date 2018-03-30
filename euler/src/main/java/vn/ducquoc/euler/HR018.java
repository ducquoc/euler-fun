package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler018</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR018 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int N, K;
    // pre-compute (array/hashmap) to deal with hundreds of testcases
    StringBuffer sb = new StringBuffer();
    DScanner in = new DScanner();
    int t = in.nextInt();

    for (int a0 = 0; a0 < t; a0++) {
      N = in.nextInt();
      // Get triangle
      final int[][] triangle = new int[N][];
      for (int n = 0; n < N; n++) {
        triangle[n] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
          triangle[n][i] = in.nextInt();
        }
      }

      // Initialize max sums to last row
      final int[] sums = new int[N];
      for (int i = 0, n = N - 1; i <= n; ++i) {
        sums[i] = triangle[n][i];
      }

      // Get max sums from bottom to top of triangle
      for (int y = N - 2; y >= 0; --y) {
        for (int x = 0; x <= y; ++x) {
          sums[x] = triangle[y][x] + Math.max(sums[x], sums[x + 1]);
        }
      }

      // Output max sum
      sb.append(String.format("%d\n", sums[0]));
    }
    System.out.println(sb.toString());

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
