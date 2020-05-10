package 剑指offer.字符串;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author Ikaros
 * @date 2020/5/8 18:52
 */
public class 字符流中第一个不重复的字符 {
    int[] chars = new int[256];
    Queue<Character> queue = new LinkedList<>();
    
    @Test
    public void test() {
        Insert('g');
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        Insert('g');
        Insert('l');
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }
    
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (++chars[ch] == 1) {
            queue.add(ch);
        } else {
            queue.remove(ch);
        }
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.peek() == null ? '#' : queue.peek();
    }
}
