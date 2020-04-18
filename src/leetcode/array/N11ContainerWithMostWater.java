package leetcode.array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 * @author Ikaros
 *
 */
public class N11ContainerWithMostWater {
	public int maxArea(int[] height) {
		// i:左索引 j:右索引
		int i = 0, j = height.length - 1;
		int max = 0;
		while (i < j) {
			// 不断淘汰低的那部分，确保最大值
			int temp = (j - i) * (height[i] > height[j] ? height[j--] : height[i++]);
			max = max > temp ? max : temp;

		}
		return max;
	}
}
