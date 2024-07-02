package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class GenericResponse {
    private int code;

    private String status;
    private String message;
    private Object object;
    private Object payLoad;
    private List<Object> list;

    public GenericResponse(int value, String message) {
        this.code = value;
        this.message = message;
    }

    public GenericResponse(Object payLoad) {
        this.payLoad = payLoad;
    }



    public GenericResponse(int code, List<Object> list) {
        this.code = code;
        this.list=list;
    }
    public GenericResponse(int code, String message, Object payLoad) {
        this.code = code;
        this.message = message;
        this.payLoad = payLoad;
    }

    public GenericResponse(int value, Object response) {
        this.code = value;
        this.payLoad = response;
    }

}
