package leetcode.sign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;

/**
 * 公司共有 n 个项目和  m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。
 *
 * group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）小组可能存在没有接手任何项目的情况。
 *
 * 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：
 *
 * 同一小组的项目，排序后在列表中彼此相邻。
 * 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。
 * 如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
 * 输出：[6,3,4,1,5,2,0,7]
 * 示例 2：
 *
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
 * 输出：[]
 * 解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/12 9:18
 */
public class N1203项目管理 {

    @Test
    public void test() {
        int[] ints = sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1},
            new ArrayList<List<Integer>>() {{
                add(new ArrayList<>());
                add(Arrays.asList(6));
                add(Arrays.asList(5));
                add(Arrays.asList(6));
                add(Arrays.asList(3));
                add(Arrays.asList());
                add(Arrays.asList(4));
                add(Arrays.asList());
            }});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // key小组对应的项目value
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> visit = new HashMap<>();
        Map<Integer, boolean[]> memberVisit = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            map.putIfAbsent(group[i], new ArrayList<>());
            map.get(group[i]).add(i);
            visit.put(group[i], false);
        }
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            memberVisit.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        int[] ints = new int[n];
        Arrays.fill(ints, -1);
        Set<Integer> set = new HashSet<>();

        if (!dfs(n, m, ints, 0, beforeItems, set, map, visit, memberVisit, -1)) {
            return new int[]{};
        }
        return ints;
    }

    private boolean dfs(int n, int m, int[] ints, int index, List<List<Integer>> beforeItems,
        Set<Integer> set, Map<Integer, List<Integer>> map, Map<Integer, Boolean> visit,
        Map<Integer, boolean[]> memberVisit, Integer curGroup) {
        System.out.println(index);
        System.out.println(Arrays.toString(ints));
        if (index == n) {
            return true;
        }
        // 需要包含前置
        if (!set.containsAll(beforeItems.get(index))) {
            System.out.println("不包含" + beforeItems.get(index));
            // 如果没有，需要补充上不受任何小组管理的
            /*List<Integer> value = map.get(-1);
            for (int i = 0; i < value.size(); i++) {
                Integer remove = value.remove(i);
                set.add(remove);
                ints[index] = remove;
                if (dfs(n, m, ints, index + 1, beforeItems, set, map, visit)) {
                    return true;
                }
                set.remove(remove);
                value.add(i, remove);
            }*/
            return false;
        }

        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            // 没访问过该小组
            Integer key = entry.getKey();
            if (!visit.get(key) || key.equals(curGroup)) {
                visit.put(key, true);
                List<Integer> value = entry.getValue();
                for (int i = 0; i < value.size(); i++) {
                    if (memberVisit.get(key)[i]) {
                        continue;
                    }
                    memberVisit.get(key)[i] = true;
                    Integer remove = value.get(i);
                    set.add(remove);
                    ints[index] = remove;
                    if (dfs(n, m, ints, index + 1, beforeItems, set, map, visit, memberVisit,
                        key)) {
                        return true;
                    }
                    set.remove(remove);
                    memberVisit.get(key)[i] = false;
                }
                visit.put(key, false);
            }

        }
        return false;

    }
}