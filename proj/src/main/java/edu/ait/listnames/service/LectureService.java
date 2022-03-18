package edu.ait.listnames.service;

import edu.ait.listnames.dto.LectureMenuResDto;
import edu.ait.listnames.dto.LecturerGradeResDto;
import edu.ait.listnames.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LecturerRepository lecturerRepository;

    /**
     * 分页查询导师端菜单列表 pageResult  return list of param
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<LectureMenuResDto> findMenu(String id){
        Pageable pageable = PageRequest.of(0,5);
        Page<LectureMenuResDto> page = lecturerRepository.findMenu(id,pageable);
        List<LectureMenuResDto> menuList = page.getContent();
        return menuList;
    }

    /**
     * @description: //TODO 分页查询教师端学生成绩 return students grade
     * @param: [id]
     * @return: java.util.List<edu.ait.listnames.dto.LectureMenuResDto>
     **/
    @Transactional(propagation = Propagation.REQUIRED)
    public List<LecturerGradeResDto> findGrade(String moudleId,String semesterId){
        Pageable pageable = PageRequest.of(0,10);
        List<LecturerGradeResDto> gradeList = lecturerRepository.findGrade(moudleId,semesterId);
        return gradeList;
    }
}
