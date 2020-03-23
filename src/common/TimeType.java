package common;

/** @author x5322 */
public enum TimeType {
  // 纳秒
  Nano("ns", 1000),
  // 毫秒
  MS("ms", 1);
  /** 定义时间单位 */
  private String unit;

  private int rate;

  TimeType(String unit, int rate) {
    this.unit = unit;
    this.rate = rate;
  }

  public String getUnit() {
    return unit;
  }

  public int getRate() {
    return rate;
  }
}
