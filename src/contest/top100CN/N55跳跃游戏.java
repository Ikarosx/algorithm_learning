package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author Ikaros
 * @date 2020/7/2 20:34
 */
public class N55跳跃游戏 {
    @Test
    public void test() {
        System.out.println(canJump(new int[]{0, 1}));
    }
    
    public boolean canJump(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
