package wejudge.acm;

import java.util.Scanner;

/**
 * 小红鱼是北京师范大学珠海分校信息技术学院15级新生。在她的第一堂C语言课上，她得知今年学校开通了官方的BnuzOJ，专门为新生提供程序设计练习。开心的小红鱼正打算大显身手时，却发现。。。ShenMeGui！！！
 * 小红鱼发现，OJ是一个死板的东西，你必须按照它的要求一板一眼地写出代码，否则立刻出错。并且，错了还不告诉你错在哪，直接甩出几个字母完事。更可气的是，OJ上还有个叫ACM的怪蜀黍，出的题目又怪又难写，还半夜发鬼故事出来吓人（我们鱼类最怕水怪了▼-▼）。。。
 * <p>
 * 后来，请教了各路大仙，小红鱼终于搞清了OJ返回的奇怪字母到底是什么意思：
 * AC（Accepted）：程序通过；
 * <p>
 * PE（Presentation Error）：答案正确，但是格式不对。逻辑设计成功但输出写出了低级错误；
 * <p>
 * WA（Wrong Answer）：答案不对，仅仅通过样例数据的测试并不一定是正确答案，一定还有没想到的地方；
 * <p>
 * TLE（Time Limit Exceeded）：运行超出时间限制，需要检查下是否有死循环，或者应该有更快的计算方法；
 * <p>
 * MLE（Memory Limit Exceeded）：超出内存限制，数据可能需要压缩，数组开过大或者递归死循环（递归死循环严格上属于爆栈，属于RE）；
 * <p>
 * OLE（Output Limit Exceeded）：输出超过限制，输出比正确答案长了两倍以上；
 * <p>
 * RE（Runtime Error）：运行时错误，包括爆栈，非法的内存访问，数组越界，指针漂移，调用禁用的系统函数；
 * <p>
 * CE（Compile Error）：编译错误。。。出现于本地不测试就上OJ的作死情况。
 * <p>
 * 明确了这些信息，小红鱼终于可以开心地刷题了。。。但是她之前犯的错误实在太多了，所以她的正确率很低。
 * 现在小红鱼希望知道她OJ答题历史的正确率，你能帮她统计一下吗？
 * <p>
 * 输入要求
 * 题目包含多组数据。每组数据以一个整数n开头（0<n<500），代表小红鱼做过的题数。
 * 接下来的n行是小红鱼做过题目的OJ字母反馈。反馈的字母类型如上文描述，但仅有AC视为正确解答，其他所有反馈视为答错。
 * <p>
 * 输出要求
 * 为每组数据输出一个小数，表示本组数据的正确率，保留3位小数。
 *
 * @author Ikaros
 * @date 2020/4/8 17:18
 */
public class P1026_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ("AC".equals(scanner.next())) {
                    count++;
                }
            }
            System.out.println(String.format("%.3f", count / (n + 0.0)));
        }
        scanner.close();
    }
}
