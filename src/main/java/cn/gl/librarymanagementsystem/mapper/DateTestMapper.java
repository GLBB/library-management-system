package cn.gl.librarymanagementsystem.mapper;

import java.time.LocalDateTime;

public interface DateTestMapper {
    int addDate(LocalDateTime dateTime);

    LocalDateTime getDate(Integer id);
}
