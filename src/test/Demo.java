package test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/7/31 20:22
 */
public class Demo {

    public static void main(String[] args) {
        byte[] bytes = {48, 58, -26, -103, -82, -23, -128, -102, -25, -108, -88, -26, -120, -73, 44,
            32, 49, 58, -25, -77, -69, -25, -69, -97, -25, -82, -95, -25, -112, -122, -27, -111,
            -104};
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(new String(bytes));
        try {
            System.out.println(new String(bytes, System.getProperty("file.encoding")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        factorial(100);
    }

    /**
     * 计算n的阶乘尾部0的数量
     */
    public static long countFactorialTailZero(long n) {
        return n / 5 + n / 25;
    }

    /**
     * 阶乘
     */
    public void factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigDecimal(i));
            System.out.println(i + "：" + result + "：" + countZero(result));
        }
    }

    /**
     * 计算一个数有多少个0
     */
    public int countZero(BigDecimal n) {
        // 特判
        // 存储结果
        int count = 0;
        // 当n不为0
        while (!n.equals(BigDecimal.ZERO)) {
            // 判断个位数是不是为0
            if (n.remainder(BigDecimal.TEN).equals(BigDecimal.ZERO)) {
                // 个位为0结果加一
                count++;
            } else {
                return count;
            }
            // 除以10等于去掉个位
            n = n.divide(BigDecimal.TEN, RoundingMode.DOWN);
        }
        return count;
    }
}
