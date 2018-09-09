package com.mywuwu.controller;

import com.mywuwu.entity.WuwuUser;
import com.mywuwu.filter.JwtHelper;
import com.mywuwu.powerconfig.ConstantKey;
import com.mywuwu.util.JwtTokenUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.mywuwu.controller
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/23 22:36
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
@RestController
@Api(value = "登录管理", description = "登录管理")
public class LoginController extends BaseController {


    @ApiOperation(value = "自定义登录")
    @GetMapping(value = "/login")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void login(@Param("username") String username, String password, HttpServletResponse response) {
        WuwuUser userVo = userDetailsService.findByUsername(username);
        if (userVo != null) {

            /**
             * 自定义生成Token，因为使用了自定义登录，就不会执行JWTLoginFilter了，所以需要字段调用生成token并返给前端
             */

            // 这里可以根据用户信息查询对应的角色信息，这里为了简单，我直接设置个空list
            List roleList = new ArrayList<>();
            roleList.add("ROLE_USER");

            String token =  JwtHelper.createJWT(userVo.getLoginName(),userVo.getId() + "","ROLE_USER",userVo.getPassword(),"自定义登录",ConstantKey.EXPIRATION_DATE, ConstantKey.SIGNING_KEY);
       /*     String subject = userVo.getUserName() + ":" + userVo.getLoginName() + "-" + roleList;
            String token = Jwts.builder()
                    .setSubject(subject)
                    .setExpiration(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)) // 设置过期时间 365 * 24 * 60 * 60秒(这里为了方便测试，所以设置了1年的过期时间，实际项目需要根据自己的情况修改)
                    .signWith(SignatureAlgorithm.HS512, ConstantKey.SIGNING_KEY) //采用什么算法是可以自己选择的，不一定非要采用HS512
                    .compact();*/
            // 登录成功后，返回token到header里面
            response.addHeader("Authorization", "Bearer " + token);
        }
    }
}
