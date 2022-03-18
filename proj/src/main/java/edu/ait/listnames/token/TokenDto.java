package edu.ait.listnames.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto{
    public String userId;
    /**
     * 1 学生 2 管理员 3老师    1.student  2.admin  3.lecturer
     */
    public Integer type;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
