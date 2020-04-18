    package interview.腾讯2020校园招聘;
    
    import java.util.Scanner;
    import java.util.Stack;
    
    /**
     * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
     * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
     * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
     * 例如字符串ABCABCABC将会被压缩为[3|ABC]，
     * 现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
     * <p>
     * 输入描述:
     * 输入第一行包含一个字符串s，代表压缩后的字符串。
     * S的长度<=1000;
     * S仅包含大写字母、[、]、|;
     * 解压后的字符串长度不超过100000;
     * 压缩递归层数不超过10层;
     * <p>
     * 输出描述:
     * 输出一个字符串，代表解压后的字符串。
     * <p>
     * HG[3|B[2|CA]]F
     *
     * @author Ikaros
     * @date 2020/4/13 15:46
     */
    public class CompressAlgorithm {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(compressAlgorithm(scanner.next()));
            scanner.close();
        }
        
        public static String compressAlgorithm(String string) {
            // i为初始索引
            int i = 0;
            // 有几种情况、数字、字母、[|]
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            while (i < string.length()) {
                char c = string.charAt(i);
                if (c == '[') {
                    stack.push('[');
                    temp.append('[');
                    while (!stack.isEmpty()) {
                        i++;
                        temp.append(string.charAt(i));
                        if (string.charAt(i) == ']') {
                            stack.pop();
                        } else if (string.charAt(i) == '[') {
                            stack.push('[');
                        }
                    }
                    i++;
                    // 此时i的位置为]
                    // 把[]内的字符串,带数字的，传递给calcWithNum计算
                    result.append(calcWithNum(temp.toString().substring(1, temp.length() - 1)));
                    temp = new StringBuilder();
                } else {
                    result.append(c);
                    i++;
                }
            }
            return result.toString();
        }
        
        private static String calcWithNum(String string) {
            int indexOf = string.indexOf("|");
            int count = Integer.valueOf(string.substring(0, indexOf));
            StringBuilder result = new StringBuilder();
            String after = compressAlgorithm(string.substring(indexOf + 1));
            for (int i = 0; i < count; i++) {
                result.append(after);
            }
            return result.toString();
        }
        
    }
