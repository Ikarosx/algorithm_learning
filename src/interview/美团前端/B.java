package interview.美团前端;

/**
 * 近期某商场由于周年庆，开启了“0元购”活动。活动中，
 * 消费者可以通过组合手中的代金券，实现0元购买指定商品。
 * <p>
 * 聪明的小团想要用算法来帮助他快速计算：对于指定价格的商品，
 * 使用代金券凑出其价格即可，但所使用的代金券总面额不可超过商品价格。
 * 由于代金券数量有限，使用较少的代金券张数则可以实现价值最大化，即最佳优惠。
 * <p>
 * 假设现有100元的商品，而代金券有50元、30元、20元、5元四种，
 * 则最佳优惠是两张50元面额的代金券；而如果现有65元的商品，
 * 则最佳优惠是两张30元代金券以及一张5元代金券。
 * <p>
 * 请你帮助小团使用一段代码来实现代金券计算。
 *
 * @author Ikaros
 * @date 2020/5/10 16:17
 */

import java.util.Arrays;
import java.util.Scanner;

public class B {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            // 一共P元
            int P = scanner.nextInt();
            if (P == 0) {
                break;
            }
            // N种代金券
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            // 求最小券张数
            int solution = solution(array, P);
            System.out.println(solution == Integer.MAX_VALUE ? "Impossible" : solution);
        }
        scanner.close();
    }
    
    private static int solution(int[] array, int p) {
        int[] ints = new int[p + 1];
        for (int i = 0; i < ints.length; i++) {
            // 比起最小的还不行说明前面的钱都不行
            ints[i] = Integer.MAX_VALUE;
        }
        for (int value : array) {
            if (value < ints.length) {
                ints[value] = 1;
            }
        }
        for (int i = array[0] + 1; i <= p; i++) {
            int min = ints[i];
            for (int j = 1; j <= i / 2; j++) {
                if (ints[j] != Integer.MAX_VALUE && ints[i - j] != Integer.MAX_VALUE) {
                    min = Math.min(min, ints[j] + ints[i - j]);
                }
            }
            ints[i] = min;
        }
        return ints[p];
    }
}