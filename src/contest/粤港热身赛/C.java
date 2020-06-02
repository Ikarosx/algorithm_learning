package collection.粤港热身赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 作为一个参加过表演的程序猿，始终忘却不了那种在台上的紧张感。
 * <p>
 * 在前年的舞王圣夜中，小Q被他的dalao们带上了舞台。
 * <p>
 * 但是身为程序猿的小Q，还被他的dalao委以重任，他需要负责所有参与舞王圣夜活动的用户管理。小Q需要根据dalao的指令，作出相应的反应，dalao的指令可能如下：
 * <p>
 * login admin <username> <password> //表示dalao通过他的账号username和密码password进入控制台，只有进入控制台才能执行接下去的[2-8]的操作，控制台默认为未登录
 * open auth //表示开启验证，验证默认为关闭
 * close auth //表示关闭验证
 * import list(k) //表示导入一份签到名单，k为一个整数，表示名单上面登记了k个用户，接下来为k行，每行包含一个字符串name与一个四位数字code，name表示用户的名字，code表示用户的签到码。在开启验证后，只有签到码与用户名相匹配才能成功参与活动
 * add <name> <code> //表示在签到名单上添加一个用户，name为一个字符串，表示添加的用户姓名，code为四位数字，表示该用户的签到码。
 * delete <name> //表示在签到名单上删除一个用户，name为一个字符串，表示需要删除的用户姓名。
 * update <name> <code> //表示在签到名单上更新一个用户，name为一个字符串，表示需要更新的用户姓名，code为四位数字，表示该用户新的签到码。
 * exit admin //表示dalao离开控制台，将不再能执行控制台操作
 * check <name> <code> //表示验证用户是否有参加活动的权限，name为一个字符串，表示需要验证的用户姓名，code为一个字符串(仅有数字组成)，表示该用户提交的签到码。（该操作可以在不登录的时候操作）
 * 指令有如下规则：
 * <p>
 * 如果登录控制台失败，则控制台输出"login failed!"
 * 如果登录控制台成功，则控制台输出"login success!"
 * 如果控制台已经登录，但是又再次成功登录，则控制台输出"has logged!"
 * 如果没有登录但是进行了操作，则输出"wrong operation, please login!"
 * 如果没有开启验证，成功开启验证后，输出"auth successfully opened!"
 * 如果已经开启验证，但是再次开启验证，则输出"auth has opened!"
 * 如果已经开启验证，成功关闭验证后，输出"auth successfully shut down!"
 * 如果没有开启验证，但是再次关闭验证，输出"auth has closed!"
 * 导入名单时，如果名单中有已存在的用户，则该用户不被导入，导入结束输出"import list success!"
 * 增加用户时，如果用户已存在，则输出"user already exists!"
 * 删除用户时，如果用户不存在，则输出"user does not exist!"
 * 更新用户签到码时，如果用户不存在，则输出"user does not exist!"
 * 增加用户或删除用户，或成功更新用户签到码时，输出"operation successful!"
 * 如果控制台已经登录，dalao离开控制台时，则输出"logout success!"
 * 验证用户是否有参加活动的权限时，如果不存在用户，则输出"user does not exist!"
 * 验证用户是否有参加活动的权限时，如果存在用户，如果需要校验但验证码不正确，则输出"code invalid!"
 * 验证用户是否有参加活动的权限时，如果存在用户，如果需要校验且验证码正确或不需要校验，则输出"successful
 * verification!"
 * <p>
 * 输入要求
 * 第一行包含一个整数T（1 <= T <= 10），表示有T组测试数据。
 * 接下来为T组数据，对于每一组测试数据包含n + m + 2行，(m为导入的所有名单上用户总和)，题目保证所有参与活动的用户不会超过1000000，保证每个name长度不超过5。
 * 第一行包含一个整数n（1 <= n <= 10000），n表示dalao有n条指令。
 * 第二行包含两个字符串username和password，(长度均不超过20)，username表示dalao的username，password表示dalao的password。
 * 接下来每行包含一个dalao的指令，保证指令输入合法。
 * 保证题目中username和name都是小写字母。
 * <p>
 * 输出要求
 * 对于每组输出先输出"Case #i:"，表示第i组测试，需要换行。
 * 接着根据题目说明，输出对应指令的控制台输出，每次输出后需要换行。
 *
 * @author Ikaros
 * @date 2020/4/18 20:47
 */
