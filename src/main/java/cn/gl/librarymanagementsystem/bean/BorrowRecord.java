package cn.gl.librarymanagementsystem.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * CREATE TABLE `borrow_record`  (
 *   `user_id` int(10) UNSIGNED NOT NULL,
 *   `book_id` int(10) UNSIGNED NOT NULL,
 *   `borrow_time` datetime(0) NOT NULL,
 *   `should_time` datetime(0) NOT NULL COMMENT '预计还书时间',
 *   `return_time` datetime(0) NULL DEFAULT NULL COMMENT '实际还书时间',
 *   PRIMARY KEY (`user_id`, `book_id`) USING BTREE,
 *   INDEX `book_id`(`book_id`) USING BTREE,
 *   CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
 *   CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON DELETE RESTRICT ON UPDATE CASCADE
 * ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
 */
@Data
public class BorrowRecord {
    private Integer userId;
    private Integer bookId;
    private LocalDateTime borrowTime;
    private LocalDateTime shouldTime;
    private LocalDateTime returnTime;

    public BorrowRecord() {
    }

    public BorrowRecord(Integer userId, Integer bookId, LocalDateTime borrowTime, LocalDateTime shouldTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.shouldTime = shouldTime;
    }
}
