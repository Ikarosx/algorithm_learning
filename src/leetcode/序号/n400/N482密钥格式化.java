package leetcode.序号.n400;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 * <p>
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * <p>
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * &nbsp;    注意，两个额外的破折号需要删掉。
 * <p>
 * 示例 2：
 * <p>
 * 输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 * <p>
 * 提示:
 *
 * <ol>
 * S 的长度可能很长，请按需分配大小。K 为正整数。
 * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 * S 非空
 * </ol>
 * <p>
 * <p>
 * 相关标签：
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/license-key-formatting/
 *
 * @author Ikarosx
 * @date 2021/7/8
 */
public class N482密钥格式化 {

    @Test
    public void test() {
        Assertions.assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
        Assertions.assertEquals("2-5G-3J", licenseKeyFormatting("2-5g-3-J", 2));
    }

    public String licenseKeyFormatting(String s, int k) {
        // 从右边开始拆分
        int temp = k;
		s = s.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        for (int length = s.length() - 1; length >= 0; length--) {
            char c = s.charAt(length);
            // 将字符插入开头
            sb.append(Character.toUpperCase(c));
            if (--temp == 0 && length != 0) {
                // 如果已经到了k个字符，重置temp计数
                temp = k;
                // 开头插入-
                sb.append('-');
            }
        }
        return sb.reverse().toString();

    }
}