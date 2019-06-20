package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookAdminMapper {

    /**
     * 逻辑: 读者借书, 输入借阅号和图书ISBN
     * 操作: 插入一条借书记录, 并修该 book info 中的 state
     *       应该放在 service 层
     */
//    void borrowBook(Integer uid, String ISBN);

    /**
     * 根据手机号和密码登陆
     */
    BookAdmin getByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 根据 id 查询管理员资料
     */
    BookAdmin getBookAdminById(Integer id);

    /**
     * 根据id 修改资料
     */
    Integer updateBookAdmin(BookAdmin admin);

    /**
     * 添加 bookAdmin
     */
    Integer addBookAdmin(BookAdmin admin);

    /**
     * 删除 admin
     */
    Integer delBookAdmin(Integer id);

    /**
     * 得到所有 book amdin
     */
    List<BookAdmin> getAllBookAdmin();





}
