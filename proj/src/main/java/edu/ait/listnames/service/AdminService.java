package edu.ait.listnames.service;

import edu.ait.listnames.dto.*;
import edu.ait.listnames.repository.AdminRepository;
import edu.ait.listnames.repository.GradeRepository;
import edu.ait.listnames.repository.StudentLecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @program: listnames
 * @description: 管理员端 admin
 **/
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StudentLecturerRepository studentLecturerRepository;

    @Autowired
    private GradeRepository gradeRepository;


    @Transactional(propagation = Propagation.REQUIRED)
    public List<AdminMenuResDto> findMenu(){
        Pageable pageable = PageRequest.of(0,10);
        Page<AdminMenuResDto> page = adminRepository.findMenu(pageable);
        List<AdminMenuResDto> menuList = page.getContent();
        return menuList;
    }

    /**
     * 未选择这门课的学生 students who did not select this lecture
     * @param moudleId
     * @return
     */
    public List<Student> findAllStudent(int moudleId) {
        // 选择该课程的学生
        List<Student> findStudentList = adminRepository.findStudentIdList(moudleId);
        // 所有学生
        List<Student> allStudent = adminRepository.findAllStudent();

        int i=1;
        for (Student student:allStudent) {
            for (Student studentT:findStudentList) {
                i++;
                if (student.getId()==studentT.getId()){
                    break;
                }else if (i>=findStudentList.size()){

                }
            }
        }
        // 未选择该课程的学生
        List<Student> collect = allStudent.stream().filter(student -> {
            if (findStudentIdList.contains(student.getId())) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 已选择这门课的学生 students selected this lecture
     */
    public List<Student> findStudentDone(String moudleId){
        List<Student> findStudentList = adminRepository.findStudentIdList(moudleId);
        return  findStudentList;
    }

    //老师名单 lecturer list
    public List<Lecturer> findAlllecturer(){
        List<Lecturer> findAllLecturer=adminRepository.findAllLecturer();
        return findAllLecturer;
    }

    //学期学年表单  semesterYear list
    public List<SemesterYear> findSemesterYear(){
        List<SemesterYear> findSemesterYear = adminRepository.findAllSemester();
        return findSemesterYear;
    }

    public String deleteById(int id){
        studentLecturerRepository.

    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean saveLecturerStudent(List<String> studentIds,String lecturerId,String moudleId,String syId){
        try {
            studentIds.forEach(studentid -> {
                StudentLecturer studentLecturer = new StudentLecturer();
                studentLecturer.setStudentId(studentid);
                studentLecturer.setLecturerId(lecturerId);
                studentLecturerRepository.save(studentLecturer);
            });

            studentIds.forEach(studentid -> {
                Grade grade = new Grade();
                grade.setId(UUID.randomUUID().toString());
                grade.setMoudleId(moudleId);
                grade.setSemesterYearId(syId);
                grade.setGrade(100);
                grade.setStudentId(studentid);
                gradeRepository.save(grade);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}