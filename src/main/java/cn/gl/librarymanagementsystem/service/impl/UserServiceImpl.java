package cn.gl.librarymanagementsystem.service.impl;

import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import cn.gl.librarymanagementsystem.mapper.UserMapper;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;



    @Override
    public Result<User> login(User user) {
        User dbUser = userMapper.getUserByUserNumberAndPwd(user.getUserNumber(), user.getPwd());
        Result<User> result = new Result<>();
        if (dbUser == null){
            result.setStatus(Status.fail);
            result.setDescription("用户名或密码错误");
        }else {
            result.setStatus(Status.success);
            result.setData(dbUser);
        }
        return result;
    }

    @Override
    public Result updateUserInfo(User user) {
        Integer affectRow = userMapper.updateUser(user);
        Result<User> result = new Result<>();
        if (affectRow == 0){
            result.setStatus(Status.fail);
            result.setDescription("此用户不存在");
        }else {
            result.setStatus(Status.success);
        }
        return result;
    }

    @Override
    public Result<List<BorrowRecordDTO>> borrowRecord(User user) {
        List<BorrowRecordDTO> borrowingRecord = userMapper.getBorrowingRecord(user.getUserId());
        Result<List<BorrowRecordDTO>> result = new Result<>();
        if (borrowingRecord == null){
            result.setStatus(Status.fail);
            result.setDescription("用户不存在");
        }else{
            result.setStatus(Status.success);
            result.setData(borrowingRecord);
        }
        return result;
    }

    @Override
    public Result<List<BorrowRecordDTO>> borrowedRecord(User user) {
        List<BorrowRecordDTO> borrowRecord = userMapper.getBorrowRecord(user.getUserId());
        Result<List<BorrowRecordDTO>> result = new Result<>();
        if (borrowRecord == null){
            result.setStatus(Status.fail);
            result.setDescription("用户不存在");
        }else{
            result.setStatus(Status.success);
            result.setData(borrowRecord);
        }
        return result;
    }

    @Override
    public Result getUserInfo(Integer id) {
        User user = userMapper.getUserById(id);
        if (user == null){
            return ResultGenerate.generateResult(Status.fail, "查询用户失败", null);
        }
        return ResultGenerate.generateResult(Status.success, "查询用户失败", user);
    }
}
