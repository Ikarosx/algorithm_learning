package leetcode.周赛.w220;

import java.util.LinkedList;
import java.util.StringJoiner;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * 请你按下述方式重新格式化电话号码。
 *
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 返回格式化后的电话号码。
 *
 * @author Ikarosx
 * @date 2020/12/20 10:38
 */
public class N5629重新格式化电话号码 {
    public String reformatNumber(String number) {

        // 去除空格和破折号
        number = number.replaceAll("[ -]", "");
        LinkedList<String> strings = new LinkedList<>();
        while (number.length() > 4) {
            strings.add(number.substring(0, 3));
            number = number.substring(3);
        }
        if (number.length() == 4){
            strings.add(number.substring(0, 2));
            number = number.substring(2);
        }
        strings.add(number);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string).append("-");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        Assert.assertEquals("123-456", reformatNumber("1-23-45 6"));
        Assert.assertEquals("123-45-67", reformatNumber("123 4-567"));
        Assert.assertEquals("123-456-78", reformatNumber("123 4-5678"));
        Assert.assertEquals("12", reformatNumber("12"));
        Assert.assertEquals("175-229-353-94-75", reformatNumber("--17-5 229 35-39475 "));
    }
}
