package com.mywuwu.service.impl;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Package: com.mywuwu.service.impl
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/22 21:58
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}