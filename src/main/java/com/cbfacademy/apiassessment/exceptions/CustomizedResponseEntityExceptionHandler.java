package com.cbfacademy.apiassessment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import com.cbfacademy.apiassessment.model.ErrorDetails;

/**
 * Customized error response structure
 */
@ControllerAdvice //Applicable to all controller
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * handle all exceptions.
     * @param ex
     * @param request
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Customized the error response structure for the user not found exception to return a status code 404 not found. 
     * @param ex
     * @param request
     * @return
     * @throws UserNotFoundException
     */
    @ExceptionHandler(value = UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
            throws UserNotFoundException {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Customized the error response structure for the user age bad range exception to return a status code 400 bad request.
     * @param ex
     * @param request
     * @return
     * @throws AgeBadRangeException
     */
    @ExceptionHandler(value = AgeBadRangeException.class)
    public final ResponseEntity<ErrorDetails> handleAgeBadRangeException(AgeBadRangeException ex, WebRequest request)
            throws AgeBadRangeException {

        System.out.println(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * Customized the error response structure for the user bad email exception to return a status code 400 bad request.
     * @param ex
     * @param request
     * @return
     * @throws BadEmailAddressException
     */
    @ExceptionHandler(value = BadEmailAddressException.class)
    public final ResponseEntity<ErrorDetails> handleEmailAddressExceptionException(BadEmailAddressException ex, WebRequest request)
            throws BadEmailAddressException {

        System.out.println(ex.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
