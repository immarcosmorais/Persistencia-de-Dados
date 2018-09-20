/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author marcos
 */
public class LerArquivoCSV {

    public static void main(String[] args) throws IOException {
        LerArquivoCSV ler = new LerArquivoCSV();
        ler.executar();
    }

    private void executar() throws FileNotFoundException, IOException {
        String arquivo = "/home/marcos/Downloads/Persistência/transacoes.csv";
        BufferedReader br = null;
        String linha = "";
        String divisor = ",";
        br = new BufferedReader(new FileReader(arquivo));
        double vendas = 0;
        boolean flag = false;
        while ((linha = br.readLine()) != null) {
            String[] transacao = linha.split(divisor);
            System.out.println("Rua: " + transacao[0] + " Cidade: " + transacao[1]);
        }
        System.out.print("Total de vendas: " + vendas);

    }

}
