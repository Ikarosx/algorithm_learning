package 剑指offer.时间空间效率的平衡.丑数;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author Ikaros
 * @date 2020/5/5 21:32
 */
public class Solution {
    public static void main(String[] args) {
        // TODO
    }
    
    public int GetUglyNumber_Solution(int index) {
        
        int result = 0;
        int count = 1;
        int i = 2;
        while (count < index) {
            while (i <= index) {
                // 判断i是否是丑数
                for (int j = 2; j <= i ; j++) {
                }
            }
        }
        return result;
    }
}
