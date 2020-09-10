package leetcode.剑指offer.N61_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/10 11:10
 */
public class N57II和为s的连续正数序列 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findContinuousSequence(15)));
    }

    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 2;
        int sum = 3;
        List<int[]> resultList = new ArrayList<>();
        while (l < r) {
            if (sum == target) {
                int[] ints = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    ints[i - l] = i;
                }
                resultList.add(ints);
                sum -= l++;
            } else if (sum < target) {
                sum += ++r;
            } else {
                // sum > target
                sum -= l++;
                if (l + r > target) {
                    // 左边缩后如果还小，说明后面已经不满足了
                    break;
                }
            }
        }
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
