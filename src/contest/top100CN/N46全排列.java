package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author Ikaros
 * @date 2020/7/1 11:22
 */
public class N46全排列 {
    boolean[] visit;
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    
    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3,4}));
    }
    
    public List<List<Integer>> permute(int[] nums) {
        visit = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }
    
    private void dfs(int[] nums, int i) {
        if (i >= nums.length) {
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            temp.add(nums[j]);
            dfs(nums, i + 1);
            temp.remove(temp.size() - 1);
            visit[j] = false;
        }
    }
}
