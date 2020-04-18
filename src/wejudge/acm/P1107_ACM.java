package wejudge.acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 麻婆豆腐是小奏最爱的食物，为了做出最上等的麻婆豆腐，
 * 小奏准备了若干上等的食材，并且获得了传说中的麻婆豆腐的料理方法：
 * 每次将两种食材合二为一，成为一种新的食材，直到所有的食材都合并到一起，传说中的麻婆豆腐就做成了！
 * 然而，每种食材都有不同的料理难度，每次料理两种食材所需的时间是两种食材料理难度相加；
 * 而合二为一的新食材料理难度也是两种食材的料理难度相加。
 * <p>
 * 输入要求
 * 数据有多组输入，第一行输入一个整数n（1<=n<=100），表示食材的数量；
 * 接下来一行为n个整数ai（1<=ai<=100），表示每种食材的料理难度。以EOF结束。
 * <p>
 * 输出要求
 * 对于每组数据，每行输出一个整数，为最短花费时间。
 *
 * @author Ikaros
 * @date 2020/4/8 22:48
 */
public class P1107_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // n表示食材的数量
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(minTime(array));
        }
        scanner.close();
    }
    
    private static int minTime(int[] array) {
        Arrays.sort(array);
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            result += array[i] + array[i - 1];
            array[i] += array[i - 1];
            move(array, i);
        }
        return result;
    }
    
    private static void move(int[] array, int i) {
        int temp = array[i];
        while (i + 1 < array.length && array[i + 1] < temp) {
            array[i] = array[i + 1];
            i++;
        }
        array[i] = temp;
    }
}
