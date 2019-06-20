package cn.gl.librarymanagementsystem.controller;

import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

public class IdentityValidate {

    public static Result identityValidate(HttpServletRequest request, HttpSession session){
//        System.out.println(session.getId());
        Cookie[] cookies = request.getCookies();
        String tocken = findTocken(cookies);
        String sessionTocken = (String) session.getAttribute("tocken");
        if (tocken.equals(sessionTocken)) {
            Result res = ResultGenerate.generateResult(Status.success, null,
                    session.getAttribute("user_info"));
            return res;
        }else {
            return ResultGenerate.generateResult(Status.fail, "校验失败",
                    session.getAttribute("user_info"));
        }

    }




    private static String findTocken(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if ("tocken".equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return "";
    }

}
