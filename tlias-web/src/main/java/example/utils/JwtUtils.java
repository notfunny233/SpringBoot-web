package example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // HS256密钥，至少32字符
    private static final SecretKey KEY = Keys.hmacShaKeyFor(
            "aXRoZWl0YQ==aXRoZWl0YQ==aXRoZWl0YQ==".getBytes()
    );

    // 过期时间：12小时（毫秒）
    private static final long EXPIRATION = 12 * 3600 * 1000L;

    /**
     * 生成JWT令牌
     *
     * @param dataMap 自定义数据（如 id、username 等）
     * @return JWT令牌字符串
     */
    public static String generateToken(Map<String, Object> dataMap) {
        return Jwts.builder()
                .claims(dataMap)                                        // 添加自定义数据
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION)) // 设置过期时间为12小时System.currentTimeMillis () 为获取系统现在的时间
                .signWith(KEY, Jwts.SIG.HS256)                         // 使用HS256算法和密钥签名
                .compact();                                             // 生成令牌
    }

    /**
     * 解析JWT令牌
     *
     * @param token JWT令牌字符串
     * @return Claims对象，包含令牌中的自定义数据
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(KEY)              // 设置验证密钥
                .build()                      // 构建解析器实例
                .parseSignedClaims(token)     // 解析令牌
                .getPayload();                // 获取自定义数据部分
    }
}