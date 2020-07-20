package other;

/**
 * @author Ikarosx
 * @date 2020/7/19 17:27
 */
public class CardMagic {
    public static void main(String[] args) throws InterruptedException {
        int[] ints = new int[52];
        // 初始化序列
        for (int i = 1; i <= 13; i++) {
            ints[4 * (i - 1) + 0] = i;
            ints[4 * (i - 1) + 1] = i;
            ints[4 * (i - 1) + 2] = i;
            ints[4 * (i - 1) + 3] = i;
        }
        // 循环判断
        while (!validArray(makeArrayRandom(ints, 50))) {
            // 分隔符
            System.out.println("------------------------------------------");
        }
    }
    
    /**
     * 使数组ints随机交换time次
     *
     * @param ints
     *         要交换的数组
     * @param time
     *         要交换的次数
     *
     * @return 返回交换后的数组（其实返回是多余的但为了方便）
     */
    public static int[] makeArrayRandom(int[] ints, int time) {
        // 随机交换time次
        for (int i = 0; i < time; i++) {
            // 选取两个随机下标a和b
            int a = (int) (Math.random() * ints.length);
            int b = (int) (Math.random() * ints.length);
            // 交换下标为ab的值
            int temp = ints[a];
            ints[a] = ints[b];
            ints[b] = temp;
        }
        System.out.println("生成的卡牌");
        // 输出生成的卡牌，并将11,12,13替换为JQK
        for (int anInt : ints) {
            String temp = String.valueOf(anInt);
            if (anInt > 10) {
                temp = anInt == 11 ? "J" : anInt == 12 ? "Q" : "K";
            }
            System.out.print(temp + ",");
        }
        System.out.println();
        return ints;
    }
    
    /**
     * 判断数组是否符合卡牌魔术
     *
     * @param ints
     *         要验证的数组
     *
     * @return 符合返回true，不符合返回false
     *
     * @throws InterruptedException
     */
    public static boolean validArray(int[] ints) throws InterruptedException {
        // 选取随机想的数字
        int num = (int) (Math.random() * 10) + 1;
        System.out.println("心里想的位数是：" + num);
        StringBuilder builder = new StringBuilder();
        // 保存最后一个判断手牌的下标，用来判断是否符合
        int last = 0;
        // 循环的主要逻辑
        for (int i = 0; i < ints.length; i++) {
            // 每次循环让心里想的数字减一
            if (--num == 0) {
                // 如果减一之后为0，说明这个数字为主牌
                // 将当前主牌表示的数字赋值给num
                num = ints[i];
                // 如果num是11,12,13，赋值为5
                if (num > 10) {
                    num = 5;
                }
                builder.append(ints[i] + ",");
                last = i;
            }
        }
        
        System.out.println("主牌：" + builder.toString().replace("11", "J").replace("12", "Q").replace("13", "K"));
        // 判断最后一张手牌的值是否为12
        return ints[last] == 12;
    }
}
