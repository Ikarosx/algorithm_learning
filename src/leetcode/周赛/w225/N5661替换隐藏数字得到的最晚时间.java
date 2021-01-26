package leetcode.周赛.w225;

/**
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 *
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 *
 * 输入：time = "1?:22"
 * 输出："19:22"
 *  
 *
 * 提示：
 *
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/24 12:15
 */
public class N5661替换隐藏数字得到的最晚时间 {

    public String maximumTime(String time) {
        StringBuilder builder = new StringBuilder(time);
        if (builder.charAt(0) == '?') {
            if (builder.charAt(1) != '?' && builder.charAt(1) >= '4') {
                builder.setCharAt(0,'1');
            } else {
                builder.setCharAt(0, '2');
            }
        }
        if (builder.charAt(1) == '?') {
            if (builder.charAt(0) == '2') {
                builder.setCharAt(1, '3');
            } else {
                builder.setCharAt(1, '9');
            }
        }
        if (builder.charAt(3) == '?') {
            builder.setCharAt(3, '5');
        }
        if (builder.charAt(4) == '?') {
            builder.setCharAt(4, '9');
        }

        return builder.toString();
    }
}
