package contest.粤港热身赛;

import java.util.*;

/**
 * 一个小城市有很多人，请列出三人年纪相加为100岁的组合方案。
 * <p>
 * 输入要求
 * 任意多个在[1,99]内的正整数，并且以0作为输入结束符。
 * <p>
 * 输出要求
 * 输出方案。
 * <p>
 * 如果没有三人成百，输出NO,并换行。
 * <p>
 * 如果有三人成百，输出三人成百方案。
 * <p>
 * 格式：
 * <p>
 * A空格B空格C空格换行
 * <p>
 * 如果多组方案
 * <p>
 * 分别按A,B升序排列
 * <p>
 * 具体样式参考输出样例。
 * <p>
 * 输出样例中的中文为说明字符，不需要真正输出
 * <p>
 * 同一方案，比如20，30 ，50 ，有很多组，只列出一组就可以
 *
 * @author Ikaros
 * @date 2020/4/18 21:36
 */
public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<String> result = new HashSet<>();
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (i == 0) {
                break;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
            list.add(i);
        }
        Object[] ints = list.toArray();
        Arrays.sort(ints);
        for (int i = 0; i < ints.length - 2; i++) {
            int anInt = (int) ints[i];
            map.put(anInt, map.get(anInt) - 1);
            for (int j = i + 1; j < ints.length - 1; j++) {
                int bnInt = (int) ints[j];
                int key = 100 - anInt - bnInt;
                Integer integer = map.get(key);
                if (integer != null && integer > 0) {
                    int[] temp = {anInt, bnInt, key};
                    Arrays.sort(temp);
                    result.add(String.format("%d %d %d ", temp[0], temp[1], temp[2]));
                }
            }
            while (i < ints.length - 2 && ints[i + 1] == ints[i]) {
                i++;
            }
            map.put(anInt, map.get(anInt) + 1);
        }
        if (result.size() == 0) {
            System.out.println("NO");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }
        scanner.close();
    }
}
