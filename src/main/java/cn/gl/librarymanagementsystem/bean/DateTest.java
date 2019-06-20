package cn.gl.librarymanagementsystem.bean;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
public class DateTest {
    private Integer id;
    private LocalDateTime dateTime;
    private String des;
}
