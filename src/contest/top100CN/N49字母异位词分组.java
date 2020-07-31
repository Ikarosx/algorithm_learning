package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author Ikarosx
 * @date 2020/7/29 7:52
 */
public class N49字母异位词分组 {
    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            map.putIfAbsent(sortStr, new LinkedList<>());
            List<String> list = map.get(sortStr);
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
