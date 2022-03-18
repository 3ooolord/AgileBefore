package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 导师段菜单列表出参实体（顺序必须和hql中查询结果一致） entity to Lecture's function(findmenu)  (the sort must same with hql search list)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureMenuResDto {
    private int moudleId;//学科id
    private int semesterYearId;//学期学年id
    private int moudleName;//学科名称
    private Integer startYear;//开始学年
    private Integer endYear;//结束学年
    private Integer semester;//学期
}
