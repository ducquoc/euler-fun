package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler014</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR014 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int t, N, K;
    DScanner in = new DScanner();
    t = in.nextInt();

    Integer[] arr = new Integer[5000001];
    Integer[] highestBelowArr = new Integer[5000001];
    Integer maxChainLengthStartIndex = 0;
    Integer maxChainLengthStartSize = 0;

    for (int j = 1; j <= 5000000; j += 1) {
      if (arr[j] == null) {
        long lastElementAdded = j;
        int chainLength = 1;
        while (lastElementAdded != 1) {
          if (lastElementAdded < arr.length
              && arr[(int) lastElementAdded] != null) {
            chainLength += arr[(int) lastElementAdded];
            chainLength -= 1;
            break;
          } else {
            lastElementAdded = (lastElementAdded & 1) == 1 ? (lastElementAdded * 3) + 1
                : lastElementAdded / 2;
            chainLength += 1;
          }
        }
        arr[j] = chainLength;
      }

      if (arr[j] >= maxChainLengthStartSize) {
        maxChainLengthStartSize = arr[j];
        maxChainLengthStartIndex = j;
      }

      highestBelowArr[j] = maxChainLengthStartIndex;
      if (j + 1 < highestBelowArr.length)
        highestBelowArr[j + 1] = maxChainLengthStartIndex;
    }

    for (int i = 0; i < t; i++) {
      N = in.nextInt();
      System.out.println(highestBelowArr[N]);
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
