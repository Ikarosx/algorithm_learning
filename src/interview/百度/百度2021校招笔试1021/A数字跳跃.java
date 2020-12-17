package interview.百度.百度2021校招笔试1021;

import java.util.HashMap;
import java.util.Scanner;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/10/12 18:48
 */
public class A数字跳跃 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = scanner.nextInt();
            String numString = scanner.next();
            int[] ints = new int[N];
            // 存放数字num第一次出现的下标
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int num = numString.charAt(i) - '0';
                ints[i] = num;
                if (!map.containsKey(num)) {
                    map.put(num, i);
                }
            }
            // dp[i]表示跳到下标为i的地方最少需要多少步
            int[] dp = new int[N];
            // 初始化
            dp[0] = 0;
            for (int i = 1; i < N; i++) {
                // dp[i] = 上一格 与 第一次出现该位置的下标对应的步数 中的最小者 + 1
                /*Integer orDefault = map.get(ints[i]);
                if (i == orDefault) {
                    orDefault = i - 1;
                }
                dp[i] = Math.min(dp[i - 1], dp[orDefault]) + 1;*/
                // 第一次出现的下标
                Integer firstIndex = map.get(ints[i]);
                if (firstIndex == i) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = Math.min(dp[i - 1], dp[firstIndex]) + 1;
                }
            }
            System.out.println(dp[N - 1]);
        }
        scanner.close();
    }

}
