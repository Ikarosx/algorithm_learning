package contest.top100CN;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * TODO
 *
 * @author Ikarosx
 * @date 2020/8/1 7:32
 */
public class N128最长连续序列 {

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{1, 2, 2, 3, 333, 4, 5}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
