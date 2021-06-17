package leetcode.序号.n300;

import org.junit.jupiter.api.Test;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须<a href="https://baike.baidu.com/item/原地算法">原地</a>修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 <a href="https://baike.baidu.com/item/ASCII">ASCII</a> 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 相关标签：
 * 双指针
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/reverse-string/
 *
 * @author Ikarosx
 * @date 2021/6/17
 */
public class N344反转字符串 {

    @Test
    public void test() {
        char[] s = {'a'};
        reverseString(s);
        System.out.println(s[0]);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}