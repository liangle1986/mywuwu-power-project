package com.mywuwu.service;

import com.mywuwu.entity.WuwuUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @Package: com.mywuwu.service
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/23 22:08
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public interface IUserDetailsService {
    /**
     * @param username 用户名
     * @param password 密码
     * @return com.mywuwu.entity.WuwuUser
     * @Description： 查询用户信息
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/27 21:54
     */
    WuwuUser findByUsername(String username, String password);

    /**
     * @return
     * @Description： 查询所有用户
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/27 21:58
     */
    List<WuwuUser> selectAll();
}
