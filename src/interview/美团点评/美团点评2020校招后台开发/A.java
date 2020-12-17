package interview.美团点评.美团点评2020校招后台开发; /**
 * @author Ikarosx
 * @date 2020/9/28 8:56
 */

import java.util.Scanner;
import java.util.Stack;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 栈
        while (scanner.hasNext()) {
            Stack<String> stack = new Stack<>();
            String text = scanner.nextLine();
            String[] strings = text.split(" ");
            String result = "false";
            for (int i = 0; i < strings.length; i++) {
                String s = strings[i];
                if ("or".equals(s) || "and".equals(s)) {
                    if (stack.isEmpty() || i == strings.length - 1 || stack.peek().equals("or")
                        || stack.peek().equals("and")) {
                        result = "error";
                        stack.clear();
                        break;
                    }
                    stack.push(s);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(s);
                    } else if (stack.peek().equals("or")) {
                        stack.push(s);
                    } else if (stack.peek().equals("and")) {
                        stack.pop();
                        if (!stack.peek().equals(s) || !s.equals("true")) {
                            stack.pop();
                            stack.push("false");
                        }
                    } else {
                        result = "error";
                        stack.clear();
                        break;
                    }
                }
            }
            for (String s : stack) {
                if (s.equals("true")) {
                    result = "true";
                    break;
                }
            }
            System.out.println(result);
        }


    }
}