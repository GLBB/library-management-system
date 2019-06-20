package cn.gl.librarymanagementsystem.controller;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("systemadmin")
public class SystemAdminController {

    @Autowired
    SystemAdminService systemAdminService;

    @PostMapping("user")
    public Result addUser(@RequestBody User user) {
        user.setMax(10);
        user.setTime(10);
        user.setBorrowingNum(0);
        Result result = systemAdminService.addUser(user);
        return result;
    }

    /**
     * user 传入学号
     * @param user
     * @return
     */
    @DeleteMapping("user")
    public Result deleteUser(@RequestBody User user) {
        Result result = systemAdminService.delUser(user);
        return result;
    }

    /**
     * 传入学号
     * @param user
     * @return
     */
    @PutMapping("user")
    public Result updateUser(User user){
        Result result = systemAdminService.updateUser(user);
        return result;
    }

    @PostMapping("bookadmin")
    public Result addBookAdmin(@RequestBody BookAdmin bookAdmin){
        Result result = systemAdminService.addBookAdmin(bookAdmin);
        return result;
    }

    /**
     * 传入 book admin id
     * @param bookAdmin
     * @return
     */
    @DeleteMapping("bookadmin")
    public Result delBookAdmin(@RequestBody BookAdmin bookAdmin) {
        Result result = systemAdminService.delBookAdmin(bookAdmin);
        return result;
    }

    /**
     * 根据 book admin id
     * @param bookAdmin
     * @return
     */
    @PutMapping("bookadmin")
    public Result updateBookAdmin(BookAdmin bookAdmin) {
        Result result = systemAdminService.updateBookAdmin(bookAdmin);
        return result;
    }

    @GetMapping("alluser")
    public Result allUsers(){
        Result result = systemAdminService.allUsers();
        return result;
    }

    @GetMapping("allbookadmin")
    public Result allBookAdmin(){
        Result result = systemAdminService.allBookAdmins();
        return result;
    }

}
