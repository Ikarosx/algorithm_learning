package leetcode.序号.n100;

/**
 * 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
 *
 * 示例：
 *
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * 根据以上输入，你的查询应返回以下结果：
 *
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 * 说明：所有电子邮箱都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-emails
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/9 22:37
 */
public class N182查找重复的电子邮箱 {
    // SELECT Email FROM Person GROUP BY Email  HAVING COUNT(*) > 1;
}
