package contest.蓝桥杯;

import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/12/27 18:31
 */
public class A {


    @Test
    public void solutionA() {
        //        问题描述
        //　　如果整数 a 是整数 b 的整数倍，则称 b 是 a 的约数。
        //　　请问，有多少个正整数是 2020 的约数。
        int i = 2020;
        int result = calcYueShu(2020);
        System.out.println(result);
    }

    @Test
    public void solutionB() {
        //        问题描述
        //　　如果一个 mp3 文件占用磁盘的大小是 4MB，小蓝的硬盘还剩下 100GB 的空间，请问他还可以放多少个这样的 mp3 文件？
        System.out.println(100 * 1024 / 4);
    }

    @Test
    public void solutionC() {
        //    问题描述
        //　　一个包含 2020 个结点的无向图，如果图中没有自环和重边，最多包含多少条边？
        int result = 0;
        for (int i = 1; i < 2020; i++) {
            result += i;
        }
        System.out.println(result);
    }


    @Test
    public void solutionD() {
        //    整数 1 到 6 连在一起，成为 123456，长度为 6。
        //        　　整数 1 到 12 连在一起，成为 123456789101112，长度为 15。
        //        　　请问整数 1 到 2020 连在一起，长度为多少？
        int result = 0;
        for (int i = 1; i <= 2020; i++) {
            result += String.valueOf(i).length();
        }
        System.out.println(result);
    }

    @Test
    public void solutionE() {
        //在一个序列 a = (a[1], a[2], ..., a[n]) 中，如果 (i, j) 满足 i < j 且 a[i] > a[j]，则称为一个逆序对。
        //　　例如：(3, 2, 2, 1) 中包含 6 个逆序对。
        //　　请问，(87, 39, 35, 1, 99, 10, 54, 1, 46, 24, 74, 62, 49, 13, 2, 80, 24, 58, 8, 14, 83, 23, 97, 85, 3, 2, 86, 10, 71, 15) 中包含多少个逆序对？
        int[] ints = new int[]{87, 39, 35, 1, 99, 10, 54, 1, 46, 24, 74, 62, 49, 13, 2, 80, 24, 58,
            8, 14, 83, 23, 97, 85, 3, 2, 86, 10, 71, 15};
        int result = 0;
        int n = ints.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ints[i] > ints[j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private int calcYueShu(int i) {
        int result = 0;
        for (int k = 1; k <= i; k++) {
            if (i % k == 0) {
                result++;
                System.out.print(k + " ");
            }
        }
        return result;
    }
}
