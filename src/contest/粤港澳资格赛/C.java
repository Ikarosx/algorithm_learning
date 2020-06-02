package collection.粤港澳资格赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 小明掌握的英文单词量不多，所以每次写英文作业的时候，
 * 总是爱重复使用他熟悉的那几个单词。为此，他的英文老师规定，
 * 每次英文作业重复单词的使用率不能超过50%。也就是说，
 * 如果小明的英文作业中有100个英文单词，那么只出现1次的单词不能少于50个。
 * <p>
 * 输入要求
 * 有多组数据（少于10组），每组一行，就是一篇小文章。输入是经过处理的，只包含字母和空格，每篇文章的单词数量不超过100个，每个单词的字符数不超过20个。遇到#时表示输入结束。
 * <p>
 * 输出要求
 * 如果每组输入符合英文老师的要求，则输出yes，否则输出no，然后换行。
 *
 * @author Ikaros
 * @date 2020/4/25 9:38
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            HashMap<String, Integer> map = new HashMap<>();
            String string = scanner.nextLine();
            if (string.equals("#")) {
                return;
            }
            String[] split = string.split(" ");
            int count = 0;
            for (String s : split) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() == 1) {
                    count++;
                }
            }
            if (count / (split.length + 0.0) >= 0.5) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        scanner.close();
    }
}
