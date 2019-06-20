package cn.gl.librarymanagementsystem.dto;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.SystemAdmin;
import cn.gl.librarymanagementsystem.bean.User;
import lombok.Data;

@Data
public class LoginDTO {

    /**
     * 1 代表读者
     * 2 代表图书管理员
     * 3 代表系统管理员
     */
    private Integer identity;
    private String accountNumber;
    private String pwd;

    public User convertUser(){
        User user = new User();
        user.setUserNumber(accountNumber);
        user.setPwd(pwd);
        return user;
    }

    public BookAdmin convertBookAdmin(){
        BookAdmin admin = new BookAdmin();
        admin.setAdminPhone(accountNumber);
        admin.setAdminPwd(pwd);
        return admin;
    }

    public SystemAdmin convertSystemAdmin(){
        SystemAdmin admin = new SystemAdmin();
        admin.setAdminPhone(accountNumber);
        admin.setAdminPwd(pwd);
        return admin;
    }

}
