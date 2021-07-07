package leetcode.序号.n500;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * <ol>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写，&nbsp;比如&nbsp;"Google"。
 * </ol>
 * <p>
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * <p>
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * <p>
 * 相关标签：
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/detect-capital/
 *
 * @author Ikarosx
 * @date 2021/7/7
 */
public class N520检测大写字母 {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        return count == 0 || (count == 1 && Character.isUpperCase(word.charAt(0))) || count == word.length();
    }
}