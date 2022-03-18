package edu.ait.listnames;

import edu.ait.listnames.dto.*;
import edu.ait.listnames.repository.*;
import edu.ait.listnames.service.AdminService;
import edu.ait.listnames.service.LectureService;
import edu.ait.listnames.service.LoginService;
import edu.ait.listnames.service.StudentService;
import edu.ait.listnames.token.TokenDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ListnamesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private StudentLecturerRepository studentLecturerRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private LecturerRepository lecturerRepository;
	@Autowired
	private StudentRepository studentRepository;


	@Autowired
	private AdminService adminService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private StudentService studentService;

	@Test
	public void testAdminService(){
		List<AdminMenuResDto> adminMenuResDtos= adminService.findMenu();
		List<Student> students = adminService.findAllStudent("1");
		List<Lecturer> lecturers= adminService.findAlllecturer();
		List<SemesterYear> semesterYears = adminService.findSemesterYear();

		if (adminMenuResDtos!=null&&students!=null&&lecturers!=null&&semesterYears!=null){
			System.out.println("test AdminService Success");
		}else System.out.println( "test AdminService Fail");
	}

	@Test
	public void testLoginService(){
		TokenDto adminToken = loginService.adminLogin("a1","1");
		TokenDto studentToken = loginService.studentLogin("s1","1");
		TokenDto lecturerToken = loginService.lecturerLogin("l1","1");
		if (adminToken!=null&&studentToken!=null&&lecturerToken!=null){
			System.out.println("test LoginService success!");
		}
	}

	@Test
	public void testLecturerService(){
		List<LectureMenuResDto> lectureMenuResDtos=lectureService.findMenu("1");
		List<LecturerGradeResDto> lecturerGradeResDtos=lectureService.findGrade("1","1");
		if (lectureMenuResDtos!=null&&lecturerGradeResDtos!=null){
			System.out.println(lectureMenuResDtos.toString());
			System.out.println("test lecturerService success");
		}
	}

	@Test
	public void testStudentService(){
		List<StudentMenuRespDto> menuList =studentService.findMenu("1");
		SemesterYear semesterYear = new SemesterYear();
		semesterYear.setId("1");
		semesterYear.setEndYear(2021);
		semesterYear.setSemester(1);
		semesterYear.setStartYear(2020);
		List<StudentScoreDto> studentScoreDtos = studentService.findScore(semesterYear,"1");
		if (menuList!=null&&studentScoreDtos!=null){
			System.out.println("test StudentService success");
		}
	}

}
