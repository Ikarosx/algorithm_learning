package interview.美团点评.美团20201018校招;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美和小团所在公司的食堂有N张餐桌，从左到右摆成一排，每张餐桌有2张餐椅供至多2人用餐，公司职员排队进入食堂用餐。
 *
 * 小美发现职员用餐的一个规律并告诉小团：当男职员进入食堂时，他会优先选择已经坐有1人的餐桌用餐，只有当每张餐桌要么空着要么坐满2人时，他才会考虑空着的餐桌；当女职员进入食堂时，她会优先选择未坐人的餐桌用餐，只有当每张餐桌都坐有至少1人时，她才会考虑已经坐有1人的餐桌；无论男女，当有多张餐桌供职员选择时，他会选择最靠左的餐桌用餐。
 *
 * 现在食堂内已有若干人在用餐，另外M个人正排队进入食堂，小团会根据小美告诉他的规律预测排队的每个人分别会坐哪张餐桌。
 *
 *
 *
 * 输入描述
 * 第一行输入一个整数T（1<=T<=10），表示数据组数。
 *
 * 每组数据占四行，第一行输入一个整数N（1<=N<=500000）；
 *
 * 第二行输入一个长度为N且仅包含数字0、1、2的字符串，第i个数字表示左起第i张餐桌已坐有的用餐人数；
 *
 * 第三行输入一个整数M（1<=M<=2N且保证排队的每个人进入食堂时都有可供选择的餐桌）；
 *
 * 第四行输入一个长度为M且仅包含字母M、F的字符串，若第 i 个字母为M，则排在第 i 的人为男性，否则其为女性。
 *
 * 输出描述
 * 每组数据输出占M行，第 i 行输出一个整数 j （1<=j<=N），表示排在第 i 的人将选择左起第 j 张餐桌用餐。
 *
 * 82
 * @author Ikarosx
 * @date 2020/10/18 10:36
 */
public class C公司食堂 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 数据组数
            int n = Integer.valueOf(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                // 餐桌数量
                int N = Integer.valueOf(scanner.nextLine());
                StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
                // 排队人数
                int M = Integer.valueOf(scanner.nextLine());
                String ms = scanner.nextLine();
                int start = 0;
                // 判断第j个人
                for (int j = 0; j < M; j++) {
                    if (ms.charAt(j) == 'M') {
                        // 男
                        int blank = -1;
                        boolean flag = true;
                        for (int k = start; k < N; k++) {
                            char c = stringBuilder.charAt(k);
                            if (c == '1') {
                                // 男生优先选择1
                                System.out.println(k + 1);
                                stringBuilder.setCharAt(k, (char) (c + 1));
                                flag = false;
                                break;
                            } else if (c == '0') {
                                // 找到第一个0
                                if (blank == -1) {
                                    blank = k;

                                }
                            } else {
                                if (start == k) {
                                    start++;
                                }
                            }
                        }
                        if (flag) {
                            System.out.println(blank + 1);
                            stringBuilder
                                .setCharAt(blank, (char) (stringBuilder.charAt(blank) + 1));
                        }
                    } else {
                        // 女
                        int blank = -1;
                        boolean flag = true;
                        for (int k = start; k < N; k++) {
                            char c = stringBuilder.charAt(k);
                            if (c == '0') {
                                // 女生优先选择0
                                System.out.println(k + 1);
                                stringBuilder.setCharAt(k, (char) (c + 1));
                                flag = false;
                                break;
                            } else if (c == '1') {
                                // 找到第一个1
                                if (blank == -1) {
                                    blank = k;
                                }
                            } else {
                                if (start == k) {
                                    start++;
                                }
                            }
                        }
                        if (flag) {
                            System.out.println(blank + 1);
                            stringBuilder
                                .setCharAt(blank, (char) (stringBuilder.charAt(blank) + 1));
                        }
                    }
                }
            }
        }
        scanner.close();
    }
}
