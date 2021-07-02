package leetcode.序号.n400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 <em>n</em> 数字的字符串表示。
 * <p>
 * 1. 如果&nbsp;<em>n&nbsp;</em>是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果&nbsp;<em>n&nbsp;</em>是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果&nbsp;<em>n&nbsp;</em>同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 * <p>
 * 相关标签：
 * 数学
 * 字符串
 * 模拟
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/fizz-buzz/
 *
 * @author Ikarosx
 * @date 2021/7/2
 */
public class N412FizzBuzz {
    @Test
    public void test() {
        System.out.println(fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean a = i % 3 == 0;
            boolean b = i % 5 == 0;
            // 不要多个判断，直接if else会提高一点性能
            if (!a && !b) {
                result.add(String.valueOf(i));
			} else if (a && b) {
				result.add("FizzBuzz");
			} else if (a) {
				result.add("Fizz");
			} else {
				result.add("Buzz");
			}
        }
        return result;
    }
}