package edu.ait.listnames.service;

import edu.ait.listnames.dto.Admin;
import edu.ait.listnames.dto.Lecturer;
import edu.ait.listnames.dto.Student;
import edu.ait.listnames.repository.AdminRepository;
import edu.ait.listnames.repository.LecturerRepository;
import edu.ait.listnames.repository.StudentRepository;
import edu.ait.listnames.token.TokenDto;
import edu.ait.listnames.token.TokenThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private AdminRepository adminRepository;

    public TokenDto adminLogin(String userName, String password) {

        // 管理员表表查询 用户名  密码一样的 获得 admin 对象       admin login check
        Admin admin = adminRepository.login(userName, password);
        if (admin != null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setType(2);
            tokenDto.setUserId(admin.getId());
            TokenThreadLocal.put(tokenDto);
            return tokenDto;
        }
        // 如果都查不到 用户名密码错误 if null,return null;
        return null;
    }
    public TokenDto studentLogin(String userName, String password){
        // 学生表查询 用户名  密码一样的 获得 Student 对象     student login check
        Student student = studentRepository.login(userName,password);
        if (student != null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setType(1);
            tokenDto.setUserId(student.getId());
            TokenThreadLocal.put(tokenDto);
            return tokenDto;
        }
        return null;
    }
    public TokenDto lecturerLogin(String userName, String password){
        // 老师表查询 用户名  密码一样的 获得 teacher 对象     lecturer login check
        Lecturer lecturer = lecturerRepository.login(userName, password);
        if (lecturer != null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setType(3);
            tokenDto.setUserId(lecturer.getId());
            TokenThreadLocal.put(tokenDto);
            return tokenDto;
        }
        return null;
    }


}