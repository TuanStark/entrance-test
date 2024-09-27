package com.example.ENTRANCE.TEST.helpper.base.response.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseType {
    private int code ;
    private String message;
}