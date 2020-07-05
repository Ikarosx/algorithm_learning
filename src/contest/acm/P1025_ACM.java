package contest.acm;

import java.util.Scanner;

/**
 * 在美丽的北京师范大学珠海分校，一直流传着一个神秘的故事。
 * 相传，在第一代开拓者建校之时，原先打算建立四座学生宿舍给新生居住。
 * 它们分别是：海华苑1栋、海华苑2栋、海华苑3栋、海华苑4栋。
 * 在那个即将开学的夏天，海华1、2、3栋顺利完工，而海华苑4栋，却发生了许多诡异的事情。。。
 * 种种事件发生后，校方无奈，最终将海华苑4栋改建为学三食堂。
 * 但谁都没有注意到，与之一路相隔的丽泽湖，也发生了一些奇怪的变化。。。
 * <p>
 * 湖内出现了一些奇怪的生物。
 * 它们身材娇小，速度敏捷。
 * 平日他们隐藏于水中，隐于人世。
 * 而在每个春夏之交的雨夜，它们就会爬上尘世，用它们凄凉的语言，向所有北师人，诉说那段悲惨的往事。。。
 * <p>
 * 而近些年，这种生物（我们叫它们“丽泽湖水怪”）的数量似乎出现了疯狂的增长。渐渐的，人们开始担心它们将占领校园，最终将北师毁于一旦。
 * 出于正义的反抗，学校在丽泽湖畔成立“未来地球研究院”，防止“丽泽湖水怪”占领学校乃至整个地球。
 * <p>
 * “未来地球研究院”发现，“丽泽湖水怪”的繁殖非常迅速。每只水怪每年年初生一只小水怪，而每只小水怪从第四个年头开始，每年年初也生一只小水怪。
 * 现在，研究员想知道，一只“丽泽湖水怪”正常繁殖，第n年时会有多少丽泽湖水怪？（丽泽湖水怪的寿命非常长。。。事实上由于未观测到正常死亡的个体我们还不知道它们的寿命到底有多长）
 * <p>
 * 输入要求
 * 输入数据由多个测试实例组成，每个测试实例占一行，包括一个整数n(0<n<55)，n的含义如题目中描述。
 * n=0表示输入数据的结束，不做处理。
 * <p>
 * 输出要求
 * 对于每个测试实例，输出在第n年的时候“丽泽湖水怪”的数量。
 * 每个输出占一行。
 *
 * @author Ikaros
 * @date 2020/4/8 17:03
 */
public class P1025_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[55];
        // 第一年是初始水怪
        ints[1] = 1;
        // 第二年初始水怪生了一只，初始水怪加初始小水怪2只
        ints[2] = 2;
        // ...
        ints[3] = 3;
        ints[4] = 4;
        // 第五年，老水怪生一只，第二年生的小水怪4岁了，它也开始生了
        ints[5] = 6;
        // 即ints[n]（n >= 5） = ints[n - 1] + ints[n - 3]
        for (int i = 6; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 3];
        }
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            // ints[n]表示第n年水怪数量
            System.out.println(ints[n]);
        }
        scanner.close();
    }
}