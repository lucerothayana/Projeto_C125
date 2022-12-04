package Exceptions;

public class MensagemInvalida extends RuntimeException {
    public MensagemInvalida(String message){
        super(message);
    }
}
