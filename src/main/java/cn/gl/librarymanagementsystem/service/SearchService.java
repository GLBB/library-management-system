package cn.gl.librarymanagementsystem.service;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import cn.gl.librarymanagementsystem.result.Result;

import java.util.List;

public interface SearchService {

    Result<List<BookInfo>> searchByBookNameOrAuthor(String keyword);
}
