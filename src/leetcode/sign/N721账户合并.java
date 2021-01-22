package leetcode.sign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *  
 *
 * 提示：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * 通过次数12,021提交次数28,617
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/18 13:49
 */
public class N721账户合并 {

    int[] fa;

    @Test
    public void test() {
        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        lists.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        lists.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        lists.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        lists.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        System.out.println(accountsMerge(lists));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        fa = new int[accounts.size()];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < accounts.size(); j++) {
            List<String> account = accounts.get(j);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (map.get(email) == null) {
                    map.put(email, j);
                } else {
                    union(j, map.get(email));
                }
            }
        }
        Map<Integer, List<String>> resultMap = new HashMap<>();
        for (int i = 0; i < fa.length; i++) {
            int finalI = i;
            resultMap.putIfAbsent(find(fa[i]), new ArrayList<String>() {{
                add(accounts.get(find(fa[finalI])).get(0));
            }});
            List<String> strings1 = accounts.get(i);
            for (int j = 1; j < strings1.size(); j++) {
                List<String> strings = resultMap.get(find(fa[i]));
                if (!strings.contains(strings1.get(j))) {
                    strings.add(strings1.get(j));
                }
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>(resultMap.values());
        for (List<String> list : lists) {
            String name = list.get(0);
            list.remove(0);
            Collections.sort(list);
            list.add(0, name);
        }

        return lists;
    }

    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    public void union(int x, int y) {
        fa[find(x)] = find(y);
    }
}
