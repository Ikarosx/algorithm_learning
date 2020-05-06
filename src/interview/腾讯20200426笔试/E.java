package interview.腾讯20200426笔试;


import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/26 19:56
 */
public class E {
    /**
     * 存层次的数量
     */
    static long[] array = new long[61];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] * 2 + 1;
        }
        while (scanner.hasNext()) {
            int Q = scanner.nextInt();
            for (int i = 0; i < Q; i++) {
                System.out.println(findParent(scanner.nextLong(), scanner.nextInt()));
            }
        }
        scanner.close();
    }
    
    /**
     * @param x
     *         输入结点的编号
     * @param k
     *         目标祖先结点的深度
     *
     * @return 返回一个编号为x的结点在深度为k的祖先节点的编号，不存在输出-1
     */
    private static long findParent(long x, int k) {
        // 得到x编号的深度
        int xk = getDepth(x);
        if (k >= xk) {
            // 如果祖先节点深度大于等于当前结点深度返回-1
            return -1;
        }
        // 父节点 = x / 2 ...
        while (xk != k) {
            xk--;
            x /= 2;
        }
        return x;
    }
    
    private static int getDepth(long x) {
        for (int i = 1; i < array.length; i++) {
            if (x <= array[i]) {
                return i;
            }
        }
        return -1;
    }
}
