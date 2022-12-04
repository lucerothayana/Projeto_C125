package Objetos;
import Interfaces.Conversor;
import java.util.*;
public class MensagemTXT extends  Mensagem implements Conversor {
    public MensagemTXT(List<String> msg) {
        super(msg);
    }
    List <String> listaTXT = new ArrayList<>();


    @Override
    public void mostrarMsg() {
        System.out.print("\nMensagem em  Texto: ");
        for(int i=0; i< listaTXT.size(); i++){
            System.out.print(listaTXT.get(i));
        }
    }

    @Override
    public List<String> converteTXT() {
        int bit=7;
        int letra=0;
        String caracter;


        for(int i =0; i< this.msg.size(); i++){
            if(Objects.equals(this.msg.get(i), "1")) {
                letra += Math.pow(2,bit);
            }
            if(bit==0){
                caracter = Character.toString((char) letra);
                listaTXT.add(caracter);
                bit=7;
                letra=0;
            }
            else bit--;
        }
        return listaTXT;
    }
}
