package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.SystemAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemAdminMapperTest {

    @Autowired
    SystemAdminMapper mapper;

    @Test
    public void test1(){
        SystemAdmin systemAdmin = mapper.getSystemAdmin(1);
        systemAdmin.setAdminEmail("555@qq.com");
        mapper.updateSystemMapper(systemAdmin);
    }

    @Test
    public void test2(){
        SystemAdmin admin = mapper.getByPhoneAndPwd("13836958796", "123");
        System.out.println(admin);
    }

}