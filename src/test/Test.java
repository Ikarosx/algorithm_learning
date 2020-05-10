package test;


/**
 * @author Ikaros
 * @date 2020/4/12 20:11
 */
public class Test {
    int n;
    
    public static void main(String[] args) {
        Bank bank = new Bank("Peggy", "yggeP");
        bank.save(200);
        bank.take("Peggy", "peggy", 300);
        bank.take("Peggy", "yggeP", 300);
        bank.take("Peggy", "yggeP", 200);
    }
    
}

class BANKEXCEPTION extends RuntimeException {
    public BANKEXCEPTION(String message) {
        super(message);
    }
}

class Bank {
    private String account;
    private String password;
    private double money;
    
    public double getMoney() {
        return money;
    }
    
    public Bank(String account, String password) {
        this.account = account;
        this.password = password;
        this.money = 0;
    }
    
    public void save(double money) {
        System.out.println(String.format("存入了%.2f元", money));
        this.money += money;
    }
    
    public void take(String account, String password, double money) {
        try {
            if (!account.equals(this.account) || !password.equals(this.password)) {
                throw new BANKEXCEPTION("账号密码不对");
            }
            if (this.money < money) {
                throw new BANKEXCEPTION("余额不足");
            }
        } catch (BANKEXCEPTION bankexception) {
            System.out.println("捕获异常：" + bankexception.getMessage());
            return;
        }
        this.money -= money;
        System.out.println(String.format("取出了%.2f元，余额%.2f元", money, this.money));
    }
}
