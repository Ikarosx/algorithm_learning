package contest.天池20200816;

import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/8/16 10:10
 */
public class A移动的圆 {

    @Test
    public void test() {
        System.out.println(IfIntersect(new double[]{0, 0, 2.5, 3, 2, 0.5, 0, 2}));
    }

    /**
     * @param position: the position of circle A,B and point P.
     *
     * @return: if two circle intersect return 1, otherwise -1.
     */
    public int IfIntersect(double[] position) {
        // write your code here
        // A + B 的半径和,只要最短路径小于这个即可
        double max = position[2] + position[5];
        double a;
        if (position[0] == position[6]) {
            a = 0;
        } else {
            a = (position[1] - position[7]) / (position[0] - position[6]);
        }
        // y^2
        double AB2 =
            Math.pow(position[0] - position[3], 2) + Math.pow(position[1] - position[4], 2);
        // x^2
        double BP2 =
            Math.pow(position[6] - position[3], 2) + Math.pow(position[7] - position[4], 2);
        // k^2
        double K2 = Math.pow(position[0] - position[6], 2) + Math.pow(position[1] - position[7], 2);
        // start
        double start = Math.sqrt(AB2);
        double end = Math.sqrt(BP2);
        // 如果起点的时候已经满足
        if (start <= max) {
            return 1;
        } else if (end <= max) {
            return 1;
        } else if (start < end) {
            // 起点和终点都不满足，且终点距离比起点长
            return -1;
        } else {
            if (a < 0) {
                return -1;
            }
            double m = (BP2 - AB2 + K2) / (2 * Math.sqrt(K2));
            double z = Math.sqrt(BP2 - Math.pow(m, 2));
            return z <= max ? 1 : -1;
        }
        //                // 如果AP斜率小于0，比较BP和max的距离
        //                if (a < 0) {
        //                    return BP2 < max ? 1 : -1;
        //                } else {
        //                    // 如果AP斜率大于等于0，比较B到直线AP的距离和max
        //                    double m = (BP2 - AB2 + K2) / (2 * Math.sqrt(K2));
        //                    double z = Math.sqrt(BP2 - Math.pow(m, 2));
        //                    return z <= max ? 1 : -1;
        //                }
    }
}
