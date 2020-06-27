package interview.vivo.校招2020B;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 今年7月份vivo迎来了新入职的大学生，现在需要为每个新同事分配一个工号。人力资源部同事小v设计了一个方法为每个人进行排序并分配最终的工号，具体规则是：
 * 将N（N<10000）个人排成一排，从第1个人开始报数；如果报数是M的倍数就出列，报到队尾后则回到队头继续报，直到所有人都出列；
 * 最后按照出列顺序为每个人依次分配工号。请你使用自己擅长的编程语言帮助小v实现此方法。
 *
 * @author Ikaros
 * @date 2020/6/4 13:59
 */
public class B {
    @Test
    public void test() {
        System.out.println(solution(new int[]{6, 3}));
    }
    
    private static String solution(int[] input) {
        Queue<Integer> queueA = new LinkedList<>();
        for (int i = 0; i < input[0]; i++) {
            queueA.add(i + 1);
        }
        int n = input[1];
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (!queueA.isEmpty()) {
            if (++i == n) {
                builder.append(queueA.poll() + " ");
                i = 0;
            } else {
                queueA.add(queueA.poll());
            }
        }
        return builder.toString().substring(0, builder.length() - 1);
    }
}
