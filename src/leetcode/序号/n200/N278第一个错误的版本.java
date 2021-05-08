package leetcode.序号.n200;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用&nbsp;bool isBadVersion(version)&nbsp;接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 示例:
 * <p>
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * <p>
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5)&nbsp;-> true
 * 调用 isBadVersion(4)&nbsp;-> true
 * <p>
 * 所以，4 是第一个错误的版本。&nbsp;
 * <p>
 * 相关标签：
 * 二分查找
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/first-bad-version/
 *
 * @author Ikarosx
 * @date 2021/5/8
 */
public class N278第一个错误的版本 {
    /* The isBadVersion API is defined in the parent class VersionControl.      boolean isBadVersion(int version); */
    public int firstBadVersion(int n) {
        // 二分查找
        // [1 ... n]
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            boolean badVersion = isBadVersion(mid);
            if (badVersion) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}