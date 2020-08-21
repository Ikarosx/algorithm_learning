package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author Ikarosx
 * @date 2020/8/21 21:56
 */
public class N05替换空格 {

    @Test
    public void test() {
        System.out.println(replaceSpace(""));
    }

    public String replaceSpace(String s) {
        int size = 0;
        char[] chars = new char[s.length() * 3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }
        return new String(chars, 0, size);
    }
}
