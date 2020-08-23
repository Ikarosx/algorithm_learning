package test;

import java.io.UnsupportedEncodingException;

/**
 * @author Ikarosx
 * @date 2020/7/31 20:22
 */
public class Demo {

    public static void main(String[] args) {
        byte[] bytes = {48, 58, -26, -103, -82, -23, -128, -102, -25, -108, -88, -26, -120, -73, 44,
            32, 49, 58, -25, -77, -69, -25, -69, -97, -25, -82, -95, -25, -112, -122, -27, -111,
            -104};
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(new String(bytes));
        try {
            System.out.println(new String(bytes, System.getProperty("file.encoding")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
