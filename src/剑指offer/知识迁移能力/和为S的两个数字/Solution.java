package 剑指offer.知识迁移能力.和为S的两个数字;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author Ikaros
 * @date 2020/5/6 23:20
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(FindNumbersWithSum(new int[]{1, 3, 4, 5, 6, 8, 9}, 10));
    }
    
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int l = 0;
        int r = array.length - 1;
        int rl = array.length - 1;
        int rr = array.length - 1;
        while (l < r) {
            int temp = array[l] + array[r];
            if (temp < sum) {
                l++;
            } else if (temp > sum) {
                r--;
            } else {
                if (array[r] * array[l] < array[rl] * array[rr]) {
                    rl = l;
                    rr = r;
                }
                l++;
                r--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (rl != rr) {
            list.add(array[rl]);
            list.add(array[rr]);
        }
        return list;
    }
}
