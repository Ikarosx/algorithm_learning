package contest.top100;

import java.util.Arrays;

/**
 * @author Ikaros
 * @date 2020/6/9 10:44
 */
public class N169MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            count += (nums[i] == candidate ? 1 : -1);
        }
        return candidate;
    }
}
