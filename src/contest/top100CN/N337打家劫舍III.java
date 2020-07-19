package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author Ikarosx
 * @date 2020/7/19 10:49
 */
public class N337打家劫舍III {
    // 树的后序遍历
    
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        // 分类讨论的标准是：当前结点偷或者不偷
        // 由于需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        int[] dp = new int[2];
        
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
    
}
