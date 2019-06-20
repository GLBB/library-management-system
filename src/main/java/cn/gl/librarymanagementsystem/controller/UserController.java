package cn.gl.librarymanagementsystem.controller;

import cn.gl.librarymanagementsystem.bean.User;
import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import cn.gl.librarymanagementsystem.dto.PwdDTO;
import cn.gl.librarymanagementsystem.result.Result;
import cn.gl.librarymanagementsystem.result.ResultGenerate;
import cn.gl.librarymanagementsystem.result.Status;
import cn.gl.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Result userInfo(HttpServletRequest request){
        Result validate = IdentityValidate.identityValidate(request, request.getSession());
        return validate;
    }

    /**
     * 更新电话或邮箱
     * @param user
     * @param request
     * @return
     */
    @PutMapping
    public Result updateData(@RequestBody User user, HttpServletRequest request){
//        System.out.println("updateData run");
        IdentityValidate.identityValidate(request, request.getSession());
        // 更新用户电话和邮箱 或 密码
        if (user.getPhone() != null) { // 更新电话和邮箱
            HttpSession session = request.getSession();
            User originUser = (User) session.getAttribute("user_info");
            originUser.setPhone(user.getPhone());
            originUser.setEmail(user.getEmail());
            Result<User> result = userService.updateUserInfo(originUser);
            if (Status.fail.equals(result.getStatus())){
                return ResultGenerate.generateResult(Status.fail, "更新邮箱密码失败", null);
            }
            session.setAttribute("user_info", originUser);
            return ResultGenerate.generateResult(Status.success, "更新成功", null);
        }
        return ResultGenerate.generateResult(Status.fail, "更新事变", null);
    }

    @PutMapping("/pwd")
    public Result updatePwd(@RequestBody PwdDTO pwdDTO,
                            HttpServletRequest request){
        String originPwd = pwdDTO.getOriginPwd();
        String newPwd = pwdDTO.getNewPwd();
        Result vr = IdentityValidate.identityValidate(request, request.getSession());
        if (Status.fail.equals(vr.getStatus())){
            return vr;
        }
        User oUser = (User) vr.getData();
        String oPwd = oUser.getPwd();
        if (oPwd.equals(originPwd)){
            oUser.setPwd(newPwd);
            userService.updateUserInfo(oUser);
            HttpSession session = request.getSession();
            session.setAttribute("user_info", oUser);
            return ResultGenerate.generateResult(Status.success, "更新成功", null);
        }
        return ResultGenerate.generateResult(Status.fail, "原始密码错误", null);
    }

    /**
     * 在借图书
     * @return
     */
    @GetMapping("/borrow_record")
    public Result borrowRecord(HttpServletRequest request){
        Result vr = IdentityValidate.identityValidate(request, request.getSession());
        if (Status.fail.equals(vr.getStatus())){
            return vr;
        }
        User user = (User) vr.getData();
        Result<List<BorrowRecordDTO>> listResult = userService.borrowRecord(user);
        return listResult;
    }

    @GetMapping("/borrowed_record")
    public Result borrowedRecord(HttpServletRequest request){
        Result vr = IdentityValidate.identityValidate(request, request.getSession());
        if (Status.fail.equals(vr.getStatus())){
            return vr;
        }
        User user = (User) vr.getData();
        Result<List<BorrowRecordDTO>> listResult = userService.borrowedRecord(user);
        return listResult;
    }


}
