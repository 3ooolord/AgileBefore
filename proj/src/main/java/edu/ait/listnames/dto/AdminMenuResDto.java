package edu.ait.listnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMenuResDto {
    private int moudleId;//学科id
    private int semesterYearId;//学期学年id
    private Integer startYear;//开始学年
    private Integer endYear;//结束学年
    private Integer semester;//学期
    private String moudleName;//学科名称
}
