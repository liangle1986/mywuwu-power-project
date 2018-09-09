package com.mywuwu.controller;

import com.mywuwu.entity.WuwuUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.mywuwu.controller
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/23 22:39
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理", description = "用户管理")
public class UserController extends BaseController {

    /**
     * 获取用户列表
     * @return
     */
    @ApiOperation(value = "查询用户列表")
    @GetMapping("/userList")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Map<String, Object> userList(){
        List<WuwuUser> users = userDetailsService.selectAll();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return map;
    }

    @ApiOperation(value = "查询用户权限")
    @GetMapping("/authorityList")
    @PreAuthorize("hasAuthority('MAIN_USER')")
    public List<String> authorityList(){
        List<String> authentication = getAuthentication();
        return authentication;
    }

}
