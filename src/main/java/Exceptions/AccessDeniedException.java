package Exceptions;

public class AccessDeniedException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Unauthorised access!";
    }
}
