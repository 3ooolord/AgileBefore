package edu.ait.listnames.service;

import edu.ait.listnames.dto.SemesterYear;
import edu.ait.listnames.dto.StudentMenuRespDto;
import edu.ait.listnames.dto.StudentScoreDto;
import edu.ait.listnames.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<StudentMenuRespDto> findMenu(String id){
        List<StudentMenuRespDto> menuList = new ArrayList<>();
        menuList = studentRepository.findMenu(id);
        return menuList;
    }

    public List<StudentScoreDto> findScore(SemesterYear semesterYear, String userId) {
        return Optional.ofNullable(studentRepository.findScore(semesterYear.getId(),userId)).orElse(new ArrayList());
    }

    public List<SemesterYear> findSemesterYear() {
        List<SemesterYear> findSemesterYear = studentRepository.findSemesterYear();
        return findSemesterYear;
    }
}
