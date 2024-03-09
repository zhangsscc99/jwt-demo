package top.lukeewin.jwtdemo2.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * 生成token
 * 要封装到token中的内容，如果需要传递多个值，那么可以定义为map或者json
 * 返回token。
 * 返回最终生成的token。
 */

public class TokenUtil {
    private final static String ENCRYPT_KEY = "abc123";
    private final static int EXPIRE_TIME = 30;

    private final static String ISSUER = "zhangsan";

    public static String createToken(JSONObject jsonObject) {
        return JWT.create()
                .withSubject(jsonObject.toString())
                .withIssuer(ISSUER)
                .withExpiresAt(DateUtil.offsetMinute(new Date(), EXPIRE_TIME))
                .withClaim("test", "123")
                .sign(Algorithm.HMAC256(ENCRYPT_KEY));



    }

    public static boolean verifyToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ENCRYPT_KEY)).withIssuer(ISSUER).build();
            jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
