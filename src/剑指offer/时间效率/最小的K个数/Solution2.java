package 剑指offer.时间效率.最小的K个数;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;

import java.util.ArrayList;


/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路①排序后再取数 快速排序
 *
 * @author Ikaros
 * @date 2020/04/05 11:53
 */
public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(Integer[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k) {
            return list;
        }
        // 可优化，只对一边查找
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    
    private void quickSort(Integer[] input, int l, int r) {
        if (l >= r) {
            return;
        }
        // [0,1)
        int i1 = (int) (Math.random() * (r - l + 1)) + l;
        swap(input, l, i1);
        int temp = input[l];
        // [l + 1...lt] < temp
        // [lt + 1...i - 1] = temp
        // [gt...r] > temp
        int lt = l;
        int gt = r + 1;
        int i = lt + 1;
        while (i < gt) {
            if (input[i] == temp) {
                i++;
            } else if (input[i] < temp) {
                swap(input, i++, ++lt);
            } else {
                swap(input, i, --gt);
            }
        }
        quickSort(input, l, lt);
        quickSort(input, gt, r);
    }
    
    private void swap(Integer[] input, int l, int i) {
        int temp = input[l];
        input[l] = input[i];
        input[i] = temp;
    }
    
    
    @Test
    public void solutionTest() {
        int n = 10;
        Integer[] integers = SortTestHelper.generateRandomArray(n, 0, n);
        System.out.println(GetLeastNumbers_Solution(integers, 2));
        
    }
}