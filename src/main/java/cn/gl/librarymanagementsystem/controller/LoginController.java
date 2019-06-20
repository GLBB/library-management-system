package cn.gl.librarymanagementsystem.controller;

import cn.gl.librarymanagementsystem.bean.BookAdmin;
import cn.gl.librarymanagementsystem.bean.SystemAdmin;
import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.LoginDTO;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.BookAdminService;
import cn.gl.librarymanagementsystem.service.SystemAdminService;
import cn.gl.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    BookAdminService bookAdminService;
    @Autowired
    SystemAdminService systemAdminService;

    @PostMapping("login")
    public Result login(@RequestBody LoginDTO loginDTO, HttpSession session, HttpServletResponse response){
        Integer identity = loginDTO.getIdentity();
        Result res = null;
        switch (identity){
            // 读者登陆
            case 1:
                res = userLogin(loginDTO);
                break;
            case 2:
                res = bookAdminLogin(loginDTO);
                break;
            case 3:
                res = systemAdminLogin(loginDTO);
                break;
            default:
//                throw new RuntimeException("用户身份不存在");
                return ResultGenerate.generateResult(Status.fail, "用户身份不存在", null);
        }
        if (res.getStatus().equals(Status.success)){
            Object data = res.getData();
            if (data instanceof User){
                session.setAttribute("identity", "user");
                session.setAttribute("id", ((User) data).getUserId());
            }else if (data instanceof BookAdmin){
                session.setAttribute("identity", "bookAdmin");
                session.setAttribute("id", ((BookAdmin) data).getAdminId());
            }else if (data instanceof SystemAdmin){
                session.setAttribute("identity", "systemAdmin");
                session.setAttribute("id", ((SystemAdmin) data).getAdminId());
            }
            session.setAttribute("user_info", data);
            String tocken = UUID.randomUUID().toString();
            session.setAttribute("tocken", tocken);
            Cookie cookie = new Cookie("tocken", tocken);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return res;
    }

    private Result userLogin(LoginDTO loginDTO){
        User user = loginDTO.convertUser();
        Result<User> res = userService.login(user);
        return res;
    }

    private Result bookAdminLogin(LoginDTO loginDTO){
        BookAdmin bookAdmin = loginDTO.convertBookAdmin();
        Result<BookAdmin> res = bookAdminService.login(bookAdmin);
        return res;
    }

    private Result systemAdminLogin(LoginDTO loginDTO){
        SystemAdmin systemAdmin = loginDTO.convertSystemAdmin();
        Result res = systemAdminService.login(systemAdmin);
        return res;
    }
}
