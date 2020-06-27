package interview.vivo.校招2020A;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 小v所在的公司即将举行年会，年会方案设计过程中必不可少的一项就是抽奖活动。小v在本次活动中被委以重任，负责抽奖活动的策划；为了让中奖的礼物更加精美且富有神秘感，打算采用礼品盒来包装奖品，此时小v发挥了自己的创意想捉弄一下获奖的同事，便采取了多重包装来包装奖品。
 * <p>
 * 现给出一个字符串，并假定用一对圆括号( )表示一个礼品盒，0表示奖品，你能据此帮获奖者算出最少要拆多少个礼品盒才能拿到奖品吗？
 *
 * @author Ikaros
 * @date 2020/6/4 15:31
 */
public class C {
    @Test
    public void test() {
        System.out.println(solution("(()(()()(((()(())))))()()()(()()()))()()()((((0))))()()()(()()()()()()))"));
    }
    
    private static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push('(');
            } else if (c == '0') {
                stack.push('0');
            } else if (c == ')') {
                if (stack.peek() == '0') {
                    stack.pop();
                    stack.pop();
                    result++;
                    if (stack.isEmpty()) {
                        return result;
                    }
                    stack.push('0');
                } else {
                    stack.pop();
                }
            }
        }
        return result;
    }
}
