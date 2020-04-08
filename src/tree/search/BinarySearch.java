package tree.search;

import org.junit.jupiter.api.Test;

/**
 * @author Ikaros
 * @date 2020/4/6 12:37
 */
public class BinarySearch {
    /**
     * 在有序数组array中找到值target
     * 如果找到target，返回相应的索引index
     * 如果没有找到，返回-1
     *
     * @param array
     * @param n
     * @param target
     *
     * @return
     */
    int binarySearch(int[] array, int n, int target) {
        // 在[l, r]中查找target
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                // 在array[l, mid - 1]中继续寻找target
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    
    /**
     * floor，当存在重复target，返回第一个索引
     * 当不存在target，返回最接近target的上一个
     */
    int floor(int[] array, int n, int target) {
        // 在[l, r]中查找target
        int l = 0, r = n - 1;
        int mid = (r - l) / 2 + l;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (array[mid] == target) {
                // 往前找
                while (mid - 1 >= l && array[mid - 1] == target) {
                    mid--;
                }
                return mid;
            } else if (array[mid] > target) {
                // 在array[l, mid - 1]中继续寻找target
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r < 0) {
            return array[0];
        }
        if (l == n) {
            return array[n - 1];
        }
        if (r == mid - 1) {
            // 说明array[mid】 > array[target]
            // 即最后一次比较中，中间值大于目标值
            // 此时array[r]即为前一个值
            return array[r];
            
        } else {
            return array[l];
        }
    }
    
    @Test
    public void binarySearchTest() {
        int[] array = {1, 6, 9, 15, 20, 30, 255, 669, 2000};
        System.out.println(floor(array, array.length, -1));
    }
}
