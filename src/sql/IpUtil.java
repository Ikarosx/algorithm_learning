package sql;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Ikaros
 * @date 2020/4/24 16:35
 */
public class IpUtil {
    @Test
    public void test() {
        long x = ipToInt("192.168.1.1");
        System.out.println(intToIp(x));
    }
    
    public static long ipToInt(String ip) {
        int[] split = Arrays.stream(ip.split("\\.")).mapToInt(Integer::valueOf).toArray();
        
        assert split.length == 4;
        long result = 0;
        // 192.168.1.1
        // 192 * 256^3
        // 168 * 256^2
        // 1 * 256^1
        // 1 * 256^0
        // 256 = 2^8
        // 1 << 1 = 2
        result += split[0] * (1L << 24);
        result += split[1] * (1 << 16);
        result += split[2] * (1 << 8);
        result += split[3];
        return result;
    }
    
    public static String intToIp(long i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((i >>> 24) + ".");
        stringBuilder.append((i >>> 16 & 0xff) + ".");
        stringBuilder.append((i >>> 8 & 0xff) + ".");
        stringBuilder.append(i & 0xff);
        return stringBuilder.toString();
    }
}
