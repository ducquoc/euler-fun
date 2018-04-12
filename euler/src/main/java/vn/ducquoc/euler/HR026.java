package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler026</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR026 {

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();
    // pre-compute for many testcases (using array/hashmap)
    int[] cycleLengths = new int[10000];

    int maxSize = 0;
    int maxD = 0;
    for (int j = 3; j < 10000; j++) {
      if (isPrime(j) && j % 2 != 0) {
        HashMap<Integer, Integer> seenRemainders = new HashMap<Integer, Integer>();
        int num = 1;
        int remainder = num % j;
        while (!seenRemainders.containsKey(remainder)) {
          seenRemainders.put(remainder, num);
          num = remainder * 10;
          remainder = num % j;
        }
        if (seenRemainders.size() > maxSize) {
          maxSize = seenRemainders.size();
          maxD = j;
        }
        cycleLengths[j] = maxD;
      } else {
        cycleLengths[j] = maxD;
      }
    }
    while (t-- > 0) {
      N = in.nextInt();
      System.out.println(cycleLengths[N - 1]);
    }

    if (in != null)
      in.close();
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
