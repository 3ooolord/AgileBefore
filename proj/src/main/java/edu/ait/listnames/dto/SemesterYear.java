package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "semester_year")
@DynamicUpdate
@NamedQuery(name = "SemesterYear.findAll", query = "SELECT s FROM SemesterYear s")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class SemesterYear implements Serializable {



    private static final long serialVersionUID = -4517819210222136913L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "start_year")
    private Integer startYear;//开始学年
    @NotNull
    @Column(name = "end_year")
    private Integer endYear;//结束学年
    @NotNull
    @Column(name = "semester")
    private Integer semester;//学期

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
