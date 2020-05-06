package interview.腾讯20200426笔试;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/26 19:56
 */
public class C {
    
    @Test
    public void test() {
    
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            
        }
        scanner.close();
    }
}
