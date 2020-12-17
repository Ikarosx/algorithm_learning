package interview.携程.携程20201013笔试;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作为一个新手程序员，数组越界是一个非常容易犯的错误。游游为了提醒自己，决定写一个小程序来分析自己的代码中是否存在这样的错误。但它很快发现，这项工作对于它来说太过困难了。所以它希望你来帮忙实现一个简化后的版本。
 *
 * 在这个简化后的版本中，它所需要处理的语句只有以下两种类型：
 *
 * 1. 整形数组定义语句：格式为name[size]。例如：a[5]或者array[10]。数组可用的下标为[0, size)。定义后的数组所有的元素均为0；
 *
 * 2. 赋值语句：格式为name[index]=value。例如：a[0]=1或者a[a[0]]=a[a[3]]。
 *
 * 在被分析的代码中，数组越界错误只会出现在赋值语句中，且代码中只会有这一类错误。游游希望你帮它找出代码中第一次出现错误的语句，并输出对应的行号。
 *
 *
 *
 * 输入描述
 * 第一行为一个整数n，表示总的代码行数。
 *
 * 从第二行至第n+1行每行均为代码字符串，且只会为上述两种语句之一。
 *
 * 输出描述
 * 仅输出一个整数，表示第一次出现错误的语句所对应的行号。若程序中无任何错误，则输出"0"（不包含双引号）。
 */
public class C新手游游的数组难题 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int validateArrayUsages(String[] lines) {
        // key：数组名字，value：数组长度
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (!line.contains("=")) {
                // 定义语句
                Pattern compile = Pattern.compile("(.*)\\[(\\d*)\\]");
                Matcher matcher = compile.matcher(line);
                if (matcher.find()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    map.put(key, Integer.valueOf(value));
                }
            } else {
                // 赋值语句
                Pattern compile1 = Pattern.compile("(.*)\\[(\\d*)\\]=(\\d*)");
                Pattern compile2 = Pattern.compile("(.*)\\[(\\d*)\\]=(.*)\\[(\\d*)\\]");
                Matcher matcher1 = compile1.matcher(line);
                Matcher matcher2 = compile2.matcher(line);

                if (matcher1.find()) {
                    String key = matcher1.group(1);
                    String value = matcher1.group(2);
                    if (map.get(key) == null || map.get(key) <= Integer.valueOf(value)) {
                        // 出错了
                        return i + 1;
                    }
                } else if (matcher2.find()){
                    String key1 = matcher2.group(1);
                    String value1 = matcher2.group(2);
                    String key2 = matcher2.group(3);
                    String value2 = matcher2.group(4);
                    if (map.get(key1) == null || map.get(key1) <= Integer.valueOf(value1)) {
                        // 出错了
                        return i + 1;
                    }
                    if (map.get(key2) == null || map.get(key2) <= Integer.valueOf(value2)) {
                        // 出错了
                        return i + 1;
                    }
                }
            }
        }
        return 0;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _lines_size = 0;
        _lines_size = Integer.parseInt(in.nextLine().trim());
        String[] _lines = new String[_lines_size];
        String _lines_item;
        for (int _lines_i = 0; _lines_i < _lines_size; _lines_i++) {
            try {
                _lines_item = in.nextLine();
            } catch (Exception e) {
                _lines_item = null;
            }
            _lines[_lines_i] = _lines_item;
        }

        res = validateArrayUsages(_lines);
        System.out.println(String.valueOf(res));

    }
}
