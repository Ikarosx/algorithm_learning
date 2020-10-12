package interview.五八同城;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/10/11 19:45
 */
public class A排队 {

    @Test
    public void test() {
        Assert.assertEquals(2, lineup("GGBBG"));
        System.out.println();
    }

    /**
     * @param peoples string字符串
     *
     * @return int整型
     */
    public int lineup(String peoples) {
        StringBuilder builder = new StringBuilder(peoples);
        return Math.min(impl(peoples), impl(builder.reverse().toString()));
    }

    private int impl(String peoples) {
        char[] chars = peoples.toCharArray();
        int l = 0;
        int r = peoples.length() - 1;
        int count = 0;
        while (l < r) {
            while (l < r && chars[l] == 'G') {
                l++;
            }
            while (l < r && chars[r] == 'B') {
                r--;
            }
            // GGBBG
            count += r - l;
            l++;
            r--;
        }
        return count;
    }
}
