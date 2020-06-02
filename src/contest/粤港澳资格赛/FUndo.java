package collection.粤港澳资格赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/25 11:15
 */
public class FUndo {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            calc(i + 1);
        }
        scanner.close();
    }
    
    private static void calc(int count) {
        // 序列长度
        int n = scanner.nextInt();
        int result = 0;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int[] ints = Arrays.copyOf(array, array.length);
        
        System.out.println(String.format("Case #%d: %d", count, result));
    }
}
