package cn.gl.librarymanagementsystem.service.impl;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.SystemAdmin;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.mapper.BookAdminMapper;
import cn.gl.librarymanagementsystem.mapper.SystemAdminMapper;
import cn.gl.librarymanagementsystem.mapper.UserMapper;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SystemAdminServiceImpl implements SystemAdminService {
    @Autowired
    SystemAdminMapper systemAdminMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookAdminMapper bookAdminMapper;

    @Override
    public Result login(SystemAdmin admin) {
        SystemAdmin dbSystemAdmin
                = systemAdminMapper.getByPhoneAndPwd(admin.getAdminPhone(), admin.getAdminPwd());
        if (dbSystemAdmin == null)
            return ResultGenerate.generateResult(Status.fail, "用户名账号或密码错误", null);
        return ResultGenerate.generateResult(Status.success, null, dbSystemAdmin);
    }

    @Override
    public Result addUser(User user) {
        Integer affectRow = userMapper.addUser(user);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "添加失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result delUser(User user) {
        User dbUser = userMapper.getUserByUserNumber(user.getUserNumber());
        Integer affectRow = userMapper.deleteUser(dbUser.getUserId());
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "删除失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result updateUser(User user) {
        Integer affectRow = userMapper.updateUserByUserNumber(user);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "修改用户信息失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result addBookAdmin(BookAdmin admin) {
        Integer affectRow = bookAdminMapper.addBookAdmin(admin);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "添加图书管理员失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    /**
     * 根据 id 删除 book admin
     * @param admin
     * @return
     */
    @Override
    public Result delBookAdmin(BookAdmin admin) {
        Integer affectRow = bookAdminMapper.delBookAdmin(admin.getAdminId());
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "删除图书管理员失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result updateBookAdmin(BookAdmin admin) {
        Integer affectRow = bookAdminMapper.updateBookAdmin(admin);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "更新图书管理员失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result allUsers() {
        List<User> allUser = userMapper.getAllUser();
        if (allUser == null){
            return ResultGenerate.generateResult(Status.fail, "查询用户失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, allUser);
    }

    @Override
    public Result allBookAdmins() {
        List<BookAdmin> allBookAdmin = bookAdminMapper.getAllBookAdmin();
        if (allBookAdmin == null){
            return ResultGenerate.generateResult(Status.fail, "查询图书管理员失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, allBookAdmin);
    }

    @Override
    public Result updateSelf(SystemAdmin admin) {
        Integer affectRow = systemAdminMapper.updateSystemMapper(admin);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "更新系统管理员失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

}
