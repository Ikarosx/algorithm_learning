package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author Ikaros
 * @date 2020/6/27 21:08
 */
public class N11盛最多水的容器 {
    public int maxArea(int[] height) {
        // 双指针
        // 每次移动短板
        // 因为移动短板可能变大，移动长板可能不变或者变小
        int l = 0;
        int r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);
        while (l < r - 1) {
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
            max = Math.max(Math.min(height[l], height[r]) * (r - l), max);
        }
        return max;
    }
}
