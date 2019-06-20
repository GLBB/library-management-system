package cn.gl.librarymanagementsystem.service.impl;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import cn.gl.librarymanagementsystem.mapper.SearchMapper;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchMapper searchMapper;

    @Override
    public Result<List<BookInfo>> searchByBookNameOrAuthor(String keyword) {
        List<BookInfo> bookInfos = searchMapper.searchByBookNameOrAuthor(keyword);
        if (bookInfos == null){
            return ResultGenerate.generateResult(Status.fail, "查询失败", null);
        }
        return ResultGenerate.generateResult(Status.success, null, bookInfos);
    }
}
