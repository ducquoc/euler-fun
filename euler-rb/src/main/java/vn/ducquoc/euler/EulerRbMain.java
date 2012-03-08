package vn.ducquoc.euler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

@SuppressWarnings("restriction")
public class EulerRbMain {

  public static final String SOLVE_ME_FUNCTION = "solve_me";

  private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(EulerMain.class);

  private static final ScriptEngine SCRIPT_ENGINE = new ScriptEngineManager().getEngineByName("jruby");

  public static void main(String[] args) throws Exception {
    LOG.info("*** Solve it with S.I M.P L.E in mind. Result:");

    solveMe("001");
  }

  private static void solveMe(String problemNumber) throws Exception {
    InputStream is = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("euler" + problemNumber + ".rb");
    BufferedReader buff = new BufferedReader(new InputStreamReader(is));

    SCRIPT_ENGINE.eval(buff);
    long start = System.nanoTime();
    ((Invocable) SCRIPT_ENGINE).invokeFunction(SOLVE_ME_FUNCTION, buff);
    long end = System.nanoTime();
    LOG.info("*** Sovled in {} seconds", (end - start) / 1000000000.0);

    buff.close();
  }
}