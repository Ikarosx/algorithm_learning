package contest.天池20200809;

import org.junit.jupiter.api.Test;

/**
 * 给定一个整数数组 A，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素，并且 每个元素都必须是非负整数），返回其最大和
 *
 * @author Ikarosx
 * @date 2020/8/9 10:04
 */
public class C最大非负子序和 {

    @Test
    public void solution() {
        System.out.println(maxNonNegativeSubArray(new int[]{-1, 0,}));
    }

    public int maxNonNegativeSubArray(int[] A) {
        // 记录结果
        int max = -1;
        // 记录当前数组和
        int temp = 0;
        // 一次遍历
        for (int i : A) {
            if (i >= 0) {
                temp += i;
                max = temp > max ? temp : max;
            } else {
                temp = 0;
            }
        }
        return max;
    }
}
