package vn.ducquoc.euler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Finds the minimal path sum, in matrix.txt (80 by 80 matrix), from the top
 * left to the bottom right by only moving right and down.
 * 
 * @author ducquoc
 * @see <a>http://projecteuler.net/problem=81</a>
 */
@SuppressWarnings("unused")
public class EulerChallenge081 implements EulerChallenge {

  public static final int SIZE_081 = 80;
  public static final String FILENAME_081 = "matrix.txt";

  public void solveMe() {
    System.out.println(doLessEngineering());
  }

  private long doStraightImmediately() { // S.I
    long minSum = 0;
    long[][] matrix = loadFileToMatrix(SIZE_081, SIZE_081, FILENAME_081);

    long[][] costMatrix = new long[SIZE_081][SIZE_081];
    costMatrix[0][0] = matrix[0][0];
    for (int i = 1; i < SIZE_081; i++) {
      costMatrix[i][0] = matrix[i][0] + costMatrix[i - 1][0]; // calc "down"
      costMatrix[0][i] = matrix[0][i] + costMatrix[0][i - 1]; // calc "right"
    }
    for (int i = 1; i < SIZE_081; i++) {
      for (int j = 1; j < SIZE_081; j++) {
        costMatrix[i][j] = matrix[i][j] + Math.min(costMatrix[i - 1][j], costMatrix[i][j - 1]);
      }
    }
    minSum = costMatrix[SIZE_081 - 1][SIZE_081 - 1];

    return minSum;
  }

  private long doMorePragmatic() { // M.P
    return doStraightImmediately();
  }

  private long doLessEngineering() { // L.E
    return doMorePragmatic();
  }

  //
  // HELPERS
  //
  private long[][] loadFileToMatrix(int rows, int cols, String filepath) {
    long[][] array2d = new long[rows][cols];
    String line = "";
    String[] terms = new String[cols];
    try {
      //prefer Resource (InputStreamReader) over File (FileReader), no "/"
      InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
      BufferedReader buff = new BufferedReader(new InputStreamReader(new DataInputStream(is)));
      for (int i = 0; i < rows && (line = buff.readLine()) != null; i++) {
        terms = line.split(",");
        for (int j = 0; j < cols; j++) {
          array2d[i][j] = Long.valueOf(terms[j]);
        }
      }
      buff.close();
    } catch (IOException ex) {
      throw new IllegalArgumentException(ex.getMessage(), ex);
    }
    return array2d;
  }

}
