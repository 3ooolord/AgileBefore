package edu.ait.listnames.controller;

import edu.ait.listnames.dto.AdminMenuResDto;
import edu.ait.listnames.dto.Lecturer;
import edu.ait.listnames.dto.SemesterYear;
import edu.ait.listnames.dto.Student;
import edu.ait.listnames.service.AdminService;
import edu.ait.listnames.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("AdminController")
@Api(value = "adminController", tags = { "admin" })
@RequestMapping("gradeSys/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    //retun AdminMenu list ,click AdminMenuDto to check param
    @GetMapping(value = "/findMenu")
    @ResponseBody
    public Result findMenu() {
        List<AdminMenuResDto> menu = adminService.findMenu();
        return Result.successWithData(menu);
    }

     //  return student param
    @PostMapping(value = "/findStudent")
    @ResponseBody
    public Result findAllStudent(@Validated@RequestBody ModuleSemesterParam moduleSemesterParam) {

        List<Student> allStudent = adminService.findAllStudent(moduleSemesterParam.moudleId);
        return Result.successWithData(allStudent);
    }

    //return lecturer param
    @GetMapping(value = "/findLecturer")
    @ResponseBody
    public Result findAllLecturer() {
        List<Lecturer> alllecturer = adminService.findAlllecturer();
        return Result.successWithData(alllecturer);
    }


    //return semesterYear param
    @GetMapping(value = "/findSemesterYear")
    @ResponseBody
    public Result findSemesterYear() {
        List<SemesterYear> sy = adminService.findSemesterYear();
        return Result.successWithData(sy);
    }

    /**
     * return student already select this module
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findStudentDone")
    @ResponseBody
    public List<Student> findStudentDone(@RequestParam(value = "id", required = false)
                                         @ApiParam(name = "id", value = "id", required = false) String id) {
        List<Student> allDoneStudent = adminService.findStudentDone(id);
        return allDoneStudent;
    }

    //save function
    @PostMapping(value = "/save")
    public Result saveStudentLecturer(@RequestBody ListParam listParam) {
        Boolean boo = adminService.saveLecturerStudent(listParam.studentIds, listParam.lecturerId,listParam.updateModuleId,listParam.updateSemesterId);
        return Result.successWithData(boo);
    }
}
class ListParam{
    public List<String> studentIds;
    public String lecturerId;
    public  String updateModuleId;
    public String updateSemesterId;

}
class ModuleSemesterParam{
    public String moudleId;
    public String semesterId;


    public String getMoudleId() {
        return moudleId;
    }

    public void setMoudleId(String moudleId) {
        this.moudleId = moudleId;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }
}