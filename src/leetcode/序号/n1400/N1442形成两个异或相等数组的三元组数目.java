package leetcode.序号.n1400;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr 。
 * <p>
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <p>
 * a 和 b 定义如下：
 * <p>
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * <p>
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [2,3]
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * <p>
 * 示例 5：
 * <p>
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 * <p>
 * <p>
 * 相关标签：
 * 位运算
 * 数组
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 *
 * @author Ikarosx
 * @date 2021/5/18
 */
public class N1442形成两个异或相等数组的三元组数目 {
    @Test
    public void test() {
        Assert.assertEquals(4, countTriplets(new int[]{2, 3, 1, 6, 7}));
        Assert.assertEquals(10, countTriplets(new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(0, countTriplets(new int[]{2, 3}));
        Assert.assertEquals(3, countTriplets(new int[]{1, 3, 5, 7, 9}));
        Assert.assertEquals(8, countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    /**
     * HashMap一次循环
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int k = 0; k < n; ++k) {
            if (cnt.containsKey(s[k + 1])) {
                ans += cnt.get(s[k + 1]) * k - total.get(s[k + 1]);
            }
            cnt.put(s[k], cnt.getOrDefault(s[k], 0) + 1);
            total.put(s[k], total.getOrDefault(s[k], 0) + k);
        }
        return ans;
    }


    /**
     * 双重循环
     *
     * @param arr
     * @return
     */
    public int countTripletsTwo(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (s[i] == s[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }


    /**
     * 三重循环
     *
     * @param arr
     * @return
     */
    public int countTripletsThree(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j; k < n; ++k) {
                    if (s[i] == s[k + 1]) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * 自写，效率低
     *
     * @param arr
     * @return
     */
    public int countTripletsBad(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                result += countTripletsImpl(arr, i, j);
            }
        }
        return result;
    }

    private int countTripletsImpl(int[] arr, int left, int right) {
        // 保存所有异或结果
        int xorResult = 0;
        for (int i = left; i <= right; i++) {
            xorResult ^= arr[i];
        }
        int length = right - left + 1;
        int result = 0;
        // 保存左半部分异或结果
        int leftXorResult = arr[left];
        // 需要从第二个数开始计算
        for (int i = left + 1; i <= right; i++) {
            // 整体异或左半部分，可以得到右半部分的异或结果
            int rightXorResult = xorResult ^ leftXorResult;
            if (leftXorResult == rightXorResult) {
                result++;
            }
            leftXorResult ^= arr[i];
        }
        return result;
    }
}