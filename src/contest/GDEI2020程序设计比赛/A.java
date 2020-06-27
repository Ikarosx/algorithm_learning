package contest.GDEI2020程序设计比赛;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 现在有一个仅由小写字母组成的字符串S，假定将字母a,b,c...z依次编号为1,2,3...26，现在要在S中找到所有长度为m的且字母编号和为q的子串。
 *
 * @author Ikaros
 * @date 2020/6/15 19:54
 */
public class A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int N = scanner.nextInt();
      for (int i = 0; i < N; i++) {
        String str = scanner.next();
        // 长度为m
        int m = scanner.nextInt();
        int temp = 0;
        // 编号和为q
        int q = scanner.nextInt();
        // 从[l,r]为符合的长度
        int l = 0;
        int r = m - 1;
        if (m > str.length()) {
          System.out.println(0);
          continue;
        }
        for (int j = 0; j < m; j++) {
          temp += str.charAt(j) - 'a' + 1;
        }
        List<String> resultList = new LinkedList<>();
        while (r < str.length()) {
          if (temp == q) {
            resultList.add(str.substring(l, r + 1));
          }
          temp -= str.charAt(l++) - 'a' + 1;
          if (++r >= str.length()) {
            break;
          }
          temp += str.charAt(r) - 'a' + 1;
        }
        System.out.println(resultList.size());
        for (String s : resultList) {
          System.out.println(s);
        }
      }
    }

    scanner.close();
  }
}
