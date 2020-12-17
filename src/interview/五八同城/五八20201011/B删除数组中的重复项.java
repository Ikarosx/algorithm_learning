package interview.五八同城.五八20201011;

import java.util.Arrays;
import java.util.LinkedHashSet;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/10/11 20:32
 */
public class B删除数组中的重复项 {

    /**
     * 删除重复元素
     *
     * @param array int整型一维数组
     *
     * @return int整型一维数组
     */
    public int[] removeDuplicate(int[] array) {
        // write code here
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = array.length - 1; i >= 0; i--) {
            set.add(array[i]);
        }
        int[] ints = new int[set.size()];
        int i = set.size() - 1;
        for (Integer integer : set) {
            ints[i--] = integer;
        }
        return ints;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(removeDuplicate(new int[]{1, 1, 1, 2, 1})));
    }
}
