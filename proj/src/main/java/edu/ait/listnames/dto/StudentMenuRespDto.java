package edu.ait.listnames.dto;

import lombok.Data;


@Data
public class StudentMenuRespDto {
    private int semesterYearId;//学期学年id
    private Integer startYear;//开始学年
    private Integer endYear;//结束学年
    private Integer semester;//学期

    public StudentMenuRespDto(int semesterYearId, Integer startYear, Integer endYear, Integer semester) {
        this.semesterYearId = semesterYearId;
        this.startYear = startYear;
        this.endYear = endYear;
        this.semester = semester;
    }
}
