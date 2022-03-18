package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerGradeResDto {
    private int id;
    private String name;
    private Integer grade;
    private int gradeId;
    private int semesterYearId;
    private int moudleId;
}
