package contest.top100CN;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author Ikaros
 * @date 2020/7/2 22:03
 */
public class N56合并空间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            }
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            }
            return 0;
        });
        LinkedList<int[]> ints = new LinkedList<>();
        if (intervals.length == 1) {
            return intervals;
        }
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                // 合并
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else {
                ints.add(intervals[i - 1]);
            }
        }
        ints.add(intervals[intervals.length - 1]);
        int[][] result = new int[ints.size()][2];
        return ints.toArray(result);
    }
}
