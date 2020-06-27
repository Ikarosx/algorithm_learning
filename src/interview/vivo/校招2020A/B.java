package interview.vivo.校招2020A;

import org.junit.jupiter.api.Test;

/**
 * 小v在vivo手机的应用商店中下载了一款名为“一维消消乐”的游戏，介绍如下：
 * 1、给出一些不同颜色的豆子，豆子的颜色用数字（0-9）表示，即不同的数字表示不同的颜色；
 * 2、通过不断地按行消除相同颜色且连续的豆子来积分，直到所有的豆子都消掉为止；
 * 3、假如每一轮可以消除相同颜色的连续 k 个豆子（k >= 1），这样一轮之后小v将得到 k*k 个积分；
 * 4、由于仅可按行消除，不可跨行或按列消除，因此谓之“一维消消乐”。
 *
 * @author Ikaros
 * @date 2020/6/4 15:07
 */
public class B {
    static int[] visit;
    static int result = Integer.MIN_VALUE;
    
    @Test
    public void test() {
        System.out.println(solution(new int[]{1, 4, 2, 2, 3, 3, 2, 4, 1}));
    }
    
    private static int solution(int[] input) {
        visit = new int[input.length];
        dfs(input, 0);
        return result;
    }
    
    private static void dfs(int[] input, int sum) {
        boolean flag = false;
        for (int i = 0; i < input.length; i++) {
            if (visit[i] == 0) {
                flag = true;
                int start = i;
                int end = i;
                while (end + 1 < input.length && visit[end + 1] == 0 && input[start] == input[end + 1]) {
                    end++;
                }
                int temp = input[i];
                changeVisit(start, end >= input.length ? input.length - 1 : end, -1);
                dfs(input, sum + (end - start) * (end - start));
                changeVisit(start, end >= input.length ? input.length - 1 : end, temp);
            }
        }
        if (!flag && sum > result) {
            result = sum;
        }
    }
    
    private static void changeVisit(int start, int end, int i) {
        for (int k = start; k <= end; k++) {
            visit[k] = i;
        }
    }
}
