package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import 剑指offer.TreeNode;

/**
 * @author Ikarosx
 * @date 2020/7/31 20:22
 */
public class Demo {

    int result = 0;
    boolean flag = false;

    @Test
    public void test1() throws Exception {
        int k = 5;
        int[] array = {-1, 1, -2, 2, -3, 3, -4, 4};
        System.out.println(canArrange(array, k));
    }

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put((i % k + k) % k, map.getOrDefault((i % k + k) % k, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (i == 0) {
                continue;
            }
            int value = map.get(i);
            if (map.getOrDefault(k - i, 0) != value) {
                return false;
            }
        }
        return map.getOrDefault(0, 0) % 2 == 0;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte aByte : bytes) {
            String s = Integer.toHexString(aByte & 0xFF);
            if (s.length() < 2) {
                builder.append(0);
            }
            builder.append(s);
        }
        return builder.toString();
    }

    private void findKMin(TreeNode node, int k) {
        // 中序
        // 找到第K小
        findKMinImpl(node, 0, k);

    }

    // 返回排在前面有多少个数
    private int findKMinImpl(TreeNode node, int current, int k) {
        if (node == null || flag) {
            return 0;
        }
        // 左子树有left个值
        int left = findKMinImpl(node.left, 0, k);
        if (left + 1 + current == k) {
            // 当前值就是要找的
            result = node.val;
            // 提前终止
            flag = true;
            return 0;
        }
        // 右边寻找，对于右边的树来说前面已经有left + 1个值
        findKMinImpl(node.right, left + 1, k);
        return 0;
    }

    @Test
    public void test() {

        int[] arrays = {3, 4, 1, 9, 6};
        quickSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }

    public void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        partition3(array, l, r);
    }

    private int partition(int[] array, int l, int r) {
        // 优化近乎有序
        swap(array, l, (int) (Math.random() * (r - l + 1) + l));
        // array[l + 1, ll] <= first
        int ll = l;
        int first = array[l];
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < first) {
                swap(array, i, ++ll);
            }
        }
        swap(array, l, ll);
        return ll;
    }

    private int partition2(int[] array, int l, int r) {
        // 优化近乎有序
        swap(array, l, (int) (Math.random() * (r - l + 1) + l));
        int first = array[l];
        // array[l + 1, ll) <= first
        int ll = l + 1;
        // array[ll, r] >= first
        int rr = r;
        while (true) {
            while (ll <= r && array[ll] < first) {
                ll++;
            }
            while (rr >= 0 && array[rr] > first) {
                rr--;
            }
            if (ll >= rr) {
                break;
            }
            swap(array, ll++, rr--);
        }
        swap(array, l, rr);
        return rr;
    }

    private void partition3(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        // 优化近乎有序
        swap(array, l, (int) (Math.random() * (r - l + 1) + l));
        int first = array[l];
        // array[l + 1, ll] < first
        // array[ll + 1, mid) = first
        int ll = l;
        // array[rr, r] > first
        int mid = l + 1;
        int rr = r + 1;
        while (mid < rr) {
            if (array[mid] == first) {
                mid++;
            } else if (array[mid] < first) {
                swap(array, ++ll, mid++);
            } else {
                swap(array, --rr, mid);
            }
        }
        swap(array, l, ll);
        partition3(array, l, ll - 1);
        partition3(array, rr, r);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
