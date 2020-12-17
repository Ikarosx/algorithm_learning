package interview.美团点评.美团20201018校招;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小团有一个由N个节点组成的二叉树，每个节点有一个权值。定义二叉树每条边的开销为其两端节点权值的乘积，二叉树的总开销即每条边的开销之和。小团按照二叉树的中序遍历依次记录下每个节点的权值，即他记录下了N个数，第 i 个数表示位于中序遍历第 i 个位置的节点的权值。之后由于某种原因，小团遗忘了二叉树的具体结构。在所有可能的二叉树中，总开销最小的二叉树被称为最优二叉树。现在，小团请小美求出最优二叉树的总开销。
 *
 * 例如：7 6 5 1 3
 *
 * 最优二叉树如图所示，总开销为7*1+6*5+5*1+1*3=45。
 *
 *
 *
 *
 *
 * 输入描述
 * 第一行输入一个整数N（1<=N<=300），表示二叉树的节点数。
 *
 * 第二行输入N个由空格隔开的整数，表示按中序遍历记录下的各个节点的权值，所有权值均为不超过1000的正整数。
 *
 * 输出描述
 * 输出一个整数，表示最优二叉树的总开销。
 *
 *
 * 样例输入
 * 5
 * 7 6 5 1 3
 *
 * @author Ikarosx
 * @date 2020/10/18 10:58
 */
public class D最优二叉树II {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 二叉树的结点
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = scanner.nextInt();
            }
            for (int i = 0; i < ints.length; i++) {
                // 遍历每个点为根节点的情况
                int sum = dfs(ints, 0, ints.length - 1, i, 0);
                result = Math.min(sum, result);
            }
            System.out.println(result);
        }
        scanner.close();
    }

    private static int dfs(int[] ints, int l, int r, int index, int sum) {
        if (l >= r) {
            return sum;
        }
        int currentRoot = ints[index];
        int lMin = 0;
        int minValue = l;
        for (int i = l; i < index; i++) {
            if (ints[minValue] > ints[i]) {
                minValue = i;
            }
        }
        if (l < index) {
            lMin = dfs(ints, l, index - 1, minValue, currentRoot * ints[minValue]);
        }
        int rMin = 0;
        minValue = index + 1;
        for (int i = index + 1; i <= r; i++) {
            if (ints[minValue] > ints[i]) {
                minValue = i;
            }
        }
        if (minValue <= r) {
            rMin = dfs(ints, index + 1, r, minValue, currentRoot * ints[minValue]);
        }
        return sum + lMin + rMin;
    }
}
