package contest.top100CN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 *
 * @author Ikarosx
 * @date 2020/8/3 7:35
 */
public class N301删除无效的括号 {

    Set<String> set = new HashSet<>();
    // 删除的个数
    int min;

    long before;

    @BeforeEach
    public void before() {
        before = System.currentTimeMillis();
    }

    @AfterEach
    public void after() {
        System.out.println("花费了" + (System.currentTimeMillis() - before) + "ms");
    }

    @Test
    public void test() {
        //        System.out.println(valid("())((d)))()(()))(())"));
        System.out.println(removeInvalidParentheses(")("));
    }


    public List<String> removeInvalidParentheses(String s) {
        min = s.length() + 1;
        StringBuilder builder = new StringBuilder();
        dfs(s, builder, 0, 0, 0, 0);
        return new ArrayList<>(set);
    }

    private void dfs(String s, StringBuilder builder, int i, int deleteCount, int ll, int rr) {
        if (rr > ll) {
            // 右括号的数量大于左括号
            return;
        }
        if (deleteCount > min) {
            return;
        }
        if (i == s.length()) {
            if (ll != rr) {
                return;
            }
            String result = builder.toString();
            if (deleteCount < min) {
                min = deleteCount;
                set.clear();
            }
            set.add(result);
            return;
        }
        char c = s.charAt(i);
        builder.append(c);
        dfs(s, builder, i + 1, deleteCount, ll + (c == '(' ? 1 : 0), rr + (c == ')' ? 1 : 0));
        builder.deleteCharAt(builder.length() - 1);
        dfs(s, builder, i + 1, deleteCount + 1, ll, rr);
    }


}
