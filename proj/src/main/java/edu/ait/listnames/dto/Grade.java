package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "grade")
@DynamicUpdate
@NamedQuery(name = "Grade.findAll", query = "SELECT s FROM Grade s ")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Grade implements Serializable {

    private static final long serialVersionUID = -7819843800572603746L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "student_id")
    private int studentId;//学生id
    @NotNull
    @Column(name = "moudle_id")
    private int moudleId;//学科id
    @NotNull
    @Column(name = "semester_year_id")
    private int semesterYearId;//学期学年id
    @Min(0)
    @Max(100)
    @Column(name = "grade")
    private Integer grade;//成绩


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getMoudleId() {
        return moudleId;
    }

    public void setMoudleId(int moudleId) {
        this.moudleId = moudleId;
    }

    public int getSemesterYearId() {
        return semesterYearId;
    }

    public void setSemesterYearId(int semesterYearId) {
        this.semesterYearId = semesterYearId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
