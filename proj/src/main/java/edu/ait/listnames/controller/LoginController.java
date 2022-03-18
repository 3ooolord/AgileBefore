package edu.ait.listnames.controller;

import edu.ait.listnames.service.LoginService;
import edu.ait.listnames.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController("login")
@Api(value = "login", tags = { "login" })
@RequestMapping("gradeSys/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

//    //adminLogin
//    @PostMapping(value = "/admin")
//    public Result adminLogin(@RequestBody InfoParam infoParamA){
//        if ((loginService.adminLogin(infoParamA.userName, infoParamA.password))!=null){
//        return Result.successWithData(loginService.adminLogin(infoParamA.userName, infoParamA.password));}
//        else return Result.failWithMessage("failed");
//    }
//    //studentLogin
//    @PostMapping(value = "/student")
//    public Result studentLogin(@RequestBody InfoParam infoParamS){
//        if ((loginService.studentLogin(infoParamS.userName, infoParamS.password))!=null){
//        return Result.successWithData(loginService.studentLogin(infoParamS.userName, infoParamS.password));}
//        else return Result.failWithMessage("failed");
//    }
//    //lecturerLogin
//    @PostMapping(value = "/lecturer")
//    public Result lecturerLogin(@RequestBody InfoParam infoParamL){
//        if (loginService.lecturerLogin(infoParamL.userName,infoParamL.password)!=null){
//            return Result.successWithData(loginService.lecturerLogin(infoParamL.userName, infoParamL.password));
//        }
//        else return Result.failWithMessage("failed");
//    }

    @PostMapping(value = "/checklogin")
    public Result checkLogin(@Validated@RequestBody InfoParam infoParamCL){
        if (loginService.adminLogin(infoParamCL.userName,infoParamCL.password)!=null){
            return Result.successWithData(loginService.adminLogin(infoParamCL.userName,infoParamCL.password));
        }else if ((loginService.studentLogin(infoParamCL.userName, infoParamCL.password))!=null){
            return Result.successWithData(loginService.studentLogin(infoParamCL.userName,infoParamCL.password));
        }else if (loginService.lecturerLogin(infoParamCL.userName,infoParamCL.password)!=null){
            return Result.successWithData(loginService.lecturerLogin(infoParamCL.userName,infoParamCL.password));
        }else return Result.failWithMessage("failed");
    }

}
class InfoParam{
   public String userName;
   public String password;
}