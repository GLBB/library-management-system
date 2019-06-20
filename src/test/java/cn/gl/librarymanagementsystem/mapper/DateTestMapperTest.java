package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.DateTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DateTestMapperTest {

    @Autowired
    DateTestMapper mapper;

    @Test
    public void test1(){
//        DateTest dateTest = new DateTest();
//        LocalDateTime dateTime = LocalDateTime.now();
//        mapper.addDate(dateTime);

    }

    @Test
    public void test2(){
        LocalDateTime date = mapper.getDate(2);
        System.out.println(date);
    }

    @Test
    public void test3(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime ten = now.plusDays(10);
        System.out.println(ten);
    }

}