package edu.ait.utils;

import java.io.Serializable;


public class ErrorCode implements Serializable {
    private static final long serialVersionUID = -7767059598469242922L;
    private static final ErrorCode success = new ErrorCode("common", Integer.valueOf(0));
    private String category;
    private Object code;
    private String[] args;
    private String message;
    private String retcode;
    

    public ErrorCode() {
        this.category = "default";
        this.code = "";
    }

    public ErrorCode(Object code) {
        this();
        this.code = code;
    }

    public ErrorCode(String category, Object code) {
        this(code);
        this.category = category;
    }



    public String getRetcode() {

        return this.retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }


    public void setCode(Object code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
       
    }
   
}
