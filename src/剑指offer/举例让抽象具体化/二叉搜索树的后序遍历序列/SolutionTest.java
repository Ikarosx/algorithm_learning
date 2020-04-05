package 剑指offer.举例让抽象具体化.二叉搜索树的后序遍历序列;

import org.junit.jupiter.api.Test;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author Ikaros
 * @date 2020/03/12 23:57
 */
class SolutionTest {
  public boolean VerifySquenceOfBST(int[] sequence) {
    if (sequence == null || sequence.length == 0) {
      return false;
    }
    /*
     * 划重点，二叉搜索树
     * 所有左结点比父节点小，所有右节点比父节点大
     * 每个数组三部分，左半部分，中间部分，和最右边的数
     * 左半部分小于最右边的数，中间部分大于最右边的树
     */
    return verifySquenceOfBST(
        sequence, 0, sequence.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  private boolean verifySquenceOfBST(
      int[] sequence, int leftIndex, int rightIndex, int maxValue, int minValue) {
    if (leftIndex >= rightIndex) {
      if (sequence[rightIndex] < maxValue && sequence[rightIndex] > minValue) {
        return true;
      }
      return false;
    }
    int midIndex = leftIndex;
    for (int i = rightIndex - 1; i >= leftIndex; i--) {
      if (sequence[i] < sequence[rightIndex]) {
        midIndex = i;
        break;
      }
    }

    // 右子树
    return verifySquenceOfBST(
            sequence,
            midIndex + 1,
            rightIndex - 1,
            maxValue,
            sequence[rightIndex] < minValue ? sequence[rightIndex] : minValue)
        // 左子树
        && (midIndex == leftIndex
            || verifySquenceOfBST(sequence, leftIndex, midIndex, sequence[rightIndex], minValue));
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[][] arrays = {{1, 2}, {3, 4}};
    int[] array1 = {3, 2, 1};
    int[] array2 = {4, 5, 3, 1, 2};
    System.out.println(VerifySquenceOfBST(array1));
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
