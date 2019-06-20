package cn.gl.librarymanagementsystem.bean;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class DateTestTest {

    @Test
    public void test1(){
        System.out.println("run");

    }

    @Test
    public void test() throws ParseException {
        String str = "2016-02-03";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(str);
        System.out.println(date);

    }

}