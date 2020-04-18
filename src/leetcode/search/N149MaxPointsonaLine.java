package leetcode.search;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given n points on a 2D plane, find the maximum number of
 * points that lie on the same straight line.
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method
 * signature.
 *
 * @author Ikaros
 */
public class N149MaxPointsonaLine {
    // 斜率有误差。. TODO
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 0 || n == 1) {
            return n;
        }
        Map<String, Set<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // 找出任意两个点的直线表示方式，将其存入map
                // 值为对应的set集合，set存索引
                // 特殊情况：横竖，两点相同
                String re = cal(points[i], points[j]);
                map.computeIfAbsent(re, k -> new HashSet<>());
                map.get(re).add(i);
                map.get(re).add(j);
                
            }
        }
        for (Set set : map.values()) {
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }
    
    private String cal(int[] is, int[] is2) {
        int dy = is2[1] - is[1];
        int dx = is2[0] - is[0];
        double xielv;
        double b;
        String result;
        if (dy == 0) {
            b = is[1];
            result = "0:" + b;
        } else if (dx == 0) {
            b = is[0];
            result = "INFINITY:" + b;
        } else {
            xielv = dy / (dx + 0.0);
            b = is[1] - xielv * is[0];
            result = xielv + ":" + b;
        }
        return result;
    }
    
    @Test
    public void test() {
        int[][] array = {{1, 1}, {1, 1}, {1, 1}, {1, 1}, {3, 3}};
        System.out.println(maxPoints(array));
        // System.out.println(0 == -0.0);
    }
}
