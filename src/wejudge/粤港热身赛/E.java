package wejudge.粤港热身赛;

import java.util.Scanner;

/**
 * 文神迎来了他第一次出门旅游的机会，但是很不凑巧的是，
 * 他把小凑学姐和小Q学弟一起带上了，
 * 由于小凑学姐和小Q学弟都是各种宅，文神每次只好自己下楼去吃饭。
 * 但是继续很不凑巧，小凑和小Q的惰性影响到了他，
 * 他也会经常忘记去吃饭，还好酒店里有他的吃饭记录，
 * 记录文神在入住期间早餐、午餐、晚餐各吃了多少次。
 * 然而，文神不知道他什么时候开始入住酒店的
 * （可能任意一天的早上、中午或晚上，但保证到了之后马上可以吃饭），
 * 所以麻烦你们帮忙算一下文神到了酒店后最少少吃了多少餐。
 * <p>
 * 酒店里只提供了早餐、午餐和晚餐，且每天每餐最多只能吃一次。
 * <p>
 * 输入要求
 * 测试数据有多组
 * 对于每组测试数据，每排有三个数b，d，s(0 ≤ b, d, s ≤ 1018,  b + d + s ≥ 1)
 * 分别表示，早餐，午餐，晚餐的数量
 * <p>
 * 输出要求
 * 告诉文神他最少少吃了多少餐饭在这个酒店，否则的话怎么找小凑和小Q算账
 *
 * @author Ikaros
 * @date 2020/4/18 21:33
 */
public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 早餐，午餐，晚餐的数量
            Long b = scanner.nextLong();
            Long d = scanner.nextLong();
            Long s = scanner.nextLong();
            // 求最少少吃了多少餐
            Long result = 0L;
            if (b.equals(d) && d.equals(s)) {
                result = 0L;
            } else if (b.equals(d) && b != 0) {
                result += b - s - 1;
            } else if (b.equals(s) && b != 0) {
                result += b - d - 1;
            } else if (d.equals(s) && d != 0) {
                result += b - d - 1;
            } else if (b >= d && b >= s) {
                // 早餐最多
                result += b - d - 1;
                result += b - s - 1;
            } else if (d >= b && d >= s) {
                result += d - b - 1;
                result += d - s - 1;
            } else {
                result += s - b - 1;
                result += s - d - 1;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
