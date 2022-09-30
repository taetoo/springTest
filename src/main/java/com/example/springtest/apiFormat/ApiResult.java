package com.example.springtest.apiFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResult<T>{
    private final boolean success;
    private final T result;
    private final ApiError Error;
    public ApiResult(boolean success, T result, ApiError Error) {
        this.success = success;
        this.result = result;
        this.Error = Error;
    }
}