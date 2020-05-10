package 剑指offer.树;


/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author Ikaros
 * @date 2020/5/8 21:46
 */
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null || (pNode.next == null && pNode.right == null)) {
            return null;
        }
        if (pNode.right != null) {
            // 找到右子树里的最左树
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            // 判断是左节点还是右节点
            // 如果是左节点，则下一个结点就是父节点
            // 如果有右节点，则下一个结点就是父节点的父节点
            if (pNode.next.left == pNode) {
                // 左节点
                return pNode.next;
            } else {
                // 右节点
                // 循环处理
                // 如果父节点A是A的父节点B的左节点，返回B，如果B为空，返回空
                // 如果父节点A是A的父节点B的右节点，重复进行，直到是左节点或者为空
                while (true) {
                    TreeLinkNode p = pNode.next;
                    TreeLinkNode pp = p.next;
                    if (pp == null) {
                        return null;
                    }
                    if (pp.left == p) {
                        // 左节点
                        return pp;
                    }
                    // 是右节点
                    pNode = pNode.next;
                }
            }
        }
    }
    
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        
        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
