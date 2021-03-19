package leetcode.sign;

/**
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * <p>
 * 请你实现 ParkingSystem 类：
 * <p>
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 * <p>
 * 解释：
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
 * parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
 * parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
 * parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= big, medium, small <= 1000
 * carType 取值为 1， 2 或 3
 * 最多会调用 addCar 函数 1000 次
 * 通过次数19,037提交次数22,351
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-parking-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/03/19
 */
public class N1603设计停车系统 {
    private int MAX_BIG;
    private int MAX_MEDIUM;
    private int MAX_SMALL;
    private int big;
    private int medium;
    private int small;

    public N1603设计停车系统(int big, int medium, int small) {
        this.MAX_BIG = big;
        this.MAX_MEDIUM = medium;
        this.MAX_SMALL = small;
        this.big = 0;
        this.medium = 0;
        this.small = 0;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && big < MAX_BIG) {
            big++;
            return true;
        }
        if (carType == 2 && medium < MAX_MEDIUM) {
            medium++;
            return true;
        }
        if (carType == 3 && small < MAX_SMALL) {
            small++;
            return true;
        }
        return false;
    }
}
