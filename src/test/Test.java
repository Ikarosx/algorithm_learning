package test;


import com.alibaba.fastjson.JSONObject;
import com.tuya.api.TuyaClient;
import com.tuya.api.model.domain.device.DeviceResultOfToken;
import com.tuya.api.model.domain.device.DeviceVo;
import com.tuya.api.model.domain.device.SuccessDevices;
import com.tuya.api.model.enums.RegionEnum;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.util.List;

/**
 * @author Ikaros
 * @date 2020/4/12 20:11
 */
public class Test {
    
    
    public static void main(String[] args) throws Exception {
       
        // long time = System.currentTimeMillis();
        // System.out.println(time);
        // Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
        // SecretKeySpec secretKeySpec = new SecretKeySpec((secret).getBytes("UTF-8"), "HmacSHA256");
        // hmacSHA256.init(secretKeySpec);
        // System.out.println(clientId + time);
        // byte[] bytes = hmacSHA256.doFinal((clientId + accessToken + time).getBytes());
        // String hash = new HexBinaryAdapter().marshal(bytes).toUpperCase();
        // System.out.println(hash.toUpperCase());
    }
    
    
}

