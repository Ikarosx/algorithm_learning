package collection.GDEI2019程序设计比赛;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 据说冰牙白虎在反抗暗黑达的时候由于用力过猛，导致法力尽失。
 * 但想到当小渡找到他的时候，他居然变成了一个连数都数不清的傻喵。
 * 白虎虽然变成了喵，但是他却依然要给小渡设立考验。
 * 由于白虎大人数不清数了，他想要算数学题就十分困难，
 * 现在他只知道一些整数可以用一个或多个连续的素数和表示。
 * 现在他给出你一个正整数n，你要算出这个整数可以有多少种这样的表示方法。
 * <p>
 * 比如：53 有两种表示方法 5 + 7 + 11 + 13 + 17 和 53
 *
 * @author Ikaros
 * @date 2020/5/5 19:03
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 大坑。。素数是从2开始。。我还在想为什么输入3只有一种
        // 难道不是1+2和3两种吗
        ArrayList<Integer> sushu = getSuShu(10000);
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            // 根据素数数组，从左到右一直加
            // [l...r]表示当前素数范围
            int l = 0;
            int count = 0;
            int sum = 0;
            for (int r = 0; r < sushu.size(); r++) {
                // 如果当前素数已经大于给定值，则说明可以直接退出了
                Integer current = sushu.get(r);
                if (current > value) {
                    break;
                }
                int tempSum = sum + current;
                if (tempSum == value) {
                    // 如果加上当前数后等于给定值
                    // 说明找到了一个方法
                    count++;
                    sum = tempSum - sushu.get(l);
                    l++;
                } else if (tempSum > value) {
                    // 如果加上当前数后大于给定值
                    // 和减去最左边的值，并左端点向右缩进
                    // r--是为了防止后面的r++
                    r--;
                    sum -= sushu.get(l);
                    l++;
                } else {
                    // 如果加上当前数后小于给定值
                    // 那么和直接加上当前值
                    sum = tempSum;
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
    
    private static void printResult(ArrayList<Integer> sushu, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(sushu.get(i) + " ");
        }
        System.out.println();
    }
    
    /**
     * 返回1...n中的素数数组
     *
     * @param n
     *
     * @return
     */
    private static ArrayList<Integer> getSuShu(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(400);
        for (int i = 2; i <= n; i++) {
            boolean flag = false;
            for (int j = 2; j <= i - 1; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }
}
