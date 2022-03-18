package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "student_lecturer")
@DynamicUpdate
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class StudentLecturer implements Serializable {

    private static final long serialVersionUID = 6253859932593621349L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "student_id")
    private int studentId;//学生id
    @NotNull
    @Column(name = "lecturer_id")
    private int lecturerId;//导师id

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

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }
}