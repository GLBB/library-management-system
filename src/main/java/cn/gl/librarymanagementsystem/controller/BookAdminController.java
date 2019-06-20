package cn.gl.librarymanagementsystem.controller;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.BookInfo;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.ISBNDTO;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.BookAdminService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
@RequestMapping("bookadmin")
public class BookAdminController {

    @Autowired
    BookAdminService bookAdminService;


    @GetMapping("readerborrow")
    public Result readerBorrowBook(String userNumber, String ISBN, HttpServletRequest request){
        User user = new User();
        user.setUserNumber(userNumber);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setISBN(ISBN);
        Result result = bookAdminService.borrowBook(user, bookInfo);
        return result;
    }

    @GetMapping("returnbook")
    public Result returnBook(String ISBN, HttpServletRequest request){
        BookInfo bookInfo = new BookInfo();
        bookInfo.setISBN(ISBN);
        Result result = bookAdminService.returnBook(bookInfo);
        return result;
    }

    @PostMapping("book")
    public Result addBook(@RequestBody BookInfo bookInfo, HttpSession session){
        // 添加 state, enteringManId, enteringDate
        BookAdmin admin = (BookAdmin) session.getAttribute("user_info");
        bookInfo.setState(1);
        bookInfo.setEnteringManId(admin.getAdminId());
        bookInfo.setEnteringDate(LocalDateTime.now());
        Result result = bookAdminService.addBookInfo(bookInfo);
        return result;
    }

    /**
     * 应该先判断该书是否在库，若不在库，在删。
     * @return
     */
    @DeleteMapping("book")
    public Result deleteBook(@RequestBody ISBNDTO ISBNDTO){
        String ISBN = ISBNDTO.getISBN();
        BookInfo bookInfo = new BookInfo();
        bookInfo.setISBN(ISBN);
        Result result = bookAdminService.delBookInfo(bookInfo);
        return result;
    }

    /**
     * 提交的 bookinfo 应该包含所有信息，
     * @param bookInfo
     * @return
     */
    @PutMapping("book")
    public Result updateBook(BookInfo bookInfo){
        Result result = bookAdminService.updateBookInfo(bookInfo);
        return result;
    }

    @GetMapping("borrowedrecord")
    public Result borrowedRecord(){
        Result result = bookAdminService.getBorrowRecord();
        return result;
    }

    @GetMapping("allbook")
    public Result allBookInfo(){
        Result result = bookAdminService.allBooks();
        return result;
    }

//    @PutMapping
//    public Result updateInfo(){
//
//    }



}
