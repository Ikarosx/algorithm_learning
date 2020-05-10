package 剑指offer.知识迁移能力.数字在排序数组中出现的次数;

import org.junit.jupiter.api.Test;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author Ikaros
 * @date 2020/5/6 19:43
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(GetNumberOfK(new int[]{2, 3, 3, 3, 6, 8}, 3));
    }
    
    public int GetNumberOfK(int[] array, int k) {
        // 先二分找到目标位置，然后再左右扩展
        int l = 0;
        int r = array.length - 1;
        int result = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (array[mid] == k) {
                int rr = mid + 1;
                int ll = mid - 1;
                result++;
                while (rr < array.length && array[rr] == k) {
                    result++;
                    rr++;
                }
                while (ll >= 0 && array[ll] == k) {
                    result++;
                    ll--;
                }
                break;
            } else if (array[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
