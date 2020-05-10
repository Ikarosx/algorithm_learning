package 剑指offer.数组;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] *
 * A[1] * ... * A[n-2];）
 *
 * @author Ikaros
 * @date 2020/5/7 18:05
 */
public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int result = 1;
        for (int i = 1; i < B.length; i++) {
            result *= A[i - 1];
            B[i] = result;
        }
        result = 1;
        if (A.length > 1) {
            B[0] = 1;
        }
        for (int i = B.length - 2; i >= 0; i--) {
            result *= A[i + 1];
            B[i] *= result;
        }
        return B;
    }
}
