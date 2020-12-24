package leetcode.sign;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Test;

/**
 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/24 20:07
 */
public class N135分发糖果 {

    @Test
    public void test() {
        Assert.assertEquals(1, candy(new int[]{1}));
        Assert.assertEquals(2, candy(new int[]{1, 1}));
        Assert.assertEquals(5, candy(new int[]{1, 0, 2}));
        Assert.assertEquals(4, candy(new int[]{1, 2, 2}));
    }

    // 正常
    public int candy(int[] ratings) {
        int[] ints = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                ints[i] = ints[i - 1] + 1;
            } else {
                ints[i] = 1;
            }
        }
        int result = 0;
        int right = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            result += Math.max(right, ints[i]);
        }
        return result;
    }

    // 拓扑排序
    public int candy1(int[] ratings) {
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i - 1 >= 0 && ratings[i - 1] < ratings[i]) {
                degree[i]++;
            }
            if (i + 1 < ratings.length && ratings[i + 1] < ratings[i]) {
                degree[i]++;
            }
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] count = new int[ratings.length];
        int cur = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int idx = queue.poll();
                count[idx] = cur;
                if (idx - 1 >= 0 && ratings[idx - 1] > ratings[idx]) {
                    degree[idx - 1]--;
                    if (degree[idx - 1] == 0) {
                        queue.offer(idx - 1);
                    }
                }
                if (idx + 1 < ratings.length && ratings[idx + 1] > ratings[idx]) {
                    degree[idx + 1]--;
                    if (degree[idx + 1] == 0) {
                        queue.offer(idx + 1);
                    }
                }
            }
            cur++;
        }
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i];
        }
        return total;
    }

}
