package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.BorrowRecord;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;

import java.util.List;

public interface BorrowRecordMapper {

    /**
     * 查询所有借阅记录
     */
    List<BorrowRecordDTO> getAllBorrowRecord();

    /**
     * 查询读者在借图书
     * @return
     */
    Integer countUserBorrowBookNum(Integer userId);

    /**
     * 插入借书记录
     * @param borrowRecord
     * @return
     */
    Integer insertBorrowRecord(BorrowRecord borrowRecord);

    /**
     * 利用书籍 id 和归还时间为 null 找到 borrowRecord
     * @param bookId
     * @return
     */
    BorrowRecord getByBookIdAndReturnTime(Integer bookId);

    /**
     * 更新 borrowRecord
     */
    Integer updateBorrowRecordReturnTime(BorrowRecord borrowRecord);


}
