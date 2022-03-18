package edu.ait.listnames.repository;

import edu.ait.listnames.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer>,
        JpaSpecificationExecutor<Admin> {
// return m.id,sy.id,sy.startYear,sy.endYear,sy.semester,m.moudleName
    @Query(value = "select new edu.ait.listnames.dto.AdminMenuResDto(m.id,sy.id,sy.startYear,sy.endYear,sy.semester,m.moudleName) from SemesterYear sy " +
            "left join SemesterYearMoudle sym ON sy.id = sym.semesterYearId left join Moudle m ON m.id = sym.moudleId")
    Page<AdminMenuResDto> findMenu(Pageable pageable);
//return  s.id,s.name,s.userName,s.password
    @Query(value = "select new edu.ait.listnames.dto.Student(s.id,s.name,s.userName,s.password)" +
            "from Student s left join StudentLecturer sl on s.id = sl.studentId where sl.lecturerId in" +
            "(select  le.id from Lecturer le join LecturerMoudle lm on lm.lecturerId = le.id where  lm.moudleId = :moudleId ) " )
    List<Student> findStudentIdList(@Param("moudleId") int moudleId);
//return student list
    @Query(value = "select s from Student s" )
    List<Student> findAllStudent();
//return student
    @Query(value = "select s from Admin s where s.userName = :userName and s.password = :password")
    Admin login(@Param("userName") String userName,@Param("password")String password);
//return lecturer list
    @Query(value = "select l from Lecturer l")
    List<Lecturer> findAllLecturer();
//return semester list
    @Query(value = "select sy from SemesterYear sy")
    List<SemesterYear> findAllSemester();

}
