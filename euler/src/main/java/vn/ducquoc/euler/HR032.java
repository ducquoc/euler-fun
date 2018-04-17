package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler032</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR032 {

  public static void main(String args[]) {
    int t, N, K, M;
    DScanner in = new DScanner(System.in);

    t = in.nextInt();
    // pre-compute
    long endVal = (long) Math.pow(10, t) - 1;
    int end = (int) Math.sqrt(endVal);
    HashMap<Integer, Integer> nMap = new HashMap<Integer, Integer>();
    for (int i = 1; i <= t; i++)
      nMap.put(i, 0);
    long productSum = 0;

    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 1; i <= end; i++) {
      for (int j = i; j <= end; j++) {
        int product = i * j;
        int iLength = Integer.toString(i).length();
        int jLength = Integer.toString(j).length();
        int productLength = Integer.toString(product).length();
        if (iLength + jLength + productLength == t) {
          if (isPanDigital(i, j, product, nMap))
            set.add(product);
        } else if (iLength + jLength + productLength > t)
          break;
      }
    }
    for (Integer i : set)
      productSum += i;

    System.out.println(productSum);
  }

  public static boolean isPanDigital(int i, int j, int product,
      HashMap<Integer, Integer> nMap) {
    HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    while (i != 0) {
      int digit = i % 10;
      if (!countMap.containsKey(digit) && nMap.containsKey(digit)) {
        countMap.put(digit, 1);
        i /= 10;
      } else
        return false;
    }
    while (j != 0) {
      int digit = j % 10;
      if (!countMap.containsKey(digit) && nMap.containsKey(digit)) {
        countMap.put(digit, 1);
        j /= 10;
      } else
        return false;
    }
    while (product != 0) {
      int digit = product % 10;
      if (!countMap.containsKey(digit) && nMap.containsKey(digit)) {
        countMap.put(digit, 1);
        product /= 10;
      } else
        return false;
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

    //long nextLong() { return Long.valueOf(next()); }
    //double nextDouble() { return Double.valueOf(next()); }
    //String nextLine() throws IOException { return br.readLine(); }
  }

}
