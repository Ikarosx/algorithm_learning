package 奇安信;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ikarosx
 * @date 2021/04/14
 */
public class B最大体积值 {

    Set<Long> list;

    private B最大体积值() {
        list = new HashSet<>();
        for (long i = 1; i <= 10000; i++) {
            if (isPri(i)) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
        B最大体积值 b最大体积值 = new B最大体积值();
        long maxVolume = b最大体积值.getMaxVolume(6);
        System.out.println(maxVolume);
    }

    /**
     * 判断是否是质数
     *
     * @param i
     * @return
     */
    private boolean isPri(long i) {
        if (i <= 2) {
            return true;
        }
        for (int j = 2; j < i; j++) {
            if (i / j * j == i) {
                return false;
            }
        }
        return true;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 得到体积的最大可能值
     *
     * @param n long长整型 长方形的长宽高之和。长宽高都为质数。
     * @return long长整型
     */
    public long getMaxVolume(long n) {
        long result = 0;
        for (long i : list) {
            for (long j : list) {
                if (list.contains(n - i - j)) {
                    result = Math.max(result, i * j * (n - i - j));
                }
            }
        }
        return result;
        // write code here
    }
}
