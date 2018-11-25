package com.mywuwu;

import com.mywuwu.common.ds.DynamicDataSourceRegister;
import com.mywuwu.common.ds.TargetDataSource;
import com.mywuwu.dao.WuwuUserMapper;
import com.mywuwu.entity.WuwuUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@SpringBootApplication
@MapperScan("com.mywuwu.dao")
@Import(DynamicDataSourceRegister.class)
public class MywuwuDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MywuwuDaoApplication.class, args);
    }

}
