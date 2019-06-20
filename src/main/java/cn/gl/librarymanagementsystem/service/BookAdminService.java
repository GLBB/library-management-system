package cn.gl.librarymanagementsystem.service;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.BookInfo;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.result.Result;

import javax.servlet.http.HttpSession;

public interface BookAdminService {

    /**
     * 登陆
     * @param admin
     * @return
     */
    Result<BookAdmin> login(BookAdmin admin);

    /**
     * 借书
     * @param user
     * @param bookInfo
     * @return
     */
    Result borrowBook(User user, BookInfo bookInfo);

    /**
     * 还书
     * @param bookInfo
     * @return
     */
    Result returnBook(BookInfo bookInfo);

    /**
     * 添加图书
     * @param bookInfo
     * @return
     */
    Result addBookInfo(BookInfo bookInfo);

    /**
     * 删除图书
     */
    Result delBookInfo(BookInfo bookInfo);

    /**
     * 更新图书信息
     */
    Result updateBookInfo(BookInfo bookInfo);

    /**
     * 查询所有人的借阅记录
     */
    Result getBorrowRecord();

    /**
     * 查询所有图书
     */
    Result allBooks();

    /**
     * 更新自己信息
     * @param admin
     * @return
     */
    Result updateSelfInfo(BookAdmin admin);




}
