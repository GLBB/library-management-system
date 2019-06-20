package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {

    /**
     * 更改书籍入库出库状态, service 层应该限定 state 为 0 或 1
     * @param state
     * @return
     */
    int updateState(@Param("state") Integer state, @Param("ISBN") String ISBN);

    /**
     * 添加书籍
     */
    int addBookInfo(BookInfo bookInfo);

    /**
     * 图书出库,根据 ISBN 删除书籍
     */
    int delBookInfoByISBN(String ISBN);

    /**
     * 修改图书信息
     */
    int updateBookInfo(BookInfo bookInfo);

    /**
     * 根据ISBN 查询图书信息
     */
    BookInfo getBookInfoByISBN(String ISBN);

    /**
     * 得到所有图书
     */
    List<BookInfo> getAllBookInfo();

}
