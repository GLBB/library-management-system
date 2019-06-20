package cn.gl.librarymanagementsystem.bean;

import lombok.Data;

/**
 * CREATE TABLE `book_admin`  (
 *   `admin_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书管理员名称',
 *   `admin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `admin_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `admin_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
 *   PRIMARY KEY (`admin_id`) USING BTREE
 * ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
 */
@Data
public class BookAdmin {
    private Integer adminId;
    private String adminName;
    private String adminPwd;
    private String adminPhone;
    private String adminEmail;

}
