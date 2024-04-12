package ru.greenatom.forum.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.greenatom.forum.exception.NotFoundException;

@RestControllerAdvice(assignableTypes = {
        TopicController.class,
        MessageController.class
})
@Slf4j
public class ErrorHandlerController {
    @ExceptionHandler({
            IllegalArgumentException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MyError handleBadRequest(final Exception e) {
        log.error(e.getMessage());
        return new MyError(e.getMessage());
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MyError handleNotValidRequest(final Exception e) {
        log.error(e.getMessage());
        return new MyError(e.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MyError handleNotFound(final Exception e) {
        log.error(e.getMessage());
        return new MyError(e.getMessage());
    }

    @ExceptionHandler({
            Exception.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MyError handleAllError(final Throwable e) {
        log.error(e.getMessage());
        return new MyError(e.getMessage());
    }

    @Getter
    public static class MyError {
        private String message;

        public MyError(String message) {
            this.message = message.substring(message.indexOf(":") + 1).trim();
        }
    }
}
