package cn.gl.librarymanagementsystem.result;

import lombok.Data;

@Data
public class Result<E> {

    private Status status;

    private String description;

    private E data;


}
