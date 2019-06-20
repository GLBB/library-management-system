package cn.gl.librarymanagementsystem.service;

import cn.gl.librarymanagementsystem.bean.BorrowRecord;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import cn.gl.librarymanagementsystem.result.Result;

import java.util.List;

public interface UserService {

    /**
     *
     * @param user 包含用户学号和密码
     * @return
     */
    Result<User> login(User user);

    /**
     *  需登陆
     * @param user 需要更新的 user 信息
     * @return 返回更新后的用户信息
     */
    Result<User> updateUserInfo(User user);

    /**
     * 需登陆，查询该用户在借图书
     */
    Result<List<BorrowRecordDTO>> borrowRecord(User user);

    /**
     * 需登陆，查询用户借阅记录
     * @return
     */
    Result<List<BorrowRecordDTO>> borrowedRecord(User user);

    /**
     * 查询用户信息
     */
    Result getUserInfo(Integer id);








}
