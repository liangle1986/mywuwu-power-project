package com.mywuwu.dao;

import com.mywuwu.common.mapper.MyMapper;
import com.mywuwu.entity.WuwuUser;

public interface WuwuUserMapper extends MyMapper<WuwuUser> {

   WuwuUser findByUsername(String username, String password);
}