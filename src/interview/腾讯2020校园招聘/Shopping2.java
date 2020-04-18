package interview.腾讯2020校园招聘;

import java.util.Scanner;
import java.util.Stack;

/**
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，
 * 一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，
 * 所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
 * （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 * <p>
 * 输入描述:
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=wi<=100000;
 * <p>
 * 输出描述:
 * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 * <p>
 * 输入例子1:
 * 6
 * 5 3 8 3 2 5
 * <p>
 * 输出例子1:
 * 3 3 5 4 4 4
 *
 * @author Ikaros
 * @date 2020/4/13 16:34
 */
public class Shopping2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println(shopping(ints));
        scanner.close();
    }
    
    private static String shopping(int[] ints) {
        // 单调栈
        StringBuilder result = new StringBuilder();
        Stack<Integer> rightStack = new Stack<>();
        Stack<Integer> leftStack = new Stack<>();
        rightStack.push(ints[ints.length - 1]);
        leftStack.push(ints[0]);
        int[] rightInt = new int[ints.length];
        int[] leftInt = new int[ints.length];
        for (int i = ints.length - 2; i >= 0; i--) {
            // 右单调栈
            Integer rightPop = rightStack.pop();
            while (!rightStack.isEmpty()) {
                if (rightStack.peek() <= rightPop) {
                    rightStack.pop();
                } else {
                    break;
                }
            }
            rightStack.push(rightPop);
            rightInt[i] = rightStack.size();
            rightStack.push(ints[i]);
            // 左单调栈
            Integer leftPop = leftStack.pop();
            while (!leftStack.isEmpty()) {
                if (leftStack.peek() <= leftPop) {
                    leftStack.pop();
                } else {
                    break;
                }
            }
            leftStack.push(leftPop);
            leftInt[ints.length - i - 1] = leftStack.size();
            leftStack.push(ints[ints.length - i - 1]);
        }
        for (int i = 0; i < leftInt.length; i++) {
            result.append(leftInt[i] + rightInt[i] + 1 + " ");
        }
        return result.toString();
    }
    
}
