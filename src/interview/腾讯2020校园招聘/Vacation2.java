package interview.腾讯2020校园招聘;


import java.util.Scanner;

/**
 * 由于业绩优秀，公司给小Q放了 n 天的假，
 * 身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
 * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，
 * 小Q才能去工作，只有当健身房营业时，小Q才能去健身，
 * 小Q一天只能干一件事。给出假期中公司，健身房的营业情况，
 * 求小Q最少需要休息几天。
 * <p>
 * 输入描述:
 * 第一行一个整数  表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * （1为营业 0为不营业）
 * <p>
 * 输出描述:
 * 一个整数，表示小Q休息的最少天数
 * <p>
 * 输入例子1:
 * 4
 * 1 1 0 0
 * 0 1 1 0
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天
 * <p>
 * 10 0 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1 0 1 0 1
 *
 * @author Ikaros
 * @date 2020/4/13 20:07
 */
public class Vacation2 {
    static int[] company = null;
    static int[] gym = null;
    static int[][] dp = null;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 放假天数
        int n = scanner.nextInt();
        // 公司是否营业
        company = new int[n + 1];
        // 健身房是否营业
        gym = new int[n + 1];
        for (int i = 1; i < company.length; i++) {
            company[i] = scanner.nextInt();
        }
        for (int i = 1; i < gym.length; i++) {
            gym[i] = scanner.nextInt();
        }
        // 用dp[i][0]代表第i天工作时, 前i天工作或健身的最大天数
        // 用dp[i][1]代表第i天健身时, 前i天工作或健身的最大天数
        // 则存在下列关系:
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + company[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + gym[i], dp[i - 1][1]);
        }
        System.out.println(n - Math.max(dp[n][0], dp[n][1]));
        scanner.close();
    }
}
