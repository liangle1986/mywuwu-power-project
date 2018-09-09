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
     * @Description： 查询用户信息
     * @param username 用户名
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/27 21:54
     * @return com.mywuwu.entity.WuwuUser
     */
    WuwuUser findByUsername(String username);

    /**
     * @Description： 查询所有用户
     * @Author: 梁乐乐
     * @Date: Created in 2018/8/27 21:58
     * @return
     */
    List<WuwuUser> selectAll();
}
