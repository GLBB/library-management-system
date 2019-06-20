package cn.gl.librarymanagementsystem.bean;

import lombok.Cleanup;
import lombok.val;
import org.junit.After;
import org.junit.Test;


import lombok.NonNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * test for lombok
 *
 */
public class UserTest {

    // @Data 会重写 toString 和 hashcode
    @Test
    public void test1(){
        User user = new User();
        System.out.println(user.hashCode());
    }

    // val 默认添加 final 修饰
    @Test
    public void test2(){
        val user = new User();
//        user = null;
    }

    // test @NonNull
    @Test
    public void test3(){
        User user = null;
//        notNull(user);
    }

    public void notNull(@NonNull User user) throws IOException {

    }

    // @Cleanup
    @Test
    public void test4() throws IOException {
        @Cleanup val in = new FileInputStream("pom1.xml");
        in.readAllBytes();
    }





}