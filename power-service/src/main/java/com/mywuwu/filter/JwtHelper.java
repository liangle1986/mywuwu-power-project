package com.mywuwu.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @Package: com.mywuwu.filter
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/9/2 8:48
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public class JwtHelper {
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            System.out.println(jsonWebToken.startsWith("Bearer "));
            if(jsonWebToken.startsWith("Bearer ")){
                jsonWebToken = jsonWebToken.replace("Bearer ","");
            }
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String createJWT(String name, String userId, String role,
                                   String audience, String issuer, long TTLMillis, String base64Security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("Authorization", "Bearer")
                .claim("role", role)
                .claim("unique_name", name)
                .claim("userid", userId)
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

    public static void main(String[] args) {
        System.out.println("login................eyJBdXRob3JpemF0aW9uIjoiQmVhcmVyIiwiYWxnIjoiSFM1MTIifQ.eyJyb2xlIjoiU1lTX0FETUlOIiwidW5pcXVlX25hbWUiOiJsb2dpblBhc3N3b3JkIiwidXNlcmlkIjoiYWRtaW4iLCJpc3MiOiJlbnRpdHlOYW1lIiwiYXVkIjoiMTIzIiwiZXhwIjoxNTM1ODUxNzAwLCJuYmYiOjE1MzU4NTEwOTV9.ee_xSe7kOR3Sy-TMSSlFnZK_REg_alMrF6sdKXbyAsAQ9xoWJiJP66bqTdwvxwPREksSdkBszI8ciAbk-U4FTA");
        String resultMsg;
        String salt = "123456";
        String name = "admin";
        String role = "SYS_ADMIN";
        String clientID = "123";
        String entityName = "entityName";
        String loginName = "loginAdmin";
        String loginPassword = "loginPassword";
//        String md5Password = MyUtils.getMD5(loginName + salt);
        //拼装accessToken
        String accessToken = JwtHelper.createJWT(loginPassword, String.valueOf(name),
                role, clientID, entityName,
                604800, "mySecret");
        System.out.println("accessToken:" + accessToken);
        Claims claims = JwtHelper.parseJWT(accessToken,"mySecret");
        if(claims != null) {
            System.out.println(claims.getExpiration().toString());
        }
    }
}
