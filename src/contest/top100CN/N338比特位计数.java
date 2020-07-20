package contest.top100CN;

/**
 * @author Ikarosx
 * @date 2020/7/19 14:56
 */
public class N338比特位计数 {
    public class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            int i = 0, b = 1;
            // [0, b) is calculated
            while (b <= num) {
                // generate [b, 2b) or [b, num) from [0, b)
                while (i < b && i + b <= num) {
                    ans[i + b] = ans[i] + 1;
                    ++i;
                }
                i = 0;   // reset i
                b <<= 1; // b = 2b
            }
            return ans;
        }
    }
    
  /*  public int[] countBits(int num) {
        int[] ints = new int[num];
        for (int i = 0; i <= num; i++) {
            ints[i] = popCount(i);
        }
        return ints;
    }*/
    
    private int popCount(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i &= i - 1;
        }
        return count;
    }
}
