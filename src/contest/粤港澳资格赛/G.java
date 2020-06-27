package contest.粤港澳资格赛;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小明喜欢两样东西：钱和秩序。他有很多很多钱，但是没有秩序，这让他很难受。
 * 一个美丽的清晨，他再也无法忍受了，于是决定建立自己钱库的秩序，他让管家取出全部的钱；
 * 很快他的大房子里堆满了花花绿绿的钞票，看到这些乱七八糟的钞票，他心烦意乱，
 * 只想留下其中的一种，其他的统统送给管家。
 * 他决定留下数量最多的那种钞票，
 * 虽然他清楚地知道留下的钞票数量上超过总数量的一半以上，但总金额未必超过总金额的一半以上，
 * 但是他不care，有钱任性！
 * <p>
 * 输入要求
 * 第一行是小明的钞票数量N（3≤N≤500000）。在下一行中，给出了这些钞票的面值（0≤K≤104）。其中一半以上是相同的。
 * <p>
 * 输出要求
 * 一个整数，表示数量最多的钞票的面值。
 *
 * @author Ikaros
 * @date 2020/4/25 11:25
 */
public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxCount = -1;
            int maxMoney = -1;
            for (int j = 0; j < i; j++) {
                int money = scanner.nextInt();
                map.putIfAbsent(money, 0);
                int value = map.get(money) + 1;
                map.put(money, value);
                if (value > maxCount){
                    maxCount = value;
                    maxMoney = money;
                }
            }
            System.out.println(maxMoney);
            
        }
        scanner.close();
    }
}
