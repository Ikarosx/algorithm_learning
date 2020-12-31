package leetcode.序号.n1500;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 *
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 *
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 *
 * 请你返回让 s 平衡的最少插入次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()))"
 * 输出：1
 * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
 * 示例 2：
 *
 * 输入：s = "())"
 * 输出：0
 * 解释：字符串已经平衡了。
 * 示例 3：
 *
 * 输入：s = "))())("
 * 输出：3
 * 解释：添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
 * 示例 4：
 *
 * 输入：s = "(((((("
 * 输出：12
 * 解释：添加 12 个 ')' 得到平衡字符串。
 * 示例 5：
 *
 * 输入：s = ")))))))"
 * 输出：5
 * 解释：在字符串开头添加 4 个 '(' 并在结尾添加 1 个 ')' ，字符串变成平衡字符串 "(((())))))))" 。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 只包含 '(' 和 ')' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/30 16:08
 */
public class N1541平衡括号字符串的最少插入次数 {

    @Test
    public void test() {
        Assert.assertEquals(1, minInsertions("(()))"));
        Assert.assertEquals(0, minInsertions("())"));
        Assert.assertEquals(3, minInsertions("))())("));
        Assert.assertEquals(12, minInsertions("(((((("));
        Assert.assertEquals(5, minInsertions(")))))))"));
        Assert.assertEquals(4, minInsertions("(()))(()))()())))"));
    }

    /**
     * 从右到左
     */
    public int minInsertions(String s) {
        int result = 0;
        // 右括号
        int count = 0;
        // 左括号
        int count2 = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ')') {
                count++;
                i--;
            }
            while (i >= 0 && s.charAt(i) == '(') {
                count2++;
                i--;
            }

            int d = count2 * 2 - count;
            if (d >= 0) {
                result += d;
            } else {
                d = -d;
                result += d / 2 + (d % 2 == 0 ? 0 : 2);
            }
            count = 0;
            count2 = 0;
        }
        return result;
    }

    /**
     * 从左到右
     */
    public int minInsertions3(String s) {
        int result = 0;
        // 左括号
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    // 添加(
                    result++;
                } else {
                    count--;
                }
                if (i + 1 >= s.length() || s.charAt(i + 1) != ')') {
                    // 添加)
                    result++;
                } else {
                    i++;
                }
            }
        }
        return result + count * 2;
    }

    public int minInsertions2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    // 添加(
                    count++;
                } else {
                    stack.pollLast();
                }
                if (i + 1 >= s.length() || s.charAt(i + 1) != ')') {
                    // 添加)
                    count++;
                } else {
                    i++;
                }
            }
        }
        return count + stack.size() * 2;
    }
}
