package com.dev.simples.healthcare.api;

import com.dev.simples.healthcare.dto.ErrorDTO;
import com.dev.simples.healthcare.exception.ConflictException;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorDTO handleConflictException(ConflictException exception) {
        return new ErrorDTO().setMessage(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDTO handleNotFoundException(NotFoundException exception) {
        return new ErrorDTO().setMessage(exception.getMessage());
    }

}
