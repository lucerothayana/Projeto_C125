import Objetos.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Entre com nome do arquivo (e nao se esqueca do .txt): ");
        String nomeArquivo = ler.nextLine();

        Path arquivo = Paths.get(nomeArquivo);
        List<String> listaQuebrada = new ArrayList<>();

        try {
            List<String> listaInteira = Files.readAllLines(arquivo);

            listaInteira.forEach((bitizinho) ->{
               String[] parteLista = bitizinho.split(" ");
               for(int i=0; i< parteLista.length;i++){
                   listaQuebrada.add(i,parteLista[i]);
               }
           });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            MensagemBinario mensagem = new MensagemBinario(listaQuebrada);

            mensagem.mostrarMsg();

            List<String> mensagemSemRuido = mensagem.cortadorDeRuido();

            MensagemTXT mensagemConvertida = new MensagemTXT(mensagemSemRuido);

            List <String> mensagemEscrever = mensagemConvertida.converteTXT();

            mensagemConvertida.mostrarMsg();

        Path arquivoConvertido = Paths.get("textoConvertido.txt");

        try {
            Files.write(arquivoConvertido,mensagemEscrever);
        } catch (IOException e) {
            System.out.println("Nao foi possivel criar o arquivo :(");
            throw new RuntimeException(e);
        }


    }
}
