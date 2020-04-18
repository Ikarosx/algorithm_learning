package test;

import java.io.IOException;

/**
 * @author Ikaros
 * @date 2020/4/12 20:11
 */
public class Test {
    public static void main(String[] args) throws IOException {
        int[] array = {1, 3};
        System.out.println("初始的时候array的内存地址为" + System.identityHashCode(array));
        // 初始的时候array的内存地址为325040804
        
        array[0] = 3;
        System.out.println("对array[0]修改值后内存地址为" + System.identityHashCode(array));
        // 对array[0]修改值后内存地址为325040804
        
        final int[] finalArray = array;
        System.out.println("定义常量数组finalArray的内存地址为" + System.identityHashCode(finalArray));
        // 定义常量数组finalArray的内存地址为325040804
        
        array = new int[]{3, 4};
        System.out.println("array重新赋值后array的内存地址为" + System.identityHashCode(array));
        // array重新赋值后array的内存地址为1173230247
        
        System.out.println("array重新复制后finalArray的内存地址为" + System.identityHashCode(finalArray));
        // array重新复制后finalArray的内存地址为325040804
    }
}
