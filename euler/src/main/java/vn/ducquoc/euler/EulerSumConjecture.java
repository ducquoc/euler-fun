package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>Euler's sum-of-powers conjecture</b> was refuted by computer.
 * <p>
 * Fourth-power counter-examples:
 * <pre>
 * 958004^4 + 2175194^4 + 4145604^4 = 4224814^4
 * 26824404^4 + 153656394^4 + 187967604^4 = 206156734^4
 * 304^4 + 1204^4 + 2724^5 + 3154^4 = 3534^4
 * </pre>
 * Fifth-power attempt in this class.
 * </p>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class EulerSumConjecture {

  public static void main(String[] args) {
    long t = System.nanoTime();
    String arg0 = (args.length > 0) ? args[0] : "150";
    int n = Integer.parseInt(arg0);

    //doStraightImmediately(n); // S.I ~ 20s
    //doMorePragmatic(n);       // M.P ~ 3s
    doLessEngineering(n);     // L.E ~ 0.95s

    long t2 = System.nanoTime();
    System.out.printf("Elapsed: %.4f ms\n", (t2 - t) / 1000000.0);
  }

  private static void doStraightImmediately(int n) {// S.I
    // pre-compute to speedup time
    Map<Integer, Long> five = new HashMap<Integer, Long>();
    for (int i = 0; i <= n; i++)
      five.put(i, (long) i * i * i * i * i);
    System.out.println("Calculating... ");

    // now do exhaustive search
    for (int e = 1; e <= n; e++) {
      long e5 = five.get(e);

      for (int a = 1; a <= n; a++) {
        long a5 = five.get(a);
        for (int b = a; b <= n; b++) {
          long b5 = five.get(b);
          for (int c = b; c <= n; c++) {
            long c5 = five.get(c);
            for (int d = c; d <= n; d++) {
              long d5 = five.get(d);
              if (a5 + b5 + c5 + d5 == e5)
                System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d
                    + "^5 = " + e + "^5");// fifth-power counterexample
            }
          }
        }
      }
    }

  }

  public static void doMorePragmatic(int n) {// M.P
    // pre-compute to speedup time
    long[] five = new long[n + 1];
    for (int i = 0; i <= n; i++)
      five[i] = (long) i * i * i * i * i;
    System.out.println("Calculating... ");

    // now do exhaustive search
    for (int e = 1; e <= n; e++) {
      long e5 = five[e];

      for (int a = 1; a <= n; a++) {
        long a5 = five[a];
        for (int b = a; b <= n; b++) {
          long b5 = five[b];
          for (int c = b; c <= n; c++) {
            long c5 = five[c];
            for (int d = c; d <= n; d++) {
              long d5 = five[d];
              if (a5 + b5 + c5 + d5 == e5)
                System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d
                    + "^5 = " + e + "^5");// fifth-power counterexample
            }
          }
        }
      }
    }

  }

  public static void doLessEngineering(int n) {// L.E
    // pre-compute to speedup time
    long[] five = new long[n + 1];
    for (int i = 0; i <= n; i++)
      five[i] = (long) i * i * i * i * i;
    System.out.println("Calculating... ");

    // now do exhaustive search
    for (int e = 1; e <= n; e++) {
      long e5 = five[e];

      // restrict search to a <= b <= c <= d <= e
      for (int a = 1; a <= n; a++) {
        long a5 = five[a];
        if (a5 + a5 + a5 + a5 > e5)
          break;

        for (int b = a; b <= n; b++) {
          long b5 = five[b];
          if (a5 + b5 + b5 + b5 > e5)
            break;

          for (int c = b; c <= n; c++) {
            long c5 = five[c];
            if (a5 + b5 + c5 + c5 > e5)
              break;

            for (int d = c; d <= n; d++) {
              long d5 = five[d];
              if (a5 + b5 + c5 + d5 > e5)
                break;
              if (a5 + b5 + c5 + d5 == e5)
                System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d
                    + "^5 = " + e + "^5");// fifth-power counterexample
            }
          }
        }
      }
    }

  }

}
