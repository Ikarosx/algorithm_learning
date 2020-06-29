package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author Ikaros
 * @date 2020/6/28 17:33
 */
public class N22括号生成 {
    private List<String> result = new LinkedList<>();
    
    @Test
    public void test() {
        System.out.println(generateParenthesis(1));
    }
    
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        dfs(n - 1, n, new StringBuilder("("));
        return result;
    }
    
    private void dfs(int i, int n, StringBuilder builder) {
        if (i == 0 && n == 0) {
            result.add(builder.toString());
            return;
        }
        // 精华的部分，判断当前
        if (i > n) {
            return;
        }
        if (i > 0) {
            builder.append('(');
            dfs(i - 1, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (n > 0) {
            builder.append(')');
            dfs(i, n - 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
