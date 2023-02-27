package finalcase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResult {
    private HttpStatus statusCode;
    private String message;
    private String path;
    private ZonedDateTime dateTime;
}
