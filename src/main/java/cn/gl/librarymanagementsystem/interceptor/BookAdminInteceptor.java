package cn.gl.librarymanagementsystem.interceptor;

import cn.gl.librarymanagementsystem.controller.IdentityValidate;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.Status;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookAdminInteceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Result vr = IdentityValidate.identityValidate(request, request.getSession());
        HttpSession session = request.getSession();
        String identity = (String) session.getAttribute("identity");
        if (Status.fail.equals(vr.getStatus()) || !identity.equals("bookAdmin")){
            return false;
        }
        return true;
    }
}
