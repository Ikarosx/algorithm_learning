package test;


/**
 * @author Ikaros
 * @date 2020/4/12 20:11
 */
public class Test {
    
    
    public static void main(String[] args) throws Exception {
        
        Integer integer = 501;
        Integer integer1 = 501;
        System.out.println(integer == integer1);
        long s1 = 1;
        
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

