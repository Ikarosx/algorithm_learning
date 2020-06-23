package cn.ikarosx.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数学老师小y 想写一个成绩查询系统，包含如下指令：
 *
 * <p>insert [name] [score]，向系统中插入一条信息，表示名字为name的学生的数学成绩为score。 find [name]，表示查找名字为name的学生的数学成绩。
 * 注意有些同学可能会为了刷分多次选课，查询的时候给出最大成绩即可。 学生的名字是由小写字母组成。成绩是一个 0 … 100 的整数。
 *
 * <p>老师找到你，想你帮他完成这个系统。
 *
 * @author Ikaros
 * @date 2020/6/15 19:54
 */
public class B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>();
    while (true) {
      String operation = scanner.next();
      if ("insert".equals(operation)) {
        String name = scanner.next();
        map.put(name, Math.max(map.getOrDefault(name, 0), scanner.nextInt()));
      } else if ("find".equals(operation)) {
        System.out.println(map.getOrDefault(scanner.next(), -1));
      } else if ("end".equals(operation)) {
        break;
      }
    }
    scanner.close();
  }
}
