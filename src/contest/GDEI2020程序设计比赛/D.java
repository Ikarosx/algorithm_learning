package contest.GDEI2020程序设计比赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/6/15 19:54
 */
public class D {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      // 还需的经验值
      int n = scanner.nextInt();
      // 保留的忍耐度
      int m = scanner.nextInt();
      // 怪的种类数
      int k = scanner.nextInt();
      // 最多的杀怪数
      int s = scanner.nextInt();
      Double[][] monstor = new Double[k][3];
      for (int i = 0; i < k; i++) {
        // 得到的经验值
        monstor[i][0] = scanner.nextDouble();
        // 减少的忍耐度
        monstor[i][1] = scanner.nextDouble();
        // 性价比
        monstor[i][2] = monstor[i][0] / (monstor[i][1] + 0.0);
      }
      // 按性价比排序
      Arrays.sort(monstor, Comparator.comparing(o -> o[2]));
    }
    scanner.close();
  }
}
