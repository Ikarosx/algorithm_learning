package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 7:43
 */
public class N11旋转数组的最小数字 {

    @Test
    public void test() {
        assert minArray(new int[]{3, 4, 5, 1, 2}) == 1;
        assert minArray(new int[]{2, 2, 2, 0, 1}) == 0;
    }


    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (numbers[middle] < numbers[high]) {
                // 如果中值小于最右边的值，说明最小值在中值的左边
                high = middle;
            } else if (numbers[middle] > numbers[high]) {
                // 如果中值大于最右边的值，说明最小值在中值的右边
                low = middle + 1;
            } else {
                // 如果中值和最右边值相等，去掉右端点
                high--;
            }
        }
        return numbers[low];
    }
}
