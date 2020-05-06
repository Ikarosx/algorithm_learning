package interview.腾讯20200426笔试;


import java.util.Scanner;
import java.util.Stack;

/**
 * @author Ikaros
 * @date 2020/4/26 19:56
 */
public class D {
    
    /**
     * 两个栈实现队列
     * 思路：B栈存队列对应的顺序，当B栈为空时将A栈弹出放入B栈中
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // N表示操作总数
            int N = scanner.nextInt();
            MyQueue queue = new MyQueue();
            for (int i = 0; i < N; i++) {
                // 获取操作
                String operation = scanner.next();
                switch (operation) {
                    case "add":
                        queue.add(scanner.nextInt());
                        break;
                    case "poll":
                        queue.poll();
                        break;
                    case "peek":
                        System.out.println(queue.peek());
                        break;
                    default:
                        System.out.println("无效操作");
                        break;
                }
            }
        }
        scanner.close();
    }
    
    static class MyQueue {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        
        void add(Integer value) {
            // 入栈直接入A
            stackA.push(value);
        }
        
        int poll() {
            checkEmpty();
            return stackB.pop();
        }
        
        int peek() {
            checkEmpty();
            return stackB.peek();
        }
        
        private void checkEmpty() {
            // 如果B栈为空，A弹出入B
            if (stackB.isEmpty()) {
                aToB();
            }
            if (stackB.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
        }
        
        void aToB() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }
    
}

