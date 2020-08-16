package contest.top100CN;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author Ikarosx
 * @date 2020/8/5 9:14
 */
public class N297二叉树的序列化与反序列化 {

    @Test
    public void test() {
        String s = "1,5,2,null,null,null,3,null,null";
        TreeNode deserialize = deserialize(s);
        System.out.println(serialize(deserialize));
    }

    /**
     * 将树结点序列化为[1,5,2,null,null,null,3]
     *
     * @param root 根节点
     *
     * @return 序列化后的字符串
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                result.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);

            } else {
                result.append("null").append(",");
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }


    /**
     * 将字符串[1,5,2,null,null,null,3]反序列化为树结点
     */
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] strings = data.split(",");
        return deserializeImpl(0, strings);
    }

    private TreeNode deserializeImpl(int i, String[] strings) {
        if (i >= strings.length || "null".equals(strings[i])) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(strings[i]));
        treeNode.left = deserializeImpl(i * 2 + 1, strings);
        treeNode.right = deserializeImpl(i * 2 + 2, strings);
        return treeNode;
    }
}
