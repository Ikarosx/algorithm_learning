package leetcode.sign;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *  
 * 示例：
 * <p>
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/03/13
 */
public class N705设计哈希集合 {
    // 链地址法
    class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node[] data;

    /**
     * Initialize your data structure here.
     */
    public N705设计哈希集合() {
        data = new Node[10000];
    }

    public void add(int key) {
        int k = key % 10000;
        if (data[k] == null) {
            data[k] = new Node(key, null);
        } else {
            Node node = data[k];
            while (node.value != key && node.next != null) {
                node = node.next;
            }
            if (node.value != key) {
                node.next = new Node(key, null);
            }

        }
    }

    public void remove(int key) {
        int k = key % 10000;
        Node node = data[k];
        if (node == null) {
            return;
        }
        if (node.value == key) {
            data[k] = node.next;
            return;
        }
        while (node != null) {
            if (node.next != null && node.next.value == key) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int k = key % 10000;
        Node node = data[k];
        while (node != null) {
            if (node.value == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
