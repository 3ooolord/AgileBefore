package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "lecturer_moudle")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class LecturerMoudle implements Serializable {

    private static final long serialVersionUID = -3526184792582508553L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "lecturer_id")
    private String lecturerId;//导师id
    @NotNull
    @Column(name = "moudle_id")
    private String moudleId;//学科id
    @NotNull
    @Column(name = "semester_year_id")
    private String semesterYearId;//学期学年id
}
