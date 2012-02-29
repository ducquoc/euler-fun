package vn.ducquoc.euler;

public class EulerMain {

  public static void main(String[] args) {
    EulerChallenge problem = new EulerChallenge001();

    EulerThread thread = new EulerThread(problem);

    thread.run();
  }

}
