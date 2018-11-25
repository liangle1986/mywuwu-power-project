package com.mywuwu.controller;

import com.mywuwu.entity.WuwuUser;
import com.mywuwu.exception.UsernameIsExitedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.mywuwu.controller
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/23 22:37
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
@RestController
@RequestMapping("/users")
@Api(value = "注册管理", description = "注册管理")
public class RegisterController extends BaseController {

    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @ApiOperation(value = "注册用户")
    @PostMapping("/signup")
    public WuwuUser signup(@RequestBody WuwuUser user) {
        WuwuUser bizUser = userDetailsService.findByUsername(user.getUserName(), "");
        if(null != bizUser){
            throw new UsernameIsExitedException("用户已经存在");
        }
        /*user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return bizUser;
//                userRepository.save(user);
    }

}
