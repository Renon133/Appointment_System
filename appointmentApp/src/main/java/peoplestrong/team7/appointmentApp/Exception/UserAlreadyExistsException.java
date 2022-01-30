package peoplestrong.team7.appointmentApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND)
public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message); 
    }
}
