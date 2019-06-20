package cn.gl.librarymanagementsystem.controller;

import cn.gl.librarymanagementsystem.bean.BookInfo;
import cn.gl.librarymanagementsystem.mapper.SearchMapper;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/{keyword}")
    public Result<List<BookInfo>> search(@PathVariable String keyword){
//        System.out.println(keyword);
        Result<List<BookInfo>> result = searchService.searchByBookNameOrAuthor(keyword);
        return result;
    }



}
