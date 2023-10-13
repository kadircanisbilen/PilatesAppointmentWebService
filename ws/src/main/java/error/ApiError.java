package error;

import com.pilatesappointment.ws.enumeration.ValidationMessages;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class ApiError {

    private int status;
    private String message;
    private String path;
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErrors = new HashMap<>();

    public static ResponseEntity<ApiError> fillApiErrorAndReturnDetails(String validationErrorsField, String validationErrorsMessage, String path, int status ) {
        ApiError apiError = new ApiError();
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put(validationErrorsField, validationErrorsMessage);
        apiError.setValidationErrors(validationErrors);
        apiError.setPath(path);
        apiError.setMessage(ValidationMessages.VALIDATION_ERROR.getMessage());
        apiError.setStatus(status);
        return ResponseEntity.badRequest().body(apiError);
    }
}
