package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User getUserById(Integer id);

    Integer updateUser(User user);

    Integer updateUserByUserNumber(User user);


    /**
     * 查询在借记录
     * @param id 读者 id
     * @return
     */
    List<BorrowRecordDTO> getBorrowingRecord(Integer id);

    /**
     * 查询借阅记录
     * @param id
     * @return
     */
    List<BorrowRecordDTO> getBorrowRecord(Integer id);

    /**
     * 添加用户
     */
    Integer addUser(User user);

    /**
     * 根据学号删除用户
     */
    Integer deleteUser(Integer id);

    /**
     * 查询所有用户
     */
    List<User> getAllUser();

    /**
     * 通过学号和密码得到用户
     */
    User getUserByUserNumberAndPwd(@Param("userNumber") String userNumber, @Param("pwd") String pwd);

    /**
     * 通过学号查询用户
     */
    User getUserByUserNumber(String userNumber);

}
