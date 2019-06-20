package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.bean.SystemAdmin;
import org.apache.ibatis.annotations.Param;

public interface SystemAdminMapper {

    SystemAdmin getSystemAdmin(Integer id);

    Integer updateSystemMapper(SystemAdmin admin);

    SystemAdmin getByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

}
