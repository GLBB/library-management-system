package cn.gl.librarymanagementsystem.service.impl;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.BookInfo;
import cn.gl.librarymanagementsystem.bean.BorrowRecord;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import cn.gl.librarymanagementsystem.mapper.BookAdminMapper;
import cn.gl.librarymanagementsystem.mapper.BookInfoMapper;
import cn.gl.librarymanagementsystem.mapper.BorrowRecordMapper;
import cn.gl.librarymanagementsystem.mapper.UserMapper;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.BookAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookAdminServiceImpl implements BookAdminService {

    @Autowired
    BookAdminMapper bookAdminMapper;
    @Autowired
    BorrowRecordMapper borrowRecordMapper;
    @Autowired
    BookInfoMapper bookInfoMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Result<BookAdmin> login(BookAdmin admin) {
        BookAdmin dbAdmin = bookAdminMapper.getByPhoneAndPwd(admin.getAdminPhone(), admin.getAdminPwd());
        Result<BookAdmin> result =
                ResultGenerate.generateResult(Status.success, "返回结果", dbAdmin);
        return result;
    }

    /**
     * 读者借书， 读者包含学号，书籍输入 ISBN
     * 插入借阅记录， 修改书籍状态，变为出库
     * @param user
     * @param bookInfo
     * @return
     */
    @Override
    public Result borrowBook(User user, BookInfo bookInfo) {
        // 先根据 ISBN 查询图书, 得到图书,判断该书是否在库。根据学号查询读者。
        // 插入借阅记录和修改书籍状态
        User dbUser = userMapper.getUserByUserNumber(user.getUserNumber());
        Integer borrowBookNum = borrowRecordMapper.countUserBorrowBookNum(dbUser.getUserId());
        if (borrowBookNum >= dbUser.getMax()){
            // 借阅图书超限
            return ResultGenerate.generateResult(Status.fail, "在借图书已达最大上限", null);
        }
        // 还可以借书
        BookInfo dbBookInfo = bookInfoMapper.getBookInfoByISBN(bookInfo.getISBN());
        if (dbBookInfo.getState()==0){
            // 图书已被借出
            return ResultGenerate.generateResult(Status.fail, "图书已被借出", null);
        }
        // 修改图书状态, 借出
        dbBookInfo.setState(0);
        bookInfoMapper.updateBookInfo(dbBookInfo);
        // 插入借书记录
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sholdReturnTime = now.plusDays(dbUser.getTime());
        BorrowRecord borrowRecord = new BorrowRecord(dbUser.getUserId(), dbBookInfo.getBookId(),
                now, sholdReturnTime);
        Integer affectRow = borrowRecordMapper.insertBorrowRecord(borrowRecord);
        // 修改读者借书
        // 现略
        Result<Integer> result = ResultGenerate.generateResult(Status.success, "影响行数", affectRow);
        return result;
    }

    /**
     * 还书,
     * 修改书籍状态，修改插入记录中的returntime
     * @param bookInfo
     * @return
     */
    @Override
    public Result returnBook(BookInfo bookInfo) {
        BookInfo dbBookInfo = bookInfoMapper.getBookInfoByISBN(bookInfo.getISBN());
        if (dbBookInfo.getState() == 1){
            return ResultGenerate.generateResult(Status.fail, "图书已在库", null);
        }
        BorrowRecord borrowRecord = borrowRecordMapper.getByBookIdAndReturnTime(dbBookInfo.getBookId());
        if (borrowRecord.getReturnTime() != null){
            return ResultGenerate.generateResult(Status.fail, "图书已归还", null);
        }
        // 还书，修改 bookinfo state， 修改 return time
        dbBookInfo.setState(1);
        bookInfoMapper.updateBookInfo(dbBookInfo);
        borrowRecord.setReturnTime(LocalDateTime.now());
        Integer affectRow = borrowRecordMapper.updateBorrowRecordReturnTime(borrowRecord);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "更新失败", null);
        }
        Result<Integer> result = ResultGenerate.generateResult(Status.success, null, affectRow);
        return result;
    }

    @Override
    public Result addBookInfo(BookInfo bookInfo) {
        // 添加 state, enteringManId, enteringDate

        int affectRow = bookInfoMapper.addBookInfo(bookInfo);
        if (affectRow == 0) {
            return ResultGenerate.generateResult(Status.fail, "添加书籍失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result delBookInfo(BookInfo bookInfo) {
        int affectRow = bookInfoMapper.delBookInfoByISBN(bookInfo.getISBN());
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "删除失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }

    @Override
    public Result updateBookInfo(BookInfo bookInfo) {
        int affectRow = bookInfoMapper.updateBookInfo(bookInfo);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, null, affectRow);
        }
        return ResultGenerate.generateResult(Status.success, null,  affectRow);
    }

    @Override
    public Result getBorrowRecord() {
        List<BorrowRecordDTO> allBorrowRecord = borrowRecordMapper.getAllBorrowRecord();
        if (allBorrowRecord == null){
            return ResultGenerate.generateResult(Status.fail, "未知异常", null);
        }
        return ResultGenerate.generateResult(Status.success, null, allBorrowRecord);
    }

    @Override
    public Result allBooks() {
        List<BookInfo> allBookInfo = bookInfoMapper.getAllBookInfo();
        if (allBookInfo == null){
            return ResultGenerate.generateResult(Status.fail, "未知异常", null);
        }
        return ResultGenerate.generateResult(Status.success, null, allBookInfo);
    }

    @Override
    public Result updateSelfInfo(BookAdmin admin) {
        Integer affectRow = bookAdminMapper.updateBookAdmin(admin);
        if (affectRow == 0){
            return ResultGenerate.generateResult(Status.fail, "未知异常", null);
        }
        return ResultGenerate.generateResult(Status.success, null, affectRow);
    }
}
