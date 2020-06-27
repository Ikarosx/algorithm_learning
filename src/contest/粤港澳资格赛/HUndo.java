package contest.粤港澳资格赛;

import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/25 11:38
 */
public class HUndo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < array.length; j++) {
                array[j] = scanner.nextInt();
            }
            int result = 0;
            
            System.out.println(String.format("Case #%d: %d", i + 1, result));
        }
        scanner.close();
    }
}
