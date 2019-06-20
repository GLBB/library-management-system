package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchMapper {

    /**
     * 根据书名或作者名搜索
     */
    List<BookInfo> searchByBookNameOrAuthor(@Param("keyword") String keyword);

}
