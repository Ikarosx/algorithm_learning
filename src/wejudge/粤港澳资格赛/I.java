package wejudge.粤港澳资格赛;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 到期末了，学校要对本学期前5名的同学进行表彰，根据C语言、高数、英语三门成绩的总分按从高到低排序；
 * 总分相同的情况下，按C语言成绩从高到低排序；
 * 如C语言也相同，则按编号由小到大排序，编号就是输入的顺序，第一个输入的编号为1，以此类推。
 * <p>
 * 输入要求
 * 第1行输入学生数n，最小为6，最大为100
 * <p>
 * 第2行到n+1行输入n个学生C语言、高数、英语3门功课的成绩（成绩均为0-100之间的整数）
 * <p>
 * 输出要求
 * 输出前5名学生的编号、C语言、高数、英语成绩
 *
 * @author Ikaros
 * @date 2020/4/25 11:46
 */
public class I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Student(i + 1, scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        list.sort((o1, o2) -> {
            if (o1.sum > o2.sum) {
                return 1;
            }
            if (o1.sum.equals(o2.sum)) {
                if (!o1.c.equals(o2.c)) {
                    return o1.c.compareTo(o2.c);
                }
                if (!o1.math.equals(o2.math)) {
                    return o1.math.compareTo(o2.math);
                }
                if (!o1.english.equals(o2.english)) {
                    return o1.math.compareTo(o2.math);
                }
                // 成绩相同比较编号
                return o2.num.compareTo(o1.num);
            }
            return -1;
        });
        int size = list.size();
        for (int i = size - 1; i >= size - 5; i--) {
            System.out.println(list.get(i));
        }
        scanner.close();
    }
    
    static class Student {
        Integer num;
        Integer c;
        Integer math;
        Integer english;
        Integer sum;
        
        public Student(int num, int c, int math, int english) {
            this.num = num;
            this.c = c;
            this.math = math;
            this.english = english;
            this.sum = c + math + english;
        }
        
        @Override
        public String toString() {
            return String.format("%d %d %d %d", num, c, math, english);
        }
    }
}
