package ru.greenatom.forum.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.greenatom.forum.exception.NotFoundException;

@RestControllerAdvice(assignableTypes = {
        ForumController.class,
        MessageController.class
}
)
public class ErrorHandlerController {
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            IllegalArgumentException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MyError handleBadRequest(final Exception e) {
        return new MyError(e.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MyError handleNotFound(final Exception e) {
        return new MyError(e.getMessage());
    }

    @ExceptionHandler({
            Exception.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MyError handleAllError(final Throwable e) {
        return new MyError(e.getMessage());
    }

    @Getter
    @AllArgsConstructor
    public static class MyError {
        private String message;
    }
}
