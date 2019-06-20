package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookAdminMapperTest {

    @Autowired
    BookAdminMapper mapper;

    @Test
    public void test1(){
        BookAdmin admin = mapper.getBookAdminById(1);
        System.out.println(admin);
    }

    @Test
    public void test2(){
        BookAdmin admin = mapper.getBookAdminById(1);
        admin.setAdminEmail("333@qqq.com");
        mapper.updateBookAdmin(admin);
    }

    @Test
    public void test3(){
        BookAdmin admin = new BookAdmin();
        admin.setAdminName("tony");
        admin.setAdminPwd("123");
        admin.setAdminPhone("15878945612");
        admin.setAdminEmail("tony@qq.com");
        mapper.addBookAdmin(admin);
    }

    @Test
    public void test4(){
        mapper.delBookAdmin(2);
    }

    @Test
    public void test5(){
        List<BookAdmin> allBookAdmin = mapper.getAllBookAdmin();
        System.out.println(allBookAdmin);
    }

    @Test
    public void test6(){
        BookAdmin admin = mapper.getByPhoneAndPwd("15589766932", "123");
        System.out.println(admin);
    }
}