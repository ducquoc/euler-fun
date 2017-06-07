package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler012</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR012 {

  public static void main(String[] args) {
    int N, K;
    DScanner in = new DScanner();
    int t = in.nextInt();
    // pre-compute with array/hashmap to deal with hundreds of testcases
    HashMap<Integer, Integer> seenFactors = new LinkedHashMap<Integer, Integer>();

    for (int a0 = 0; a0 < t; a0++) {
      N = in.nextInt();
      int triNumNeeded = 2;
      int s = 1; //index
      while (s <= triNumNeeded) {
        int n = (s * (s + 1)) / 2;
        int factorsCount = 0;
        if (!seenFactors.containsKey(n)) {
          factorsCount = factorize(n);
          seenFactors.put(n, factorsCount);
        } else {
          factorsCount = seenFactors.get(n);
        }
        if (factorsCount > N) {
          System.out.println(n);
          break;
        } else if (factorsCount <= N) {
          triNumNeeded += 2;
        }
        s += 1;
      }
    }

    if (in != null)
      in.close();
  }

  public static int countFactors(Number num) {
    int n = num.intValue();
    int factors = 0;

    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0)
        factors += 2;
      if (i * i == n)
        factors -= 1;
    }

    return factors;
  }

  public static int factorize(Number number) {
    Integer n = number.intValue();
    int exponentProduct = 1;
    try {
      List<Integer> list = new ArrayList<Integer>();
      HashMap<Integer, Integer> exponentCount = new HashMap<Integer, Integer>();

      for (int i = 2; i <= n / i; i++) {
        while (n % i == 0) {
          list.add(i);
          n /= i;
        }
      }
      if (n > 1)
        list.add(n);

      //System.out.println(Arrays.toString(list.toArray()));
      for (int i = 0, s = list.size(); i < s; i++) {
        if (!exponentCount.containsKey(list.get(i))) {
          exponentCount.put(list.get(i), 1);
        } else {
          int currentCount = exponentCount.get(list.get(i));
          exponentCount.put(list.get(i), currentCount + 1);
        }
      }

      for (Map.Entry<Integer, Integer> entry : exponentCount.entrySet()) {
        exponentProduct *= entry.getValue() + 1;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return exponentProduct;
  }

  public static long sum1ToN(long number) {
    return number * (number + 1) / 2;
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
