package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler023</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR023 {

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();
    //pre-compute for many testcases
    Map<Integer, Long> amicableNumbersMap = new LinkedHashMap<Integer, Long>();
    for (int j = 0; j <= 100000; j++) {
      long sumOfDivisors = sumProperDivisors(j);
      if (sumOfDivisors > j)
        amicableNumbersMap.put(j, sumOfDivisors);
    }
    while (t-- > 0) {
      long n = in.nextLong();
      boolean pairFound = false;
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int j = 0; j <= n; j++) {
        if (amicableNumbersMap.containsKey(j))
          list.add(j);
      }

      for (int k = 0; k < list.size(); k++) {
        for (int l = k; l < list.size(); l++) {
          if (list.get(k) + list.get(l) == n) {
            pairFound = true;
            break;
          }
        }
        if (pairFound)
          break;
      }
      if (pairFound)
        System.out.println("YES");
      else
        System.out.println("NO");
    }

    if (in != null)
      in.close();
  }

  public static long sumProperDivisors(long n) {
    if (n <= 1)
      return n;

    int maxD = (int) Math.sqrt(n);
    long sum = 1;
    for (int i = 2; i <= maxD; i++) {
      if (n % i == 0) {
        sum += i;
        long d = n / i;
        if (d != i)
          sum += d;
      }
    }
    return sum;
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
