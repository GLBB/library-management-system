package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookInfoMapperTest {

    @Autowired
    BookInfoMapper mapper;

    @Test
    public void test1(){
        int affectRow = mapper.updateState(0, "978-7-121-2496-91");
        System.out.println(affectRow);
    }

    @Test
    public void test2(){
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("算法导论");
        bookInfo.setAuthor("Thomas");
        bookInfo.setTranslater("徐云");
        bookInfo.setPrice(189.0f);
        bookInfo.setISBN("978-7-121-9988-6");
        LocalDateTime comeUpTime = LocalDateTime.of(2013, Month.MAY, 3, 0, 0);
        bookInfo.setComeUpTime(comeUpTime);
        bookInfo.setPublishCompany("机械工业出版社");
        bookInfo.setState(1);
        bookInfo.setEnteringManId(1);
        LocalDateTime enterTime = LocalDateTime.of(2015, Month.FEBRUARY, 10, 0, 0);
        bookInfo.setEnteringDate(enterTime);

        int affectRow = mapper.addBookInfo(bookInfo);
        System.out.println(affectRow);
    }

    @Test
    public void test3(){
        int affectRow = mapper.delBookInfoByISBN("978-7-121-9988-6");
        System.out.println(affectRow);
    }

    /**
     * 查询 bookinfo
     */
    @Test
    public void test4(){
        BookInfo bookInfo = mapper.getBookInfoByISBN("978-7-121-9988-6");
        LocalDateTime enteringDate = bookInfo.getEnteringDate();
        System.out.println(enteringDate);
        System.out.println(bookInfo);
    }

    @Test
    public void test5(){
        BookInfo bookInfo = mapper.getBookInfoByISBN("978-7-121-9988-6");
        bookInfo.setTranslater("徐云云");
        int affectRow = mapper.updateBookInfo(bookInfo);
        System.out.println(affectRow);
    }

    @Test
    public void test6(){
        List<BookInfo> allBookInfo = mapper.getAllBookInfo();
        System.out.println(allBookInfo);
    }
}