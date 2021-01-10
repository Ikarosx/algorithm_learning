package leetcode.序号.n100;

/**
 * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
 *
 * @author Ikarosx
 * @date 2021/1/9 22:26
 */
public class N176第二高的薪水 {
    /**
     * SELECT
     *     IFNULL(
     *       (SELECT DISTINCT Salary
     *        FROM Employee
     *        ORDER BY Salary DESC
     *         LIMIT 1 OFFSET 1),
     *     NULL) AS SecondHighestSalary
     */
}
