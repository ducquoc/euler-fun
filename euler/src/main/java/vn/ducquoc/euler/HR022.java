package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler022</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR022 {

  static HashMap<Character, Integer> alphabetMap;
  static {
    alphabetMap = new HashMap<Character, Integer>();
    for (int i = 97; i <= 122; i++)
      alphabetMap.put((char) i, i - 96);
  }

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();

    ArrayList<String> namesList = new ArrayList<String>();
    for (int i = 0; i < t; i++)
      namesList.add(in.next().toLowerCase());
    Collections.sort(namesList);

    HashMap<String, Integer> indexInSortedListMap = new HashMap<String, Integer>();
    for (int i = 0; i < namesList.size(); i++)
      indexInSortedListMap.put(namesList.get(i), i + 1);

    HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
    for (int i = 0; i < namesList.size(); i++) {
      int sum = 0;
      String s = namesList.get(i);
      for (int j = 0; j < s.length(); j++) {
        sum += alphabetMap.get(s.charAt(j));
      }
      scoreMap.put(s, sum * indexInSortedListMap.get(s));
    }

    int q = in.nextInt();
    for (int i = 0; i < q; i++)
      System.out.println(scoreMap.get(in.next().toLowerCase()));

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

    long nextLong() {
      return Long.valueOf(next());
    }

    double nextDouble() {
      return Double.valueOf(next());
    }

  }

}
