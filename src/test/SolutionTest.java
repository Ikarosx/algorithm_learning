package test;

import common.BasicQuestion;
import common.IQuestion;
import common.TimeCalcAop;
import common.TimeType;
import org.junit.jupiter.api.Test;
import simple.String_13;

import java.lang.reflect.Proxy;

/** @author x5322 */
public class SolutionTest {
  @Test
  void mySolution() {
	  TimeCalcAop timeCalcAop = new TimeCalcAop(new String_13());
	  IQuestion iQuestion = (IQuestion) Proxy.newProxyInstance(String_13.class.getClassLoader(), new Class[]{IQuestion.class}, timeCalcAop);
	  iQuestion.solution();
  }
}
