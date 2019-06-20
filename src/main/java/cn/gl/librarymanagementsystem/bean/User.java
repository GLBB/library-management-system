package cn.gl.librarymanagementsystem.bean;

import lombok.Data;

/**
 * CREATE TABLE `user`  (
 *   `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID（学号）',
 *   `user_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
 *   `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
 *   `department` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '院',
 *   `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '专业',
 *   `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
 *   `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
 *   `max` int(255) NOT NULL COMMENT '最大可借数量',
 *   `time` int(11) NOT NULL COMMENT '可借天数',
 *   `borrowing_num` int(11) NOT NULL COMMENT '在借数量',
 *   PRIMARY KEY (`user_id`) USING BTREE
 * ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
 */
@Data
public class User {
    private Integer userId;
    private String userNumber; // 学号
    private String username;
    private String pwd;
    private String department;
    private String major;
    private String phone;
    private String email;
    private Integer max; // 可借最大书籍数
    private Integer time; // 可借天数
    private Integer borrowingNum; // 在借数量
}
