package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/solution/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/
 *
 * @author Ikarosx
 * @date 2020/7/14 8:22
 */
public class N207课程表 {
    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] set = new HashSet[numCourses];
        int[] ints = new int[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {
            set[i] = new HashSet<>();
        }
        
        for (int[] p : prerequisites) {
            ints[p[0]]++;
            set[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ints[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            HashSet<Integer> list = set[poll];
            for (Integer integer : list) {
                ints[integer]--;
                if (ints[integer] == 0) {
                    queue.add(integer);
                }
            }
            
        }
        return count == numCourses;
    }
}
