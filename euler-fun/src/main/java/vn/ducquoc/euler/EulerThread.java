package vn.ducquoc.euler;

public class EulerThread implements Runnable {

  private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(EulerThread.class);

  private EulerChallenge eulerProblem;

  public EulerThread(EulerChallenge eulerProblem) {
    this.eulerProblem = eulerProblem;
  }

  public void run() {

    LOG.debug("111 Start solving challenge");

    long start = System.nanoTime();
    eulerProblem.solveMe();
    long end = System.nanoTime();

    LOG.debug("222 End solving challenge");

    long diff = end - start;
    double seconds = (double) diff / 1000000000.0;
    LOG.info(String.format("*** Sovled in %s seconds", seconds));
  }

}