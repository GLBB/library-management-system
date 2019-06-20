package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchMapperTest {

    @Autowired
    SearchMapper searchMapper;

    @Test
    public void test1(){
        List<BookInfo> list = searchMapper.searchByBookNameOrAuthor("鲁");
        System.out.println(list);
    }

}