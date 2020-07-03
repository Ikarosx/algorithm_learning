package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author Ikaros
 * @date 2020/7/3 8:33
 */
public class N70爬楼梯 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int a = 2;
        int b = 3;
        for (int i = 4; i <= n; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}
