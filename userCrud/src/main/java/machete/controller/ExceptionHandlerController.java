package machete.controller;

import machete.domain.ErrorResponse;
import machete.exception.UserValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {UserValidationException.class})
  protected ResponseEntity<ErrorResponse> handleUserValidationError(UserValidationException ex,
      WebRequest request) {
    var error = new ErrorResponse()
        .message(ex.getMessage());

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
