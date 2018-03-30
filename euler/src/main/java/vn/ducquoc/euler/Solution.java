package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler011</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class Solution {

  public static void main(String[] args) {
    int N, K, J, I;
    DScanner in = new DScanner();

    int[][] grid = new int[26][26];//board with extra size
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        if (i >= 3 && i <= 22 && j >= 3 && j <= 22) {
          grid[i][j] = in.nextInt();
        }
      }
    }
    //System.out.println(Arrays.deepToString(grid));
    long max = 0;
    for (int i = 3; i < 23; i++) {
      for (int j = 3; j < 23; j++) {
        if (grid[i][j] == 0)
          continue;
        max = Math.max(max, grid[i][j] * grid[i][j + 1] * grid[i][j + 2]
            * grid[i][j + 3]);//left-right
        max = Math.max(max, grid[i][j] * grid[i + 1][j] * grid[i + 2][j]
            * grid[i + 3][j]);//top-down
        max = Math.max(max, grid[i][j] * grid[i + 1][j + 1]
            * grid[i + 2][j + 2] * grid[i + 3][j + 3]);//topleft-downright
        max = Math.max(max, grid[i][j] * grid[i + 1][j - 1]
            * grid[i + 2][j - 2] * grid[i + 3][j - 3]);//topright-downleft
      }
    }
    System.out.println(max);

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

    // long nextLong() { return Long.valueOf(next()); }
    // double nextDouble() { return Double.valueOf(next()); }
    // String nextLine() throws IOException { return br.readLine(); }
  }

}
