package leetcode.array;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 * @author Ikaros
 *
 */
public class N345ReverseVowelsofaString {
	public String reverseVowels(String s) {
		// i:左索引 j:右索引
		String vowels = "aeiouAEIOU";
		int i = 0, j = s.length() - 1;
		char[] charArray = s.toCharArray();
		one: while (i < j) {
			while (vowels.indexOf(charArray[i]) == -1) {
				i++;
				if (i >= j) {
					break one;
				}
			}
			while (vowels.indexOf(charArray[j]) == -1) {
				j--;
				if (i >= j) {
					break one;
				}
			}
			char temp = charArray[i];
			charArray[i++] = charArray[j];
			charArray[j--] = temp;

		}
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {

	}
}
