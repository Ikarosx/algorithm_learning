package interview.神策.神策秋招20210408;

import java.util.*;

/**
 * @author Ikarosx
 * @date 2021/04/08
 */
public class A找出成对括号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = string.toCharArray();
        LinkedList<KV> kvs = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
                continue;
            }
            if (chars[i] == ')') {
                kvs.add(new KV(stack.poll(), i));
            }
        }
        System.out.println(kvs.size());
        kvs.sort(Comparator.comparingInt(kv -> kv.l));
        for (KV kv : kvs) {
            System.out.println(kv.l);
            System.out.println(kv.r);
        }
    }

    static class KV {
        int l;
        int r;

        public KV(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
