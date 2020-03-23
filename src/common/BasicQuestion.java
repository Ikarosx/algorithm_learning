package common;

public class BasicQuestion {
  private long startTime;
  private long endTime;
  private int rate;
  private TimeType timeType;

  public BasicQuestion(TimeType timeType) {
    this.timeType = timeType;
  }

  private void start() {
    startTime = System.currentTimeMillis() * timeType.getRate();
  }

  private void end() {
    endTime = System.currentTimeMillis() * timeType.getRate();
  }

  protected void solution(Object... args) {}

  protected void solution(String str) {}

  protected void solution(int number) {}

  public void run(String str) {
    start();
    solution(str);
    end();
    printCostTime();
  }

  private void printCostTime() {
    System.out.println(endTime - startTime + "" + timeType.getUnit());
  }
}
