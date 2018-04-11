package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler024</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR024 {

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();
    // pre-compute for many testcases
    String s = "abcdefghijklm";
    HashMap<Long, String> permutationMap = new HashMap<Long, String>();
    while (t-- > 0) {
      long n = in.nextLong();
      if (n == 1)
        System.out.println(s);
      else {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < s.length(); j++)
          list.add((int) s.charAt(j));

        StringBuilder sb = new StringBuilder();
        long remain = n - 1;
        for (int k = 1; k < s.length(); k++) {
          long j = remain / factorial(s.length() - k);
          remain = remain % factorial(s.length() - k);
          sb.append((char) (int) list.get((int) j));
          list.remove((int) j);

          if (remain == 0)
            break;
        }

        for (int k = 0; k < list.size(); k++)
          sb.append((char) (int) list.get((int) k));
        System.out.println(sb);
      }
    }

    if (in != null)
      in.close();
  }

  public static long factorial(long n) {
    long fact = 1L;
    for (long i = 2L; i <= n; i++)
      fact *= i;
    return fact;
  }

  public static String getNextPermutation(int[] arr) {
    int i = arr.length - 1;
    while (i > 0 && arr[i - 1] >= arr[i])
      i--;

    if (i > 0) {
      int j = arr.length - 1;
      while (arr[j] <= arr[i - 1])
        j--;

      int temp = arr[i - 1];
      arr[i - 1] = arr[j];
      arr[j] = temp;

      j = arr.length - 1;
      while (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    i = 0;
    StringBuilder sb = new StringBuilder();
    for (; i < arr.length; i++)
      sb.append((char) arr[i]);

    return new String(sb);
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
