package edu.ait.listnames.controller;

import edu.ait.listnames.dto.Grade;
import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.dto.LecturerGradeResDto;
import edu.ait.listnames.repository.GradeRepository;
import edu.ait.listnames.service.LectureService;
import edu.ait.listnames.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("LecturerController")
@Api(value = "lecturerController", tags = { "lecturer" })
@RequestMapping("gradeSys/lecturer")
public class LecturerController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private GradeRepository gradeRepository;

    /**
     * 导师端菜单列表 lecturer return menu list
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findMenu")
    @ResponseBody
    public Result findMenu(@RequestParam(value = "id", required = false)
                           @ApiParam(name = "id", value = "id", required = false) String id) {
        List<LectureMenuResDto> menu = lectureService.findMenu(id);
        return Result.successWithData(menu);
    }

//       return grade list
    @PostMapping(value = "/findGrade")
    @ResponseBody
    public Result findGrade(@RequestBody LecturerParam lecturerParam) {
        List<LecturerGradeResDto> Grade = lectureService.findGrade(lecturerParam.getMoudleId(), lecturerParam.getSemesterId());
        return Result.successWithData(Grade);
    }

//save the change
    @PostMapping(value = "/save")
    @ResponseBody
    public Result save(@Validated@RequestBody StudentParamL studentParam) {
        for (int i = 0; i < studentParam.getStudentGrades.size(); i++) {
            Integer oneGrade = studentParam.getStudentGrades.get(i);
            String stdentId = studentParam.getStudentIds.get(i);
            String gradeId=studentParam.getGradeIds.get(i);
            String smstYId=studentParam.getsemesterYearId.get(i);
            String moudleId=studentParam.getmoudleId.get(i);
            System.out.println(moudleId);

            Grade grade = new Grade();
            grade.setId(gradeId);
            grade.setStudentId(stdentId);
            grade.setGrade(oneGrade);
            grade.setSemesterYearId(smstYId);
            grade.setMoudleId(moudleId);
            gradeRepository.save(grade);
        }
        return Result.successWithMessage("success");
    }


}
    class LecturerParam{
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

    class StudentParamL{
    public  List<String> getStudentIds;
    public  List<Integer> getStudentGrades;
    public  List<String> getGradeIds;
    public List<String> getsemesterYearId;
    public List<String> getmoudleId;

    public List<String> getGetStudentIds() {
        return getStudentIds;
    }

    public void setGetStudentIds(List<String> getStudentIds) {
        this.getStudentIds = getStudentIds;
    }

    public List<Integer> getGetStudentGrades() {
        return getStudentGrades;
    }

    public void setGetStudentGrades(List<Integer> getStudentGrades) {
        this.getStudentGrades = getStudentGrades;
    }

    public List<String> getGetGradeIds() {
        return getGradeIds;
    }

    public void setGetGradeIds(List<String> getGradeIds) {
        this.getGradeIds = getGradeIds;
    }

    public List<String> getGetsemesterYearId() {
        return getsemesterYearId;
    }

    public void setGetsemesterYearId(List<String> getsemesterYearId) {
        this.getsemesterYearId = getsemesterYearId;
    }

    public List<String> getGetmoudleId() {
        return getmoudleId;
    }

    public void setGetmoudleId(List<String> getmoudleId) {
        this.getmoudleId = getmoudleId;
    }
}