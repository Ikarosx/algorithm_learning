package leetcode.序号.n500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * <img style="width: 100%; max-width: 600px" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/keyboard.png" alt="American keyboard">
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * <p>
 * <p>
 * 相关标签：
 * 数组
 * 哈希表
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/keyboard-row/
 *
 * @author Ikarosx
 * @date 2021/7/8
 */
public class N500键盘行 {

    @Test
    public void test() {
        System.out.println(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }

    public String[] findWords(String[] words) {
        String[] ss = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map.put(Character.toUpperCase(c), i);
                map.put(Character.toLowerCase(c), i);
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        one:
        for (String word : words) {
            int f = map.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                if (map.get(word.charAt(i)) != f) {
                    continue one;
                }
            }
            strings.add(word);
        }
        return strings.toArray(new String[]{});
    }
}