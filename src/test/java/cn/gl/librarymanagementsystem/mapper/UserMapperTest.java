package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BorrowRecord;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    public void test1(){
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        User user = mapper.getUserById(1);
        user.setPwd("122");
        mapper.updateUser(user);
    }

    @Test
    public void test3(){
        List<BorrowRecordDTO> list = mapper.getBorrowingRecord(1);
        System.out.println(list);
    }

    @Test
    public void test4(){
        List<BorrowRecordDTO> list = mapper.getBorrowRecord(1);
        System.out.println(list);
    }

    @Test
    public void test5(){
        User user = new User();
        user.setUserNumber("11603990101");
        user.setUsername("柯基");
        user.setPwd("101");
        user.setDepartment("计算机科学与工程");
        user.setMajor("网络工程");
        user.setPhone("13696325689");
        user.setEmail("10232@163.com");
        user.setMax(10);
        user.setTime(10);
        user.setBorrowingNum(0);
        mapper.addUser(user);
    }

    @Test
    public void test6(){
        mapper.deleteUser(3);
    }

    @Test
    public void test7(){
        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void test8(){
        User user = mapper.getUserByUserNumberAndPwd("11603990110", "122");
        System.out.println(user);
    }

}