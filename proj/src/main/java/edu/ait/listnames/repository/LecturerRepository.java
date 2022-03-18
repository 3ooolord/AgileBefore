package edu.ait.listnames.repository;

import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.dto.Lecturer;
import edu.ait.listnames.dto.LecturerGradeResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, String>,
        JpaSpecificationExecutor<Lecturer> {

    /**
     * 导师端菜单列表 Lecturer menu list
     * @param id
     * @return
     */
    @Query(value =" SELECT new edu.ait.listnames.dto.LectureMenuResDto(lm.moudleId, lm.semesterYearId, m.moudleName, sy.startYear, sy.endYear, sy.semester)  FROM LecturerMoudle lm " +
            "LEFT JOIN Moudle m ON lm.moudleId = m.id LEFT JOIN SemesterYear sy ON sy.id = lm.semesterYearId WHERE lm.lecturerId = :id ")
    Page<LectureMenuResDto> findMenu(@Param("id") String id, Pageable pageable);

    /**
     * @description: //TODO 导师端查询学生成绩 lecturer search for student grade
     * @param:
     * @return:
     **/
    @Query(value = " select new edu.ait.listnames.dto.LecturerGradeResDto(s.id,s.name,g.grade,g.id,g.semesterYearId,g.moudleId) from " +
            "Grade g left join Student s on s.id = g.studentId where g.semesterYearId = :semesterId and g.moudleId = :moudleId")
    List<LecturerGradeResDto> findGrade(@Param("moudleId") String moudleId, @Param("semesterId") String semesterId);




    /**
     * @description: //TODO 老师登陆  lecturer login
     * @param:
     * @return:
     **/
    @Query(value = "select s from Lecturer s where s.userName = :userName and s.password = :password")
    Lecturer login(@Param("userName") String userName,@Param("password")String password);
}
