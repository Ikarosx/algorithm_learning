package contest.top100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * @author Ikaros
 * @date 2020/6/1 10:27
 */
public class N139WordBreak {
    @Test
    public void test() {
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // map表示：存在以下标k开始并以v结尾的对应字符串
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (String string : wordDict) {
            String temp = s;
            int i;
            int count = 0;
            while ((i = temp.indexOf(string)) != -1) {
                List<Integer> orDefault = map.getOrDefault(i + count, new LinkedList<>());
                orDefault.add(i + count + string.length());
                map.put(i + count, orDefault);
                count += string.length();
                temp = temp.replaceFirst(string, "");
            }
        }
        // 此时map存放完成，从0开始遍历
        int l = 0;
        return getResultByMap(map, l, s.length());
    }
    
    private boolean getResultByMap(HashMap<Integer, List<Integer>> map, int l, int r) {
        if (l == r) {
            return true;
        }
        for (Integer integer : map.getOrDefault(l, new LinkedList<>())) {
            if (getResultByMap(map, integer, r)) {
                return true;
            }
        }
        return false;
    }
}
