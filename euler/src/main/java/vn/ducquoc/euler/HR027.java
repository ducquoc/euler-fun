package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler027</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR027 {

  public static boolean[] prime = generatePrimes(
      (int) Math.ceil(Math.sqrt(10000000)), 10000000);

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();
    // pre-compute for many testcases (using array/hashmap)
    int maxPrimesEncountered = 0;
    int maxA = 0;
    int maxB = 0;

    for (int a = t * -1; a <= t; a++) {
      for (int b = 2; b <= t; b++) {
        if (b > 0 && a * b < 0 && prime[b] && (1 + a + b) % 2 != 0) {
          int primeCount = getPrimeCount(a, b, t);

          if (primeCount > maxPrimesEncountered) {
            maxPrimesEncountered = primeCount;
            maxA = a;
            maxB = b;
          }
        }
      }
    }
    System.out.println(maxA + " " + maxB);

    if (in != null)
      in.close();
  }

  public static boolean[] generatePrimes(int root, int limit) {
    boolean[] prime = new boolean[limit + 1];
    prime[2] = true;
    prime[3] = true;

    // Sieve of Atkin for prime number generation
    for (int x = 1; x < root; x++) {
      for (int y = 1; y < root; y++) {
        int n = 4 * x * x + y * y;
        if (n <= limit && (n % 12 == 1 || n % 12 == 5))
          prime[n] = !prime[n];

        n = 3 * x * x + y * y;
        if (n <= limit && n % 12 == 7)
          prime[n] = !prime[n];

        n = 3 * x * x - y * y;
        if ((x > y) && (n <= limit) && (n % 12 == 11))
          prime[n] = !prime[n];
      }
    }

    for (int i = 5; i <= root; i++) {
      if (prime[i]) {
        for (int j = i * i; j < limit; j += i * i) {
          prime[j] = false;
        }
      }
    }

    return prime;
  }

  public static int getPrimeCount(int a, int b, int num) {
    int primeCount = 0;
    for (int n = 0; n < num; n++) {
      int nSquared = (int) Math.pow(n, 2);
      int res = nSquared + n * a + b;
      if (res > 0 && prime[res])
        primeCount += 1;
      else
        break;
    }
    return primeCount;
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
