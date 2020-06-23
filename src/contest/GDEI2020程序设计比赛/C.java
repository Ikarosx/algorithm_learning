package cn.ikarosx.contest;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // T行数据
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++) {
      n个随从
      int n = scanner.nextInt();
      int[][] gcSlave = new int[n][2];
      int[][] cgSlave = new int[n][2];
      GC学长
      int gcMinHealth = Integer.MAX_VALUE;
      int cgMaxAttack = Integer.MIN_VALUE;
      for (int j = 0; j < n; j++) {
        // 生命力
        gcSlave[j][0] = scanner.nextInt();
        // 攻击值
        gcSlave[j][1] = scanner.nextInt();
        if (gcSlave[j][0] < gcMinHealth) {
          gcMinHealth = gcSlave[j][0];
        }
      }

      // 对手
      for (int j = 0; j < n; j++) {
        cgSlave[j][0] = scanner.nextInt();
        cgSlave[j][1] = scanner.nextInt();
        if (cgSlave[j][1] > cgMaxAttack) {
          cgMaxAttack = cgSlave[j][1];
        }
      }
      if (cgMaxAttack >= gcMinHealth) {
        // 如果对手的攻击已经大于等于GC学长的最低生命值
        System.out.println("No");
        continue;
      }
      // GC学长按攻击力从低到高排序
      for (int j = 1; j < gcSlave.length; j++) {
        int tempHealth = gcSlave[j][0];
        int tempAttack = gcSlave[j][1];
        int k;
        for (k = j; k >= 1 && tempAttack < gcSlave[k - 1][1]; k--) {
          gcSlave[k][1] = gcSlave[k - 1][1];
          gcSlave[k][0] = gcSlave[k - 1][0];
        }
        gcSlave[k][1] = tempAttack;
        gcSlave[k][0] = tempHealth;
      }
      // 对手按生命从低到高排序
      for (int j = 1; j < cgSlave.length; j++) {
        int tempHealth = cgSlave[j][0];
        int tempAttack = cgSlave[j][1];
        int k;
        for (k = j; k >= 1 && tempHealth < cgSlave[k - 1][0]; k--) {
          cgSlave[k][1] = cgSlave[k - 1][1];
          cgSlave[k][0] = cgSlave[k - 1][0];
        }
        cgSlave[k][1] = tempAttack;
        cgSlave[k][0] = tempHealth;
      }
      boolean flag = true;
      for (int j = 0; j < gcSlave.length; j++) {
        if (gcSlave[j][1] < cgSlave[j][0]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
    // scanner.close();
  }
}
