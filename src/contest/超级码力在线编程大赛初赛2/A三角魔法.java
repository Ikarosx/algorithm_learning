package contest.超级码力在线编程大赛初赛2;

import java.util.List;

/**
 * @author Ikarosx
 * @date 2020/8/30 10:23
 */
public class A三角魔法 {

    /**
     * @param triangle: Coordinates of three points
     * @param point: Xiaoqi's coordinates
     *
     * @return: Judge whether you can cast magic
     */
    public String castMagic(List<List<Integer>> triangle, int[] point) {
        // write your code here
        int[][] ints = new int[3][2];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);
            ints[i][0] = integers.get(0);
            ints[i][1] = integers.get(1);
        }
        if (ints[1][1] < ints[0][1]) {
            swap(ints, 0, 1);
        }
        // 此时ints[0]为y最小的
        // 但可能存在y同小,x不同的第三个点
        if (ints[2][1] == ints[0][1]) {
            swap(ints, 1, 2);
            if (ints[0][0] < ints[1][0]) {
                swap(ints, 0, 1);
            }
        }
        // 此时ints[0]表示最右下角的点
        // ints[1]表示左下角的点
        // 设012分别为ABC
        // 则当前所在点point应该在AB上方
        // AC斜率为正，上方，AC斜率为负，下方
        // BC斜率为正，下方，AC斜率为负，上方
        return "";
    }

    private void swap(int[][] ints, int i, int j) {
        int tempx = ints[i][0];
        int tempy = ints[i][1];
        ints[i][0] = ints[j][0];
        ints[i][1] = ints[j][1];
        ints[j][1] = tempy;
        ints[j][1] = tempx;
    }
}
