package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "semester_year_moudle")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class SemesterYearMoudle implements Serializable {

    private static final long serialVersionUID = 6153684345618738134L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "semester_year_id")
    private int semesterYearId;//学期学年id
    @NotNull
    @Column(name = "moudle_id")
    private int moudleId;//学科id
}
