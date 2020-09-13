package leetcode.剑指offer.N61_;

import java.util.Arrays;
import org.junit.Test;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/12 9:00
 */
public class N66构建乘积数组 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }
        if (a.length == 1) {
            return a;
        }
        // left[i] 表示从左到右累乘以本身
        // right[i] 表示从右到左累乘以本身
        int[] left = new int[a.length];
        left[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i];
        }
        int[] right = new int[a.length];
        right[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i];
        }
        a[0] = right[1];
        a[a.length - 1] = left[a.length - 2];
        for (int i = 1; i < a.length - 1; i++) {
            a[i] = left[i - 1] * right[i + 1];
        }
        return a;
    }

}
