package 剑指offer.知识迁移能力.翻转单词顺序列;

import org.junit.jupiter.api.Test;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author Ikaros
 * @date 2020/5/7 9:56
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(ReverseSentence(""));
    }
    
    public String ReverseSentence(String str) {
        // if (str.trim().equals("")) {
        //     return str;
        // }
        String[] s = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            stringBuilder.append(s[i]);
            if (i > 0) {
                stringBuilder.append(' ');
            }
        }
        // 先旋转单词，再旋转字符串
        return stringBuilder.toString();
    }
}
