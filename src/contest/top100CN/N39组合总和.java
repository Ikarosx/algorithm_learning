package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author Ikarosx
 * @date 2020/7/26 7:51
 */
public class N39组合总和 {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    
    @Test
    public void test() {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 7));
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumImpl(candidates, 0, target);
        return result;
    }
    
    private void combinationSumImpl(int[] candidates, int i, int target) {
        if (target == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (target - candidates[j] < 0) {
                break;
            }
            temp.add(candidates[j]);
            combinationSumImpl(candidates, j, target - candidates[j]);
            temp.remove(temp.size() - 1);
        }
    }
}
