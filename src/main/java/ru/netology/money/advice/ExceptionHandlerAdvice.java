package ru.netology.money.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.money.ErrorConfirmation;
import ru.netology.money.ErrorInputData;
import ru.netology.money.ErrorTransfer;

@RestControllerAdvice

public class ExceptionHandlerAdvice {

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<String> eidHandler(ErrorInputData e){
        return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<String> etHandler(ErrorTransfer e){
        return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<String> etHandler(ErrorConfirmation e){
        return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
