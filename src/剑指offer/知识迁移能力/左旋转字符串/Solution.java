package 剑指offer.知识迁移能力.左旋转字符串;

import org.junit.jupiter.api.Test;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author Ikaros
 * @date 2020/5/7 9:46
 */
public class Solution {
    @Test
    public void test() {
        String abcXYZdef = LeftRotateString("abcXYZdef", 0);
        System.out.println(abcXYZdef);
    }
    
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        n %= str.length();
        return str.substring(n) + str.substring(0, n);
    }
}
