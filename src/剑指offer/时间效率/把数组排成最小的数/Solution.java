package 剑指offer.时间效率.把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author Ikaros
 * @date 2020/5/5 20:20
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3, 32, 321}));
    }
    
    public static String PrintMinNumber(int[] numbers) {
        Integer[] arrays = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arrays[i] = numbers[i];
        }
        Arrays.sort(arrays, new MyComparator());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer array : arrays) {
            stringBuilder.append(array);
        }
        return stringBuilder.toString();
    }
    
    static class MyComparator implements Comparator {
        
        @Override
        public int compare(Object o1, Object o2) {
            Integer integer1 = Integer.valueOf(o1 + "" + o2);
            Integer integer2 = Integer.valueOf(o2 + "" + o1);
            return integer1.compareTo(integer2);
        }
    }
}
