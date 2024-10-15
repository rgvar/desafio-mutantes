package com.desarrollosoftware.mutantes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String errorClass;
    private String errorMsg;
    private String errorDate;
}
