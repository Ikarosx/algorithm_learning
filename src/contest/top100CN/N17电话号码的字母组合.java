package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author Ikaros
 * @date 2020/6/28 15:43
 */
public class N17电话号码的字母组合 {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new LinkedList<>();
    
    @Test
    public void test() {
        System.out.println(letterCombinations(""));
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return result;
        }
        dfs(digits, 0, "");
        return result;
    }
    
    private void dfs(String digits, int i, String temp) {
        if (i == digits.length()) {
            result.add(temp);
            return;
        }
        String s = map[digits.charAt(i) - '1' + 1];
        int length = s.length();
        for (int j = 0; j < length; j++) {
            dfs(digits, i + 1, temp + s.charAt(j));
        }
    }
}
