package edu.ait.listnames.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "admin")
@DynamicUpdate
@NamedQuery(name = "Admin.findAll", query = "SELECT s FROM Admin s ")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = 9187606894071002939L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;//姓名

    @NotNull
    @Column(name = "user_name")
    private String userName;//用户名
    @NotNull
    @Column(name = "password")
    private String password;//密码

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
