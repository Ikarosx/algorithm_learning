package leetcode.序号.n300;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * <p>
 * 相关标签：
 * 哈希表
 * 字符串
 * 计数
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/ransom-note/
 *
 * @author Ikarosx
 * @date 2021/6/29
 */
public class N383赎金信 {
	@Test
	public void test () {
		Assert.assertFalse(canConstruct("a", "b"));
		Assert.assertFalse(canConstruct("aa", "ab"));
		Assert.assertTrue(canConstruct("aa", "aab"));
	}

	/**
	 * 桶排序
	 */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteMap = new int[26];
        for (char c : ransomNote.toCharArray()) {
            ransomNoteMap[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
        	// 优化：只操作一个数组，不使用另外的数组来记录第二个字符串
			ransomNoteMap[c - 'a']--;
        }

		for (int i : ransomNoteMap) {
			if (i > 0) {
				return false;
			}
		}
        return true;
    }
}