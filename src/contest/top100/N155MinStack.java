package contest.top100;

/**
 * @author Ikaros
 * @date 2020/6/8 23:33
 */
public class N155MinStack {
    class StackNode{
        int value;
        int min;
        StackNode next;
    
        public StackNode(int value) {
            this.value = value;
        }
    }
    
    class MinStack {
        StackNode top;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
        
        }
        
        public void push(int x) {
            StackNode stackNode = new StackNode(x);
            if (null == top) {
                stackNode.min = x;
            }else {
                stackNode.min = Math.min(top.min, x);
                stackNode.next = top;
            }
            top = stackNode;
        }
        
        public void pop() {
            top = top.next;
        }
        
        public int top() {
            return top.value;
        }
        
        public int getMin() {
            return top.min;
        }
    }
}
