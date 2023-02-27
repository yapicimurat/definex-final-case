package finalcase.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ExceptionResult> entityNotFoundException(NotFoundException notFoundException,
                                                                   HttpServletRequest request){
        return ResponseEntity.ok()
                .body(new ExceptionResult(HttpStatus.NOT_FOUND, notFoundException.getMessage(),
                        request.getServletPath(), ZonedDateTime.now()));
    }

}
