package 剑指offer.知识迁移能力.数组中只出现一次的数字;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author Ikaros
 * @date 2020/5/6 22:37
 */
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        /*
         * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
         * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
         *
         * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
         * 我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，
         * 表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，
         * 接着把原数组分成两组，分组标准是第3位是否为1。
         * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，
         * 而不同的数，肯定不在一组。
         * 然后把这两个组按照最开始的思路，依次异或，
         * 剩余的两个结果就是这两个只出现一次的数字。
         */
        int xor1 = 0;
        for (int i : array) {
            xor1 ^= i;
        }
        int index = 1;
        while ((index & xor1) == 0) {
            index <<= 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int i : array) {
            if ((index & i) == 0) {
                result1 ^= i;
            } else {
                result2 ^= i;
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
