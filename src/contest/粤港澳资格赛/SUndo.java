package contest.粤港澳资格赛;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 鲍勃最近在写论文，为了提升写作效率他需要一款好用的输入法。
 * 然而，市面上的输入法大都是为普罗大众准备的，词库中往往没有论文里需要的专有词汇。
 * 于是鲍勃决定自己开发一款输入法，帮助自己更高效的完成论文。
 * <p>
 * 输入要求
 * 输入法首先需要构建词库。第一行是一个数字n，代表词库的词数（n ≤ 100000），
 * 随后n行内容为n个单词，需要用这些单词构建词库。单词由不超过50个小写字母构成。
 * 单词可能重复，词库中重复出现的单词输入法视为同一个单词。
 * <p>
 * 下一行是一个数字q，代表接下来输入法输入q个单词（q ≤10000），
 * 随后q行内容为q个单词，代表需要输入的单词。
 * 单词由不超过50个小写字母构成。若输入单词不在词库中，
 * 且词库中没有以这个单词为前缀的其他单词，这个单词应当被加入词库中。
 * <p>
 * 输出要求
 * 当一个单词被输入后，输入法应将词库中所有以此单词为前缀的单词作为候选词输出。
 * 当前单词本身也应作为候选词输出，不论这个词是否在词库中。
 * 候选词需按照字典序输出，每个词输出完成后均有一换行。
 * 因输入法UI面积有限，每次最多输出50个候选词。
 *
 * @author Ikaros
 * @date 2020/4/25 13:06
 */
public class SUndo {
    @Test
    public void test() {
        TreeSet<String> strings = new TreeSet<>();
        strings.add("te");
        System.out.println(strings.higher("te"));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<String> strings = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String string = scanner.next();
            // 输出所有前缀为string的词
            String ceiling = strings.higher(string);
            // 若输入单词不在词库中，且词库中没有以这个单词为前缀的其他单词
            if (!strings.contains(string) && (ceiling == null || !ceiling.startsWith(string))) {
                // 这个单词应当被加入词库中
                strings.add(string);
            }
            System.out.println(string);
            int count = 49;
            while (ceiling != null && ceiling.startsWith(string) && count > 0) {
                System.out.println(ceiling);
                ceiling = strings.higher(ceiling);
                count--;
            }
        }
        scanner.close();
    }
}
