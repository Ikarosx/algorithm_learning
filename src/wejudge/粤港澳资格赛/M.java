package wejudge.粤港澳资格赛;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 实验老师要将购置的化学物品装箱，这些化学物品是简单化合物，
 * 每个化学物品由两种化学元素组成，用x+y表示，
 * 其中x和y是用整数表示的化学元素。装箱有一个安全隐患，
 * 如果箱子里任何n个化学物品，正好包含n种元素，
 * 那么将组成一个容易爆炸的混合物。
 * 为了安全，实验老师每拿到一个化学物都要进行判断，
 * 如果与已装箱的化学物形成易爆，就不装箱，否则就装箱。
 * 假设实验老师按照输入的顺序进行装箱，编程输出有多少个化学物没有装箱。
 * 例如1+2、2+3、1+3，三组三种元素就易爆。
 * 再如1+2, 7+2, 4+6, 1+5，四组六种元素不会易爆，
 * 但再加5+7就不行，因为1+2, 7+2, 1+5, 5+7就组成四组四种元素，
 * 所以5+7就不能装箱。
 * <p>
 * 输入要求
 * 数据包含若干行，每行输入2个整数x,y(0<=x,y<=105)代表一个由元素x和y组成的化学物品。数据用-1结尾。
 * <p>
 * 化学元素和化学物品的个数不确定，但在正整数范围之内。
 * <p>
 * 输出要求
 * 输出没有装箱的化学物数量，并换行
 *
 * @author Ikaros
 * @date 2020/4/25 15:06
 */
public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            if (x == -1) {
                break;
            }
            int y = scanner.nextInt();
            int temp = set.size();
            if (!set.contains(x)) {
                temp++;
            }
            if (!set.contains(y)) {
                temp++;
            }
            if (count + 1 == temp) {
                result++;
                continue;
            }
            count++;
            set.add(x);
            set.add(y);
            
        }
        System.out.println(result);
        scanner.close();
    }
}
