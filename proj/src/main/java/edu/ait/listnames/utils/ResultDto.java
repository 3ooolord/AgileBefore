package edu.ait.listnames.utils;

import java.io.Serializable;


public class ResultDto implements Serializable {

    private static final long serialVersionUID = 2280956042237457720L;
    private Integer code;
    private String message;
    private Object data;

    public ResultDto() {

    }

    public ResultDto(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
