package leetcode.序号.n600;

import org.junit.Test;

import java.util.*;

/**
 * 给一非空的单词列表，返回前&nbsp;<em>k&nbsp;</em>个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * 注意：
 *
 * <ol>
 * 假定 <em>k</em> 总为有效值， 1 ≤ <em>k</em> ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * </ol>
 * <p>
 * 扩展练习：
 *
 * <ol>
 * 尝试以&nbsp;<em>O</em>(<em>n</em> log <em>k</em>) 时间复杂度和&nbsp;<em>O</em>(<em>n</em>) 空间复杂度解决。
 * </ol>
 * <p>
 * 相关标签：
 * 堆
 * 字典树
 * 哈希表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/top-k-frequent-words/
 *
 * @author Ikarosx
 * @date 2021/5/20
 */
public class N692前K个高频单词 {

    public List<String> topKFrequent(String[] words, int k) {
        // map + 堆
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}