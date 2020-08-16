package contest.天池20200816;

import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/8/16 10:01
 */
public class D格式化字符串 {

    @Test
    public void test() {
        System.out.println(reformatString("abcdefghi", new int[]{3, 2, 2, 1, 1}));
    }

    /**
     * @param str: the original string
     * @param sublen: an integer array
     *
     * @return: the new string
     */
    public String reformatString(String str, int[] sublen) {
        //
        int subLength = sublen.length;
        String[] strings = new String[subLength];
        int count = 0;
        for (int i = 0; i < subLength; i++) {
            strings[i] = str.substring(count, count + sublen[i]);
            count += sublen[i];
            if ((i & 1) == 1) {
                String temp = strings[i - 1];
                strings[i - 1] = strings[i];
                strings[i] = temp;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
}
