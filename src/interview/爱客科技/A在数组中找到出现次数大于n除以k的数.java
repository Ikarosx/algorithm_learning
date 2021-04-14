package interview.爱客科技;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2021/04/14
 */
public class A在数组中找到出现次数大于n除以k的数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / k)) {
                flag = true;
                System.out.print(entry.getKey() + " ");
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
        scanner.close();
    }
}
