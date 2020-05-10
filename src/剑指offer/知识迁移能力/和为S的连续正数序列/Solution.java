package 剑指offer.知识迁移能力.和为S的连续正数序列;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author Ikaros
 * @date 2020/5/6 23:01
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(FindContinuousSequence(3));
    }
    
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int l = 1;
        int r = 1;
        int temp = 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (r < sum) {
            if (temp + r + 1 == sum) {
                if (l != ++r) {
                    result.add(getList(l, r));
                }
                temp += r;
                temp -= l++;
            }
            if (temp + r + 1 < sum) {
                temp += ++r;
            }
            if (temp + r + 1 > sum) {
                temp -= l++;
            }
        }
        return result;
    }
    
    private ArrayList<Integer> getList(int l, int r) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(i);
        }
        return result;
    }
}
