package interview.vivo.校招2020B;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 小v在公司负责游戏运营，今天收到一款申请新上架的游戏“跳一跳”，为了确保提供给广大玩家朋友们的游戏都是高品质的，按照运营流程小v必须对新游戏进行全方位了解体验和评估。这款游戏的规则如下：
 * 有n个盒子排成了一行，每个盒子上面有一个数字a[i]，表示在该盒子上的人最多能向右移动a[i]个盒子（比如当前所在盒子上的数字是3，则表示可以一次向右前进1个盒子，2个盒子或者3个盒子）。
 * 现在小v从左边第一个盒子上开始体验游戏，请问最少需要移动几次能到最后一个盒子上？
 *
 * @author Ikaros
 * @date 2020/6/4 14:10
 */
public class C {
    @Test
    public void test() {
        System.out.println(solution(new int[]{0, 1, 0, 1, 4}));
    }
    
    private static int solution(int[] input) {
        int[] result = new int[input.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            List<Integer> orDefault = map.get(i);
            int min = Integer.MAX_VALUE;
            if (orDefault != null) {
                for (Integer integer : orDefault) {
                    min = integer < min ? integer : min;
                }
            }
            if (i != 0) {
                result[i] = min + 1;
            }
            if (i != input.length - 1 && (result[i] != Integer.MAX_VALUE + 1 || i == 0)) {
                for (int j = 1; j <= input[i]; j++) {
                    List<Integer> integers = map.get(i + j);
                    if (integers == null) {
                        integers = new LinkedList<>();
                        map.put(i + j, integers);
                    }
                    integers.add(result[i]);
                }
            }
        }
        return result[input.length - 1] == Integer.MAX_VALUE + 1 ? -1 : result[input.length - 1];
    }
}
