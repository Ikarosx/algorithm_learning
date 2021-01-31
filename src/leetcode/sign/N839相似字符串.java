package leetcode.sign;

import org.junit.Test;

/**
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * <p>
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * <p>
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * <p>
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 1000
 * sum(strs[i].length) <= 2 * 104
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 *  
 * <p>
 * 备注：
 * <p>
 *       字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/similar-string-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/31 22:24
 */
public class N839相似字符串 {

    int[] fa;
    int count;

    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    public void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx != yy) {
            count--;
        }
        fa[xx] = yy;
    }

    public int numSimilarGroups(String[] strs) {
        // 并查集
        int n = strs.length;
        fa = new int[n];
        for (int i = 0; i < strs.length; i++) {
            fa[i] = i;
        }
        count = n;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (find(i) == find(j)) {
                    continue;
                }
                if (isSim(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private boolean isSim(String str, String str1) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str1.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return count <= 2;
    }

    @Test
    public void test() {
        System.out.println(numSimilarGroups(new String[]{"abc", "abc"}));
    }
}
