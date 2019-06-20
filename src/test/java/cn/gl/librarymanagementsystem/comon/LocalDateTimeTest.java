package cn.gl.librarymanagementsystem.comon;

import org.junit.Test;

import java.time.LocalDateTime;

public class LocalDateTimeTest {

    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }
}
