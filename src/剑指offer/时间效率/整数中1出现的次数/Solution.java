package 剑指offer.时间效率.整数中1出现的次数;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1到 n 中1出现的次数）。
 *
 * @author Ikaros
 * @date 2020/5/5 9:18
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            count += (a + 8) / 10 * m + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }
}
