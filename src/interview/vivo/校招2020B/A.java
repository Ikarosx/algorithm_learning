package interview.vivo.校招2020;

import org.junit.jupiter.api.Test;

/**
 * 小v最近在玩一款挖矿的游戏，该游戏介绍如下：
 * 1、每次可以挖到多个矿石，每个矿石的重量都不一样，挖矿结束后需要通过一款平衡矿车运送下山；
 * 2、平衡矿车有左右2个车厢，中间只有1个车轮沿着导轨滑到山下，且矿车只有在2个车厢重量完全相等且矿石数量相差不超过1个的情况下才能成功运送矿石，否则在转弯时可能出现侧翻。
 * 假设小v挖到了n（n<100）个矿石，每个矿石重量不超过100，为了确保一次性将n个矿石都运送出去，一旦矿车的车厢重量不一样就需要购买配重砝码。请问小v每次最少需要购买多少重量的砝码呢?
 * （假设车厢足够放下这些矿石和砝码，砝码重量任选）
 *
 * @author Ikaros
 * @date 2020/6/4 13:30
 */
public class A {
    @Test
    public void test() {
        System.out.println(solution(new int[]{3, 7, 4, 11, 8, 10}));
    }
    
    static int[] visited;
    static int sum = 0;
    static int result = Integer.MAX_VALUE;
    
    private static int solution(int[] input) {
        if (input.length == 1) {
            return input[0];
        }
        visited = new int[input.length];
        
        for (int i : input) {
            sum += i;
        }
        dfs(input, 0, 0);
        return result;
    }
    
    private static void dfs(int[] input, int count, int tempSum) {
        if (count >= input.length / 2) {
            int d = sum - tempSum;
            if (Math.abs(d - tempSum) < result) {
                result = Math.abs(d - tempSum);
            }
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (visited[i] == 0) {
                visited[i]++;
                dfs(input, count + 1, tempSum + input[i]);
                visited[i]--;
            }
        }
    }
}
