package common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeCalcAop implements InvocationHandler {
  private Object obj;

  public TimeCalcAop(Object obj) {
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long l = System.currentTimeMillis();
    Object ret = method.invoke(obj, args);
    System.out.println("消耗时间：" + (System.currentTimeMillis() - l) + "ms");
    return ret;
  }
}
