package test;


import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ikaros
 * @date 2020/4/12 20:11
 */
public class Test {


    public static void main(String[] args) throws Exception {

        File file2 = new File("2.txt");
        //        if (!file2.exists()) {
        //            file2.createNewFile();
        //        }
        System.out.println(file2.getAbsolutePath());
        List<Integer> integers = new LinkedList<Integer>() {{
            add(1);
            add(1);
            add(2);
            add(2);
        }};
        integers = integers.stream().distinct().collect(Collectors.toList());
        System.out.println(integers);
    }

    class A {

        private String s;


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                // 引用相同返回true
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                // obj为null或者两者class不等价
                return false;
            }
            A a = (A) obj;
            if (!s.equals(a.s)) {
                return false;
            }
            return true;
        }
    }
}

