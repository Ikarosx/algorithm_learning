package contest.top100CN;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * TODO
 * @author Ikarosx
 * @date 2020/7/9 8:34
 */
public class N155最小栈 {
    private Stack<Integer> stack = new Stack();
    
    public N155最小栈() {
    
    }
    
    public void push(int x) {
        int min;
        min = stack.isEmpty() ? x : Math.min(stack.peek(), x);
        stack.push(x);
        stack.push(min);
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            stack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            int min = stack.pop();
            int result = stack.peek();
            stack.push(min);
            return result;
        }
        throw new RuntimeException("栈空");
    }
    
    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack.peek();
    }
}
