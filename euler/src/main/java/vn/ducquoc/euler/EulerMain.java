package vn.ducquoc.euler;

public class EulerMain {

  private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(EulerMain.class);

  public static void main(String[] args) {
    EulerChallenge problem = new EulerChallenge001();

    if (args.length > 0) {
      String problemClass = EulerChallenge.class.getCanonicalName() + args[0];
      try {
        problem = (EulerChallenge) Class.forName(problemClass).newInstance();
      }
      catch (Exception ex) {
        LOG.warn("Wrong number or unable to solve. Now solving: 001");
      }
    }

    LOG.info("*** Solve it with S.I M.P L.E in mind. Result:");
    new EulerThread(problem).run();
  }

}
