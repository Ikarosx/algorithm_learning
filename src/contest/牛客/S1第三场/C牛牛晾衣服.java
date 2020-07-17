package contest.牛客.S1第三场;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Ikarosx
 * @date 2020/7/16 21:09
 */
public class C牛牛晾衣服 {
    @Test
    public void test() {
        System.out.println(solve(3, new int[]{2, 3, 9}, 5));
    }
    
    /**
     * 计算最少要多少时间可以把所有的衣服全烘干
     *
     * @param n
     *         int整型 n件衣服
     * @param a
     *         int整型一维数组 n件衣服所含水量数组
     * @param k
     *         int整型 烘干机1分钟可以烘干的水量
     *
     * @return int整型
     */
    public int solve(int n, int[] a, int k) {
        // write code here
        // 每次晾需要多少时间最长的那件
        Arrays.sort(a);
        int l = 0;
        int r = n - 1;
        int result = 0;
        while (l < n) {
            // 最长能减多少
            int minute = 1;
            a[r] -= k;
            // if (minute == 0) {
            //     a[r] = 0;
            //     minute = 1;
            // }
            result += minute;
            while (l < r && a[l] <= minute) {
                l++;
            }
            for (int i = l; i < r; i++) {
                a[i] -= minute;
            }
            // 此时l如果==n
            if (l == r && a[r] <= 0) {
                break;
            }
            // 把最后一个移动到合适的位置
            int temp = a[r];
            int tempR = r;
            while (tempR > l && temp < a[tempR - 1]) {
                a[tempR] = a[tempR - 1];
                tempR--;
            }
            a[tempR] = temp;
        }
        return result;
    }
}
