package com.kairoboni.stopbot.app.dependencies.exeptions.http;

import com.kairoboni.stopbot.app.dependencies.exeptions.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InternalServerErrorException.class)
    public final ResponseEntity<BaseException> handleInternalServerError(WebRequest request) {
        BaseException baseException = new BaseException(
                new Date(),
                "Internal Server Error",
                request.getDescription(false)
        );

        return new ResponseEntity<>(baseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public final ResponseEntity<BaseException> handleUnprocessableEntity(WebRequest request) {
        BaseException baseException = new BaseException(
                new Date(),
                "Unprocessable Entity",
                request.getDescription(false)
        );

        return new ResponseEntity<>(baseException, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<BaseException> handleBadRequest(WebRequest request) {
        BaseException baseException = new BaseException(
                new Date(),
                "Bad Request",
                request.getDescription(false)
        );

        return new ResponseEntity<>(baseException, HttpStatus.BAD_REQUEST);
    }
}
