package interview.腾讯2020校园招聘;


import java.util.Scanner;

/**
 * 由于业绩优秀，公司给小Q放了 n 天的假，
 * 身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
 * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，
 * 小Q才能去工作，只有当健身房营业时，小Q才能去健身，
 * 小Q一天只能干一件事。给出假期中公司，健身房的营业情况，
 * 求小Q最少需要休息几天。
 *
 * 输入描述:
 * 第一行一个整数  表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * （1为营业 0为不营业）
 *
 * 输出描述:
 * 一个整数，表示小Q休息的最少天数
 *
 * 输入例子1:
 * 4
 * 1 1 0 0
 * 0 1 1 0
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天
 *
 * 10 0 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1 0 1 0 1
 *
 * @author Ikaros
 * @date 2020/4/13 20:07
 */
public class Vacation {
    static int[] company = null;
    static int[] gym = null;
    static int count = 0;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 放假天数
        int n = scanner.nextInt();
        // 公司是否营业
        company = new int[n];
        // 健身房是否营业
        gym = new int[n];
        for (int i = 0; i < company.length; i++) {
            company[i] = scanner.nextInt();
        }
        for (int i = 0; i < gym.length; i++) {
            gym[i] = scanner.nextInt();
        }
        // 如果有营业，则可以选择去或者休息，如果去则将下一天的状态置为不营业，因为无法连续去
        // 如果都不营业，则必须休息
        vacation(0);
        System.out.println(result);
        scanner.close();
    }
    
    private static void vacation(int i) {
        // 递归到底
        if (i >= company.length) {
            result = result > count ? count : result;
            return;
        }
        // 公司与健身房都不营业
        if (company[i] == 0 && gym[i] == 0) {
            // 休息一天
            count++;
            vacation(i + 1);
            count--;
            return;
        }
        // 可以去公司
        if (i + 1 >= company.length) {
            result = result > count ? count : result;
        } else if (company[i] != 0) {
            // 将下一天置为不能去
            int temp = company[i + 1];
            company[i + 1] = 0;
            vacation(i + 1);
            company[i + 1] = temp;
        } else if (gym[i] != 0) {
            // 将下一天置为不能去
            int temp = gym[i + 1];
            gym[i + 1] = 0;
            vacation(i + 1);
            gym[i + 1] = temp;
        }
        // 虽然可以去但是选择不去
        // 如果明天一定是休息那么今天就选择去
        if (!(i + 1 < gym.length && company[i + 1] == 0 && gym[i + 1] == 0)) {
            count++;
            vacation(i + 1);
            count--;
        }
        
    }
    
}
