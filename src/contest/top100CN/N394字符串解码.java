package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author Ikarosx
 * @date 2020/7/20 8:29
 */
public class N394字符串解码 {
    @Test
    public void test() {
        System.out.println(decodeString("20[ab]"));
    }
    
    public String decodeString(String s) {
        // 使用栈
        /*
         * 如果字符为非]直接入栈
         * 如果为]，弹出直到遇到[
         * 并且继续弹出一个数字
         * 得到结果后将结果继续入栈
         */
        Stack<String> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ']') {
                String temp = "";
                while (!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                Integer time = Integer.valueOf(stack.pop());
                StringBuilder afterDecode = new StringBuilder();
                for (Integer integer = 0; integer < time; integer++) {
                    afterDecode.append(temp);
                }
                stack.push(afterDecode.toString());
            } else if (c >= '0' && c <= '9') {
                StringBuilder builder = new StringBuilder();
                builder.append(c);
                char next = s.charAt(i + 1);
                while (next >= '0' && next <= '9') {
                    builder.append(next);
                    i++;
                    next = s.charAt(i + 1);
                }
                stack.push(builder.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
