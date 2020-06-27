package interview.腾讯2017校招开发工程师笔试试卷二;

import java.util.Scanner;

/**
 * 如何用32个无符号int存1024种状态
 * @author Ikaros
 * @date 2020/4/23 15:51
 */
public class N33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        if (i >= 1 && i <= 1024 && j >= 1 && j <= 1024 && i == j) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
