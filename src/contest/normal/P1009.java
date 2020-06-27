package contest.normal;

import java.util.Scanner;

/**
 * 输入要求
 * 首先输入一个N（1<N<=100)，表示当前班级有N个同学。
 * 接下来的N行，每行分别输入：学号（4位数）、姓名（10个字节内）、C语言成绩、高数成绩和英语成绩。
 * <p>
 * 输出要求
 * 计算每个人的平均分（保留两位小数），输出成绩表。
 * 并输出各科成绩最高学生的姓名和学号，具体分数
 * 详情见输出样例，注意换行，括号为英文括号。
 *
 * @author Ikaros
 * @date 2020/4/8 15:40
 */
public class P1009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n个同学
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Student cMax = new Student("", "", 0, 0, 0);
            Student mathMax = cMax;
            Student englishMax = mathMax;
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                Student student = new Student(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                students[i] = student;
                if (student.getC() > cMax.getC()) {
                    cMax = student;
                }
                if (student.getMath() > mathMax.getMath()) {
                    mathMax = student;
                }
                if (student.getEnglish() > englishMax.getEnglish()) {
                    englishMax = student;
                }
            }
            System.out.println("学号|姓名|C语言|高数|英语|平均分");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println(String.format("C语言最高成绩为是%s(%s)同学的%d分", cMax.getName(), cMax.getStudentId(), cMax.getC()));
            System.out.println(String.format("高数最高成绩为是%s(%s)同学的%d分", mathMax.getName(), mathMax.getStudentId(), mathMax.getMath()));
            System.out.println(String.format("英语最高成绩为是%s(%s)同学的%d分", englishMax.getName(), englishMax.getStudentId(), englishMax.getEnglish()));
            scanner.close();
        }
    }
    
    static class Student {
        private String studentId;
        private String name;
        private int c;
        private int math;
        private int english;
        private double avg;
        
        @Override
        public String toString() {
            return String.format("%s|%s|%d|%d|%d|%.2f", studentId, name, c, math, english, avg);
        }
        
        public Student(String studentId, String name, int c, int math, int english) {
            this.studentId = studentId;
            this.name = name;
            this.c = c;
            this.math = math;
            this.english = english;
            this.avg = (c + math + english) / 3.0;
        }
        
        public String getStudentId() {
            return studentId;
        }
        
        public String getName() {
            return name;
        }
        
        public int getC() {
            return c;
        }
        
        public int getMath() {
            return math;
        }
        
        public int getEnglish() {
            return english;
        }
        
        public double getAvg() {
            return avg;
        }
    }
}
