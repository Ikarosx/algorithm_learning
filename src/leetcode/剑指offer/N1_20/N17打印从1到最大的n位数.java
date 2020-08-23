package leetcode.剑指offer.N1_20;

import org.junit.jupiter.api.Test;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * @author Ikarosx
 * @date 2020/8/23 8:44
 */
public class N17打印从1到最大的n位数 {

    @Test
    public void test() {
        printNumbers(5);
    }

    public int[] printNumbers(int n) {
        int[] ints = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

}
