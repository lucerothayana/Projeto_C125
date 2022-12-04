package Objetos;
import java.util.*;

abstract class Mensagem {
    List <String> msg =  new ArrayList<>();

    public Mensagem(List<String> msg) {
        this.msg = msg;
    }

    abstract void mostrarMsg();
}
