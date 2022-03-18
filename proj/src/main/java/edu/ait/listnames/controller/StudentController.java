package edu.ait.listnames.controller;

import edu.ait.listnames.dto.SemesterYear;
import edu.ait.listnames.dto.StudentMenuRespDto;
import edu.ait.listnames.dto.StudentScoreDto;
import edu.ait.listnames.service.StudentService;
import edu.ait.listnames.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("StudentController")
@Api(value = "studentController", tags = { "student" })
@RequestMapping("gradeSys/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 学生端菜单列表 student menu list
     * @param id
     * @return
     */
    @GetMapping(value = "/findMenu")
    @ResponseBody
    public Result findMenu(@RequestParam(value = "id", required = false)
                                             @ApiParam(name = "id", value = "id", required = false) String id) {
        List<StudentMenuRespDto> menu = studentService.findMenu(id);
        return Result.successWithData(menu);
    }

    // return score list
        @PostMapping(value = "/findScore")
    @ResponseBody
    public Result findScore(@RequestBody StudentParam studentParam){
        List<StudentScoreDto> scoreList = studentService.findScore(studentParam.semesterYear,studentParam.userId);
        return Result.successWithData(scoreList);
    }


    //return semesterYear list
    @GetMapping(value = "/findSemesterYear")
    @ResponseBody
    public Result findSemesterYear() {
        List<SemesterYear> sy = studentService.findSemesterYear();
        return Result.successWithData(sy);
    }

}


class StudentParam {
    public SemesterYear semesterYear;
    public String userId;
        }