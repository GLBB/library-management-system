package cn.gl.librarymanagementsystem.service;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.SystemAdmin;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.result.Result;

public interface SystemAdminService {

    Result login(SystemAdmin admin);

    Result addUser(User user);

    Result delUser(User user);

    Result updateUser(User user);

    Result addBookAdmin(BookAdmin admin);

    Result delBookAdmin(BookAdmin admin);

    Result updateBookAdmin(BookAdmin admin);

    Result allUsers();

    Result allBookAdmins();

    Result updateSelf(SystemAdmin admin);

}
