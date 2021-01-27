package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 * <p>
 * 示例 4：
 * <p>
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 * <p>
 * 示例 5：
 * <p>
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/25 9:01
 */
public class N959由斜杠划分区域 {
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

    @Test
    public void test() {
        Assert.assertEquals(2, regionsBySlashes(new String[]{" /", "/ "}));
        Assert.assertEquals(1, regionsBySlashes(new String[]{" /", "  "}));
    }

    public int regionsBySlashes(String[] grid) {
        int row = grid.length;
        int column = grid[0].length();
        fa = new int[row * column * 4];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        count = fa.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char c = grid[i].charAt(j);
                int start = (i * column + j) * 4;
                if (c == '/') {
                    union(find(start), find(start + 1));
                    union(find(start + 2), find(start + 3));
                } else if (c == '\\') {
                    union(find(start), find(start + 3));
                    union(find(start + 2), find(start + 1));

                } else {
                    union(find(start), find(start + 1));
                    union(find(start), find(start + 2));
                    union(find(start), find(start + 3));
                }
                if (j != column - 1) {
                    // 向右合并
                    union(find(start + 3), find(start + 5));
                }
                if (i != row - 1) {
                    // 向下合并
                    union(find(start + 2), find(((i + 1) * column + j) * 4));
                }
            }
        }
        return count;
    }
}
