package interview.腾讯2017校招开发工程师笔试试卷二;

import java.util.Scanner;

/**
 * 题目描述
 * 假定一种编码的编码范围是a-y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下：
 * a,aa,aaa,aaaa,aaab,aaac,.....,....,b,ba,baa,baaa,baab,baac,...
 * ...,yyyw,yyyx,yyyy
 * 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。
 * 编写一个函数，输入是任意一个编码，输出这个编码对应的index，如：
 * <p>
 * 输入：baca
 * 输出：16328
 *
 * @author Ikaros
 * @date 2020/4/23 14:04
 */
public class N31 {
    
    public static void main(String[] args) {
        int index = 0;
        String string = "baca";
        for (int i = 0; i < string.length(); i++, index++) {
            int n = string.charAt(i) - 'a';
            for (int j = 0; j < 4 - i; j++) {
                index += n * Math.pow(25, j);
            }
        }
        System.out.println(index);
        // Scanner scanner = new Scanner(System.in);
        // while (true) {
        //     System.out.println(n31(scanner.next()));
        // }
        
    }
    
}
