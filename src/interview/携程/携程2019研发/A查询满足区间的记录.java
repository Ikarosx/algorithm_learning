package interview.携程.携程2019研发;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 有一批订单记录，数据有订单号，入店时间，离店时间；
 * 输入一个时间值A，需要在这批记录中找到符合入离店时间范围（A大于等于入店时间，并且A小于等于离店时间）内的所有记录。 单次查询时间复杂度控制在O(logN)
 * ※注意：订单号升序输出
 *
 * 输入描述:
 * 记录数：10
 * 时间值A：20180602
 * 订单号 入店时间 离店时间
 * 1001 20180103 20180105
 * 1002 20180202 20180203
 * 1003 20180304 20180306
 * 1004 20180401 20180408
 * 1005 20180501 20180504
 * 1006 20180601 20180604
 * 1007 20180705 20180706
 * 1008 20180801 20180804
 * 1009 20180903 20180903
 * 1010 20181003 20181003
 * 以上输入都为整型
 *
 * 输出描述:
 * 1006
 *
 * 输入例子1:
 * 10
 * 20180602
 * 1001 20180103 20180105
 * 1002 20180202 20180203
 * 1003 20180304 20180306
 * 1004 20180401 20180408
 * 1005 20180501 20180504
 * 1006 20180601 20180604
 * 1007 20180705 20180706
 * 1008 20180801 20180804
 * 1009 20180903 20180903
 * 1010 20181003 20181003
 *
 * 输出例子1:
 * 1006
 *
 * 输入例子2:
 * 5
 * 20170103
 * 1013 20180103 20180105
 * 1022 20180102 20180103
 * 1103 20180104 20180106
 * 1034 20180101 20180102
 * 1105 20180201 20180204
 *
 * 输出例子2:
 * null
 *
 * 例子说明2:
 * 查不到时输出null字符串（小写）
 *
 * 输入例子3:
 * 4
 * 20180103
 * 1013 20180103 20180105
 * 1022 20180102 20180103
 * 1026 20180103 20180103
 * 1007 20180101 20180109
 *
 * 输出例子3:
 * 1007
 * 1013
 * 1022
 * 1026
 *
 * @author Ikarosx
 * @date 2020/10/13 9:23
 */
public class A查询满足区间的记录 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeSet<String> result = new TreeSet<>();
            int N = scanner.nextInt();
            String time = scanner.next();
            for (int i = 0; i < N; i++) {
                Record record = new Record(scanner.next(), scanner.next(), scanner.next());
                if (record.includeTime(time)) {
                    result.add(record.orderNo);
                }
            }

            for (String s : result) {
                System.out.println(s);
            }
            if (result.size() == 0) {
                System.out.println("null");
            }
        }
        scanner.close();
    }

    static class Record {

        String orderNo;
        String startTime;
        String endTime;

        Record(String orderNo, String startTime, String endTime) {
            this.orderNo = orderNo;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        boolean includeTime(String time) {
            return time.compareTo(startTime) >= 0 && time.compareTo(endTime) <= 0;
        }
    }
}
