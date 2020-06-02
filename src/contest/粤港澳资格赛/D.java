package collection.粤港澳资格赛;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 体育课上，学生如果站成一排上课会造成很大的麻烦，
 * 现在按照1、2、3的办法报数，报数1的前进2步，报数2的前进1步，
 * 报数3的原地不动，假设刚开始的时候同学们是按照学号站成一排，那么你能输出分成三排后同学的学号么?
 *
 * 输入要求
 * 第一行包括一个整数n，表示班级里有n位学生，班级人数至少是1，不超过100。
 *
 * 第二行包括n个整数，表示站成一排时每个同学的学号。
 *
 * 输出要求
 * 请按顺序输出分开三排后每排每位同学的学号，用空格隔开(每排最后同学后没有空格)。
 *
 * 排好队后，同学站成三排，报1的同学在第1排。
 *
 * 每排队伍的输出格式：同学空格同学空格......同学换行
 * @author Ikaros
 * @date 2020/4/25 10:53
 */
public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<Integer> one = new ArrayList<>();
            ArrayList<Integer> two = new ArrayList<>();
            ArrayList<Integer> zero = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int j = scanner.nextInt();
                if (i % 3 == 1) {
                    // 报数1
                    // 前进2步
                    two.add(j);
                } else if (i % 3 == 2) {
                    // 报数2
                    // 前进1步
                    one.add(j);
                } else {
                    // 报数3
                    // 原地不动
                    zero.add(j);
                }
            }
            printList(two);
            printList(one);
            printList(zero);
        }
        scanner.close();
    }
    
    private static void printList(ArrayList<Integer> two) {
        for (int i = 0; i < two.size(); i++) {
            if (i == two.size() - 1) {
                System.out.print(two.get(i));
            } else {
                System.out.print(two.get(i) + " ");
            }
        }
        if (two.size() != 0) {
            System.out.println();
        }
    }
}
