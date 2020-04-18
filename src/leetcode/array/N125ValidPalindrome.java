package leetcode.array;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
 * 
 * Input: "race a car" Output: false
 * 
 * @author Ikaros
 *
 */
public class N125ValidPalindrome {
	public boolean isPalindrome(String s) {
		/**
		 * i:左索引 j:右索引 
		 * 如果
		 */
		s = s.toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			// A:65 Z:90 a:97 z:122
			while (!ifAlphabet(s.charAt(i))) {
				i++;
				if (i >= j) {
					break;
				}
			}
			while (!ifAlphabet(s.charAt(j))) {
				j--;
				if (i >= j) {
					break;
				}
			}
			if (!ifAlphabet(s.charAt(j)) && !ifAlphabet(s.charAt(i))) {
				return true;
			}
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	// 字母返回true，不是字母返回false
	private boolean ifAlphabet(char charAt) {
		int num = charAt + 0;
		if ((num >= 97 && num <= 122) || (num >= 48 && num <= 57))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new N125ValidPalindrome().isPalindrome("0p"));
	}
}
