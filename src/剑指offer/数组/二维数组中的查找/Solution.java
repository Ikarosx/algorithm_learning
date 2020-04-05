package 剑指offer.数组.二维数组中的查找;

import org.junit.jupiter.api.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 @Author: Ikaros @Date: 2020/1/14 16:26
 */
class Solution {
  private boolean find(int target, int[][] array) {
    if (array == null || array.length == 0 || array[0].length == 0) {
      return false;
    }
    /*
     我的思路：
     java，耗时150ms左右。。17MB。。菜
     1.判断非空
     2.递归实现：
       每次将数组分为3部分
       2.1 如果target=当前数组中间值（二维中间值），返回true
       2.2 如果target<当前数组的中间值，那么说明目标值一定在数组左上角部分，因为是有序嘛
           左上角具体指，当前数组范围的左上顶点到中间值的部分
       2.3 如果target>当前数组的中间值，那么我将除了左上角部分的其他部分分为两部分
           中间值的右边和下边
           中间值右边指的是：当前数组范围内，从第midColumn+1列开始，到最右边的横向宽度，从顶部到底部的纵向高度
           中间值下边指的是：当前数组范围内，从最左边列开始，到midColumn列的横向宽度，从midRow+1行到底部的纵向高度
       2.4 退出条件，循环到最后一定会剩下1*1的方块，判断如果为1*1，返回false（将此代码逻辑放在2.1后面，2.2前面）
     3.细节补充：
       3.1 在进行2.3操作时，可能会出现midColumn+1或者midRow+1超过了数组的范围，造成ArrayIndexOutOfBounds异常，用&&判断
    */
    /*
     别人的思路：
     矩阵是有序的，从左下角来看，向上数字递减，向右数字递增
     因此从左下角开始查找
     当要查找数字比左下角数字大时，右移
     要查找数字比左下角数字小时，上移
    */
    return findImplOtherPeople1(array, target);
//    return findImpl(target, array, 0, 0, array.length - 1, array[0].length - 1);
  }

  private boolean findImplOtherPeople1(int[][] array, int target) {
    int row = array.length - 1;
    int column = 0;
    while (true) {
      if (target == array[row][column]) {
        return true;
      }
      if (target > array[row][column] && column + 1 <= array[0].length - 1) {
        column++;
        continue;
      }
      if (target < array[row][column] && row - 1 >= 0) {
        row--;
        continue;
      }
      return false;
    }
  }

  private boolean findImpl(
      int target, int[][] array, int topRow, int leftColumn, int bottomRow, int rightColumn) {
    int midRow = (bottomRow - topRow) / 2 + topRow;
    int midColumn = (rightColumn - leftColumn) / 2 + leftColumn;
    // 中间数等于目标值
    if (array[midRow][midColumn] == target) {
      return true;
    }
    // 当前方块为1*1
    if (midRow == bottomRow && midColumn == rightColumn) {
      return false;
    }
    // 如果target小于中间值，则递归左上角部分
    if (target < array[midRow][midColumn]) {
      return findImpl(target, array, topRow, leftColumn, midRow, midColumn);
    }
    if (array[midRow][midColumn] < target) {
      return (midColumn + 1 <= rightColumn
              && findImpl(target, array, topRow, midColumn + 1, bottomRow, rightColumn))
          || (midRow + 1 <= bottomRow
              && findImpl(target, array, midRow + 1, leftColumn, bottomRow, midColumn));
    }
    return false;
  }

  @Test
  void solution() {
    System.out.println(
        find(15, new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}));
    //    while (true) {
    //      System.out.println("cpu加热用以暖手算法");
    //    }
  }
}
