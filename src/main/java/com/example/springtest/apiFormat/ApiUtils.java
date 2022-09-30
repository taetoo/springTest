package com.example.springtest.apiFormat;

public class ApiUtils {
    public static <T>ApiResult<T> success(T result) {
        return new ApiResult<>(true, result, null);
    }

    public static ApiResult<?> error(String message, int status){
        return new ApiResult<>(false, new ApiError(message, status),null);
    }
}