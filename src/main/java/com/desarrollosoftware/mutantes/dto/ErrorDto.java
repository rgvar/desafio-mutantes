package com.desarrollosoftware.mutantes.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private String errorClass;
    private String errorMsg;
    private String errorDate;
}