public class C {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            // n条指令
            int n = scanner.nextInt();
            String username = scanner.next();
            String password = scanner.next();
            Console console = new Console(username, password);
            System.out.println(String.format("Case #%d:", i + 1));
            for (int j = 0; j < n; j++) {
                String operate = scanner.next();
                switch (operate) {
                    case "login":
                        String admin = scanner.next();
                        console.login(scanner.next(), scanner.next());
                        break;
                    case "open":
                        scanner.next();
                        console.openAuth();
                        break;
                    case "close":
                        scanner.next();
                        console.closeAuth();
                        break;
                    case "import":
                        String listk = scanner.next();
                        String num = listk.substring(listk.indexOf("(") + 1, listk.length() - 1);
                        console.importList(Integer.valueOf(num));
                        break;
                    case "add":
                        console.add(scanner.next(), scanner.next());
                        break;
                    case "delete":
                        console.delete(scanner.next());
                        break;
                    case "update":
                        console.update(scanner.next(), scanner.next());
                        break;
                    case "exit":
                        scanner.next();
                        console.exit();
                        break;
                    case "check":
                        console.check(scanner.next(), scanner.next());
                        break;
                    default:
                    
                }
            }
        }
        scanner.close();
    }
    
    static class Console {
        String username;
        String password;
        boolean auth = false;
        boolean login = false;
        Map map = new HashMap<String, String>();
        
        
        Console(String username, String password) {
            this.username = username;
            this.password = password;
        }
        
        void login(String username, String password) {
            if (login && this.username.equals(username) && this.password.equals(password)) {
                System.out.println("has logged!");
                return;
            }
            if (this.username.equals(username) && this.password.equals(password)) {
                System.out.println("login success!");
                login = true;
            } else {
                System.out.println("login failed!");
            }
        }
        
        public void openAuth() {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            if (auth) {
                System.out.println("auth has opened!");
            } else {
                auth = true;
                System.out.println("auth successfully opened!");
            }
        }
        
        public void closeAuth() {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            if (auth) {
                auth = false;
                System.out.println("auth successfully shut down!");
            } else {
                System.out.println("auth has closed!");
            }
        }
        
        public void importList(Integer n) {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            for (Integer integer = 0; integer < n; integer++) {
                String username = scanner.next();
                String code = scanner.next();
                map.putIfAbsent(username, code);
            }
            System.out.println("import list success!");
        }
        
        public void add(String username, String code) {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            if (map.get(username) != null) {
                System.out.println("user already exists!");
                return;
            }
            map.put(username, code);
            operateSuccess();
        }
        
        public void operateSuccess() {
            System.out.println("operation successful!");
        }
        
        public boolean exists(String username) {
            
            if (map.get(username) == null) {
                System.out.println("user does not exist!");
                return false;
            }
            return true;
        }
        
        public void delete(String username) {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            if (exists(username)) {
                map.remove(username);
            }
            operateSuccess();
        }
        
        public void update(String username, String code) {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            if (exists(username)) {
                map.put(username, code);
            }
            operateSuccess();
        }
        
        public void exit() {
            if (!login) {
                System.out.println("wrong operation, please login!");
                return;
            }
            if (login) {
                System.out.println("logout success!");
            }
        }
        
        public void check(String username, String code) {
            if (exists(username)) {
                if (auth && !code.equals(map.get(username))) {
                    System.out.println("code invalid!");
                } else {
                    System.out.println("successful verification!");
                }
            }
        }
    }
}
