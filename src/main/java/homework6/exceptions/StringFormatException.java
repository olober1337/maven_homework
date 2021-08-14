package homework6.exceptions;

public class StringFormatException extends Exception{
    public StringFormatException(String string) {
        super("This input is incorrect! Please check your input.");
    }
}
