package Objetos;

import Exceptions.MensagemInvalida;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MensagemBinario extends Mensagem{

    int nr;
    public MensagemBinario(List<String> msg) {
        super(msg);
    }

    @Override
    public void mostrarMsg(){
        System.out.print("Mensagem em  Binario: ");
        for(int i=0; i< msg.size(); i++){
            System.out.print(msg.get(i) + " ");
        }
        System.out.print("\n");
    }
    public List<String> cortadorDeRuido(){
        List<String> mensagemSemRuido = new ArrayList<>();

        int nr = Integer.parseInt(msg.get(0));
        int cont0 = 0;
        int cont1 = 0;
        int contBit = 0;
        for (int i=1; i<msg.size(); i++){
            contBit++;
            if(Objects.equals(msg.get(i), "0"))
                cont0++;
            else if(Objects.equals(msg.get(i), "1")) {
                cont1++;
            }
            else{
                throw new MensagemInvalida("Mensagem nao eh binario!  :(");
            }
            if(contBit==nr){
                if(cont0>cont1){
                    mensagemSemRuido.add("0");
                }
                else mensagemSemRuido.add("1");
                contBit=0;
                cont0=0;
                cont1=0;
            }
        }
        System.out.print("\nMensagem sem ruido: ");
        for(int i=0; i< mensagemSemRuido.size(); i++){
            System.out.print(mensagemSemRuido.get(i));
        }
        return mensagemSemRuido;
    }
}
