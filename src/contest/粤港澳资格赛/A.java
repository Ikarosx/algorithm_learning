package collection.粤港澳资格赛;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Alice有一些重要信息，这信息只包括大写字母、小写字母和空格。她想要对这些信息进行记录，但是又不想直接记录原始信息。
 * <p>
 * 她开始查找资料，其中一种方法是将字母进行变换，设定一个变换位置k，则c=k+m，其中m为原始字符，c为变换结果。
 * 比如k=2，则A变为C，Y变为A，z变为b。空格转换为’#’。
 * <p>
 * Alice对k值的设置方法进行了一些改进，由原来固定的k值改进为使用记录的日期变换出k值。
 * 具体方法是对日期构成的每一位求和，直到k小于10。比如20020308，
 * 对日期构成的每一位求和得到k=2+2+3+8=15，继续求和k=1+5=6，则最终得到k=6。
 * 请你帮Alice编写一个程序，利用记录日期将信息转换为加密编码格式。
 *
 * <p>
 * 这个算法要求日期的格式为：yyyymmdd，年份范围应为[1900-2020]，月份范围应为[1-12]，日根据年和月确定；信息只能是大写字母、小写字母和空格。
 * <p>
 * 输入要求
 * 多组输入。
 * <p>
 * 每组数据包括2行。第1行是一个日期，长度不大于8；第2行是要加密的信息，长度不大于128。
 * <p>
 * 输出要求
 * 每组数据输出如下：
 * <p>
 * 如果输入的日期或信息不符合要求，输出 none
 * <p>
 * 否则，输出加密后的信息。
 *
 * @author Ikaros
 * @date 2020/4/25 8:43
 */
public class A {
    @Test
    public void test() {
        DateTimeFormatter yyyymmdd = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parse;
        String s = "2020106";
        if (s.length() == 7) {
            String year = s.substring(0, 5);
        }
        try {
            parse = LocalDate.parse(s, yyyymmdd);
        } catch (Exception e) {
            System.out.println("mmdd fail");
            yyyymmdd = DateTimeFormatter.ofPattern("yyyyMdd");
            try {
                parse = LocalDate.parse("2020106", yyyymmdd);
            } catch (Exception e1) {
                System.out.println("none");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String time = scanner.nextLine();
            String message = scanner.nextLine();
            if (time.length() < 7) {
                System.out.println("none");
                continue;
            }
            String year = time.substring(0, 4);
            String day = time.substring(time.length() - 2);
            String month = time.substring(4, time.length() - 2);
            if (month.length() == 1) {
                month = "0" + month;
            }
            LocalDate parse;
            try {
                parse = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
            } catch (Exception e) {
                System.out.println("none");
                continue;
            }
            LocalDate begin = LocalDate.of(1900, 1, 1);
            LocalDate end = LocalDate.of(2020, 12, 31);
            if (parse.isBefore(begin) || parse.isAfter(end)) {
                System.out.println("none");
                continue;
            }
            Pattern compile = Pattern.compile("^[a-zA-Z ]*$");
            Matcher matcher = compile.matcher(message);
            if (!matcher.find()) {
                System.out.println("none");
                continue;
            }
            int k;
            while (true) {
                int temp = 0;
                for (int i = 0; i < time.length(); i++) {
                    int tempNum = time.charAt(i) - '0';
                    temp += tempNum;
                }
                if (temp < 10) {
                    k = temp;
                    break;
                }
                time = String.valueOf(temp);
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if (c == ' ') {
                    result.append('#');
                } else if (c >= 'a' && c <= 'z') {
                    char i1;
                    if (c + k > 'z') {
                        i1 = (char) ((c + k) - 'z' + 'a' - 1);
                    } else {
                        i1 = (char) (c + k);
                    }
                    result.append(i1);
                } else {
                    char i1;
                    if (c + k > 'Z') {
                        i1 = (char) ((c + k) - 'Z' + 'A' - 1);
                    } else {
                        i1 = (char) (c + k);
                    }
                    result.append(i1);
                }
            }
            System.out.println(result.toString());
        } scanner.close();
    }
}
