package com.app.sharedcalendar.exception;


import com.app.sharedcalendar.model.ErrorCode;
import lombok.Getter;


@Getter

public class FollowException extends RuntimeException{
    private final ErrorCode errorCode;

    public FollowException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
