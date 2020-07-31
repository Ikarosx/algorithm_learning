package contest.top100CN;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * TODO
 *
 * @author Ikarosx
 * @date 2020/7/31 7:23
 */
public class N406根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        /*
         * 将最高的人按照 k 值升序排序，然后将它们放置到输出队列中与 k 值相等的索引位置上。
         * 按降序取下一个高度，同样按 k 值对该身高的人升序排序，然后逐个插入到输出队列中与 k 值相等的索引位置上。
         * 直到完成为止。
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         */
        Arrays.sort(people, (o1, o2) -> {
            // if the heights are equal, compare k-values
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        
        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }
        
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
    
}
