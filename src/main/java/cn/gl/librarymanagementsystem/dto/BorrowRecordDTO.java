package cn.gl.librarymanagementsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowRecordDTO {


    private String userNumber;
    private String bookName;
    private LocalDateTime borrowTime;
    private LocalDateTime shouldTime;
    private LocalDateTime returnTime;

}
