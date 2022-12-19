package Exceptions;

public class NegativeCurrencyException extends Exception{
    @Override
    public String getMessage(){
        return "You don't have enough money(";
    }
}
