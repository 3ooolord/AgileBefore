package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "moudle")
@DynamicUpdate
@NamedQuery(name = "Moudle.findAll", query = "SELECT s FROM Moudle s ")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Moudle implements Serializable {

    private static final long serialVersionUID = -4432884085781947011L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "moudle_name")
    private String moudleName;//学科名称
    @NotNull
    @Column(name = "moudle_id")
    private int moudleId;//学科id
}
