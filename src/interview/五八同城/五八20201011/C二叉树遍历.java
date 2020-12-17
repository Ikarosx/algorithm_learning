package interview.五八同城.五八20201011;

import java.util.ArrayList;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/10/11 20:36
 */
public class C二叉树遍历 {

    @Test
    public void test() {
        System.out.println(binaryTreeScan(new int[]{1, 7, 2, 6, -1, 4, 8}));
    }

    /**
     * 对给定的二叉树依次完成前序，中序，后序遍历，并输出遍历结果
     *
     * @param input int整型一维数组 -1表示Nil节点
     *
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> binaryTreeScan(int[] input) {
        // write code here
        TreeNode head = generateTreeNodeByArray(input, 0, input.length - 1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(preOrder(head, new ArrayList<>()));
        result.add(inOrder(head, new ArrayList<>()));
        result.add(afterOrder(head, new ArrayList<>()));
        return result;
    }

    private ArrayList<Integer> afterOrder(TreeNode head, ArrayList<Integer> list) {
        if (head == null) {
            return list;
        }
        afterOrder(head.left, list);
        afterOrder(head.right, list);
        list.add(head.val);
        return list;
    }

    private ArrayList<Integer> inOrder(TreeNode head, ArrayList<Integer> list) {
        if (head == null) {
            return list;
        }
        inOrder(head.left, list);
        list.add(head.val);
        inOrder(head.right, list);
        return list;
    }

    private ArrayList<Integer> preOrder(TreeNode head, ArrayList<Integer> list) {
        if (head == null) {
            return list;
        }
        list.add(head.val);
        preOrder(head.left, list);
        preOrder(head.right, list);
        return list;
    }

    private TreeNode generateTreeNodeByArray(int[] input, int i, int length) {
        if (input[i] == -1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(input[i]);
        if (i * 2 + 1 <= length) {
            treeNode.left = generateTreeNodeByArray(input, i * 2 + 1, length);
        }
        if (i * 2 + 2 <= length) {
            treeNode.right = generateTreeNodeByArray(input, i * 2 + 2, length);
        }
        return treeNode;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
