package leetcode.sign;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/12/27 21:46
 */
public class N84柱状图中最大的矩形 {

    @Test
    public void test() {
        Assert.assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(1, largestRectangleArea(new int[]{1}));
        Assert.assertEquals(0, largestRectangleArea(new int[]{}));
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int n = heights.length;
        int[] ints = new int[n + 2];
        for (int i = 0; i < n; i++) {
            ints[i + 1] = heights[i];
        }
        int result = 0;
        for (int i = 1; i < ints.length; i++) {
            while (ints[stack.peekLast()] > ints[i]) {
                Integer integer = stack.pollLast();
                int height = ints[integer];
                int width = i - stack.peekLast() - 1;
                result = Math.max(height * width, result);
            }
            stack.addLast(i);
        }
        return result;
    }
}
