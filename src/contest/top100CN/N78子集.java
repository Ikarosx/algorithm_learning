package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author Ikaros
 * @date 2020/7/4 8:10
 */
public class N78子集 {
    private List<List<Integer>> result = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();
    
    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, 0);
        return result;
    }
    
    private void dfs(int[] nums, int i) {
        result.add(new LinkedList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            dfs(nums,j + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
