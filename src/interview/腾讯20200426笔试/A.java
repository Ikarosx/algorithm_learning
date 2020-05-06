package interview.腾讯20200426笔试;


import java.util.Scanner;

/**
 * 模拟队列
 * 插入队尾、取出队首、删除队首、队列大小、清空队列
 *
 * @author Ikaros
 * @date 2020/4/26 19:55
 */
public class A {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 接下来有n组测试用例
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                // 接下来有m次操作
                MyQueue queue = new MyQueue();
                int m = scanner.nextInt();
                for (int j = 0; j < m; j++) {
                    // 每次操作
                    String operation = scanner.next();
                    
                    // 分割字符串
                    switch (operation) {
                        case "PUSH":
                            queue.push(scanner.nextInt());
                            break;
                        case "TOP":
                            System.out.println(queue.top());
                            break;
                        case "POP":
                            if (queue.pop() == -1) {
                                System.out.println(-1);
                            }
                            break;
                        case "SIZE":
                            System.out.println(queue.size());
                            break;
                        case "CLEAR":
                            queue.clear();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        scanner.close();
    }
    
    static class ListNode {
        ListNode next;
        int value;
        int index;
        
        public ListNode(int value) {
            this.value = value;
        }
    }
    
    static class MyQueue {
        private ListNode head;
        private ListNode tail;
        private int size = 0;
        
        void push(int i) {
            ListNode node = new ListNode(i);
            if (size == 0) {
                // 如果队列为空
                head = tail = node;
            } else {
                // 如果队列不为空
                tail.next = node;
                tail = node;
            }
            size++;
        }
        
        int top() {
            return size == 0 ? -1 : head.value;
        }
        
        int pop() {
            // 如果队列为空输出-1
            if (size == 0) {
                return -1;
            }
            int temp = head.value;
            head = head.next;
            size--;
            return temp;
        }
        
        int size() {
            return size;
        }
        
        void clear() {
            // 清空中间的引用 TODO
            head = null;
            tail = null;
            size = 0;
        }
    }
}



