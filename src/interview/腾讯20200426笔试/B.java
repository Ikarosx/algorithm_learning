package interview.腾讯20200426笔试;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/26 19:56
 */
public class B {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // T组数据
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                HashMap<String, Long> map = new HashMap<>();
                // 点的数量
                int n = scanner.nextInt();
                double result = Long.MAX_VALUE;
                int[][] a = new int[n][2];
                int[][] b = new int[n][2];
                for (int j = 0; j < n; j++) {
                    a[j][0] = scanner.nextInt();
                    a[j][1] = scanner.nextInt();
                }
                for (int j = 0; j < n; j++) {
                    b[j][0] = scanner.nextInt();
                    b[j][1] = scanner.nextInt();
                }
                // 对ab进行排序
                Arrays.sort(a, B::compare);
                Arrays.sort(b, B::compare);
                // 遍历AB所有的点，将结果缓存到map中，键为xd-yd，值为两者平方和
                for (int j = 0; j < n; j++) {
                    int ax = a[j][0];
                    int ay = a[j][1];
                    for (int k = 0; k < n; k++) {
                        int bx = b[k][0];
                        int by = b[k][1];
                        // 提前返回
                        if (k >= 1 && bx >= b[k - 1][0] && by >= b[k - 1][1]) {
                            break;
                        }
                        long dx = Math.abs(ax - bx);
                        long dy = Math.abs(ay - by);
                        // 使得dy大，dx小
                        if (dx > dy) {
                            long temp = dy;
                            dy = dx;
                            dx = temp;
                        }
                        String key = String.format("%d-%d", dx, dy);
                        if (map.get(key) == null) {
                            // 缓存里没有，说明没有计算过
                            long temp = dx * dx + dy * dy;
                            if (temp < result) {
                                result = temp;
                            }
                            map.put(key, temp);
                        }
                    }
                }
                System.out.println(String.format("%.3f", Math.sqrt(result)));
            }
        }
        scanner.close();
    }
    
    private static int compare(int[] o1, int[] o2) {
        if (o1[0] > o2[0]) {
            return 1;
        }
        if (o1[0] == o2[0]) {
            return Integer.compare(o1[1], o2[1]);
        }
        return -1;
    }
}
