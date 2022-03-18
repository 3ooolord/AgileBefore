package edu.ait.listnames.repository;

import edu.ait.listnames.dto.SemesterYear;
import edu.ait.listnames.dto.Student;
import edu.ait.listnames.dto.StudentMenuRespDto;
import edu.ait.listnames.dto.StudentScoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String>,
        JpaSpecificationExecutor<Student> {

    /**
     * @description: //TODO 查询学生页面左边菜单栏 search student list left
     * @param:
     * @return:
     **/
    @Query(value ="select new edu.ait.listnames.dto.StudentMenuRespDto(sy.id, sy.startYear, sy.endYear, sy.semester) " +
            "from Grade g left join SemesterYear sy on sy.id = g.semesterYearId where g.studentId = :id ")
    List<StudentMenuRespDto> findMenu(@Param("id") String id);

    /**
     * 学生成绩  student grade
     * @param semesterYearId
     * @param userId
     * @return
     */
    @Query(value = "select new edu.ait.listnames.dto.StudentScoreDto(g.studentId,m.moudleName,g.grade)" +
            "from Grade g left join Moudle m on m.moudleId = g.moudleId where g.studentId = :id " +
            "and g.semesterYearId = :semesterYearId")
    List<StudentScoreDto> findScore(@Param("semesterYearId") String semesterYearId, @Param("id") String userId);


    /**
     * @description: //TODO 学生登陆   student login
     * @param:
     * @return:
     **/
    @Query(value = "select s from Student s where s.userName = :userName and s.password = :password")
    Student login(@Param("userName") String userName,@Param("password")String password);


    @Query(value = "select sy from SemesterYear sy")
    List<SemesterYear> findSemesterYear();
}
