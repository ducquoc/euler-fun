package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler017</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR017 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();

    while (t-- > 0) {
      long n = in.nextLong();
      String sr = String.valueOf(n);
      int numberOfGroups = 0;
      if (sr.length() % 3 == 0)
        numberOfGroups = sr.length() / 3;
      else
        numberOfGroups = sr.length() / 3 + 1;
      int groupsForPrinting = numberOfGroups;
      int len = sr.length();
      StringBuilder sb = null;
      Stack<String> finalStack = new Stack<String>();
      while (numberOfGroups != 0) {
        sb = new StringBuilder();
        if (len - 3 >= 0)
          sb.append(sr.charAt(len - 3));
        if (len - 2 >= 0)
          sb.append(sr.charAt(len - 2));
        if (len - 1 >= 0)
          sb.append(sr.charAt(len - 1));
        finalStack.push(new String(sb));

        len -= 3;
        numberOfGroups -= 1;
      }
      while (!finalStack.isEmpty()) {
        int val = Integer.valueOf(finalStack.pop());
        if (val != 0) {
          Stack<String> s = getWordsLessThanThousand(val);
          if (s != null)
            printStack(s);
          if (groupsForPrinting == 5)
            System.out.print("Trillion ");
          if (groupsForPrinting == 4)
            System.out.print("Billion ");
          if (groupsForPrinting == 3)
            System.out.print("Million ");
          if (groupsForPrinting == 2)
            System.out.print("Thousand ");
        }
        groupsForPrinting -= 1;
      }
      System.out.println();
    }

    if (in != null)
      in.close();
  }

  public static String[] numNames = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  public static String[] tensNames = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  public static Stack<String> getWordsLessThanThousand(long n) {
    Stack<String> s = null;
    if (n < numNames.length)
      System.out.print(numNames[(int) n] + " ");
    else if (n / 10 < 10 && n % 10 == 0)
      System.out.print(tensNames[(int) n / 10] + " ");
    else {
      long num = n;
      int index = 1;
      s = new Stack<String>();
      boolean firstMod = false;
      while (num != 0) {
        if (num % 100 < numNames.length && !firstMod) {
          int digit = (int) num % 100;
          if (index == 100) {
            s.push("Hundred");
            s.push(numNames[digit]);
          } else
            s.push(numNames[digit]);
          index *= 100;
          num /= 100;
        } else {
          firstMod = true;
          int digit = (int) num % 10;
          if (index < 10) {
            s.push(numNames[digit]);
          }
          if (index == 10)
            s.push(tensNames[digit]);
          if (index == 100) {
            s.push("Hundred");
            s.push(numNames[digit]);
          }
          num /= 10;
          index *= 10;
        }
      }
    }

    return s;
  }

  public static void printStack(Stack<String> s) {
    while (!s.isEmpty()) {
      String str = s.pop();
      if (!str.equals(""))
        System.out.print(str + " ");
    }
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
