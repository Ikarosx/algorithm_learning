package leetcode.sign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/23 19:07
 */
public class N387字符串中的第一个唯一字符 {

    @Test
    public void test() {
        Assert.assertEquals(0, firstUniqChar("leetcode"));
        Assert.assertEquals(2, firstUniqChar("loveleetcode"));

    }

    public int firstUniqChar(String s) {
        char[] chars = new char[256];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < length; i++) {
            if (chars[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
