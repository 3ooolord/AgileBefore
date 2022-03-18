package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreDto {
    private int studentId;

    private String moudleName;

    private Integer grade;

}
