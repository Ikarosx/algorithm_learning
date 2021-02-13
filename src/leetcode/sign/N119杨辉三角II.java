package leetcode.sign;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/12 0:50
 */
public class N119杨辉三角II {
    @Test
    public void test () {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRow(i));
        }
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1));
        lists.add(Arrays.asList(1, 1));
        for (int i = 2; i <= rowIndex; i++) {
            ArrayList<Integer> integers = new ArrayList<>(i + 1);
            List<Integer> preList = lists.get(i - 1);
            integers.add(1);
            for (int j = 0; j < preList.size() - 1; j++) {
                integers.add(preList.get(j) + preList.get(j + 1));
            }
            integers.add(1);
            lists.add(integers);
        }
        return lists.get(rowIndex);
    }
}
