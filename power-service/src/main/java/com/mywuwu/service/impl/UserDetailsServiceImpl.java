package com.mywuwu.service.impl;

import com.mywuwu.dao.WuwuUserMapper;
import com.mywuwu.entity.WuwuUser;
import com.mywuwu.service.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * @Description： 查询用户
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/27 21:48
 * @return
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, IUserDetailsService {

    @Autowired
    private WuwuUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WuwuUser user = userMapper.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), emptyList());
    }

    @Override
    public WuwuUser findByUsername(String username) {

        return  userMapper.findByUsername(username);
    }
    @Override
    public List<WuwuUser> selectAll(){
        return  userMapper.selectAll();
    }
}