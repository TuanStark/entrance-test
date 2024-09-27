package com.example.ENTRANCE.TEST.helpper.base.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseObject <T> {
    private String message;
    private int code;
    private T data;
}