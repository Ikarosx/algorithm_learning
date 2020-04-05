package 剑指offer.时间效率.最小的K个数;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路①排序后再取数 归并排序
 * @author Ikaros
 * @date 2020/04/05 11:53
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(Integer[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k) {
            return list;
        }
        
        mergeSort(input, 0, input.length - 1);
        SortTestHelper.printArray(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    
    private void mergeSort(Integer[] input, int l, int r) {
        // 只有一个元素，直接返回
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(input, l, mid);
        mergeSort(input, mid + 1, r);
        if (input[mid] > input[mid + 1]) {
            merge(input, l, mid, r);
        }
    }
    
    private void merge(Integer[] input, int l, int mid, int r) {
        int[] array = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            array[i - l] = input[i];
        }
        int m = l;
        int n = mid + 1;
        for (int i = l; i <= r; i++) {
            if (m > mid) {
                input[i] = array[n++ - l];
            } else if (n > r) {
                input[i] = array[m++ - l];
            } else if (array[m - l] < array[n - l]) {
                input[i] = array[m++ - l];
            } else {
                input[i] = array[n++ - l];
            }
        }
    }
    
    
    @Test
    public void solutionTest() {
        int n = 10;
        Integer[] integers = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.printArray(integers);
        System.out.println(GetLeastNumbers_Solution(integers, 2));
        
    }
}