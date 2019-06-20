package cn.gl.librarymanagementsystem.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * CREATE TABLE `book_info`  (
 *   `book_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `book_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `translater` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
 *   `price` float(10, 2) NOT NULL,
 *   `ISBN` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `come_up_time` datetime(0) NOT NULL COMMENT '出版日期',
 *   `publish_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `state` int(255) NOT NULL COMMENT '借出0, 在库1',
 *   `entering_man_id` int(20) UNSIGNED NOT NULL COMMENT '入库者 id',
 *   `entering_date` datetime(0) NOT NULL COMMENT '入库日期',
 *   PRIMARY KEY (`book_id`) USING BTREE,
 *   INDEX `entering_man_id`(`entering_man_id`) USING BTREE,
 *   CONSTRAINT `entering_man_id` FOREIGN KEY (`entering_man_id`) REFERENCES `book_admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE CASCADE
 * ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
 */
@Data
public class BookInfo {
    private Integer bookId; // 自动生成
    private String bookName;
    private String author;
    private String translater;
    private Float price;
    @JsonProperty("ISBN")
    private String ISBN;
    private LocalDateTime comeUpTime;
    private String publishCompany;
    private Integer state;  // 借出0, 在库1, 添加图书时默认为1
    private Integer enteringManId;  // 需要设置
    private LocalDateTime enteringDate; // 需要设置
}
