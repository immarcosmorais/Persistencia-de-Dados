/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.trabalho15Set;

import csv.CSVUtils;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class App {

    /**
     * Exercicio 1 Escreva um programa que classifique por magnitude (mag) as 10
     * primeiras estrelas do catálogo (com exceção do sol) e imprima seus dados
     * na tela.
     *
     * @param catalogo
     */
    public static void classificaMagnetude(ArrayList<String[]> catalogo) {
        ArrayList<String[]> lista = new ArrayList<>();
        lista.add(catalogo.get(0));
        catalogo.remove(0);
        for (String[] c : catalogo) {
            if (!c[6].equals("Sol")) {
                lista.add(c);
            }
            if (lista.size() == 11) {
                break;
            }
        }
        imprime(lista);
    }

    /**
     * Escreva um programa que crie um arquivo CSV contendo apenas os dados das
     * estrelas visíveisa olho nu (mag < 6.5)
     *
     * @param catalogo
     */
    private static void estrelasVisiveis(ArrayList<String[]> catalogo) throws IOException {
        FileWriter writer = new FileWriter("exercicio2.csv");
        CSVUtils.writeLine(writer, Arrays.asList(catalogo.get(0)));
        catalogo.remove(0);
        for (String[] c : catalogo) {
            if (Float.parseFloat(c[13]) < 6.5) {
                CSVUtils.writeLine(writer, Arrays.asList(c));
            }
        }
        writer.flush();
        writer.close();
    }

    private static void imprime(ArrayList<String[]> lista) {

        for (String[] l : lista) {
            System.out.print("[");
            for (String l1 : l) {
                System.out.print(String.format("%-20.20s", l1));
            }
            System.out.println("]");
        }
        System.out.println("");
    }

    /**
     * Mostre na tela as dez estrelas mais próximas da Terra (use o campo dist)
     *
     * @param catalogo
     */
    private static void estrelasMaisProximas(ArrayList<String[]> catalogo) {
        ArrayList<String[]> lista = new ArrayList<>();
        lista.add(catalogo.get(0));
        lista.add(catalogo.get(1));
        catalogo.remove(0);
        for (String[] c : catalogo) {
            for (int i = 1; i < lista.size(); i++) {
                if (Float.parseFloat(lista.get(i)[9]) < Float.parseFloat(c[9])) {
                    lista.add(i, c);
                    break;
                }
            }
            if (lista.size() == 11) {
                break;
            }
        }
        imprime(lista);

    }

    /**
     * Escreva um programa que permita pesquisar estrelas no catálogo HYG
     * através da constelação(campo con)
     *
     * @param catalogo
     * @param constelacao
     */
    private static void pesquisaConstelacao(ArrayList<String[]> catalogo, String constelacao) {

        ArrayList<String[]> lista = new ArrayList<>();
        lista.add(catalogo.get(0));
        catalogo.remove(0);
        //29
        for (String[] c : catalogo) {
            if (c[29].equalsIgnoreCase(constelacao)) {
                lista.add(c);
            }
        }
        imprime(lista);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String[]> catalogo = CSVUtils.readFile("../Persistencia/src/csv/trabalho15Set/arquivos/hygdata_v3.csv");
        classificaMagnetude(catalogo);
        estrelasVisiveis(catalogo);
        estrelasMaisProximas(catalogo);
        String constelacao;
        Scanner sc = new Scanner(System.in);
        System.out.print("Constelacao: ");
        constelacao = sc.next();
        pesquisaConstelacao(catalogo, constelacao);
        escorpiao(catalogo);
    }

    /**
     * Escreva um programa que imprima na tela os dados da estrela mais
     * brilhante (menor absmag) da constelação de escorpião (sco no campo con)
     *
     * @param catalogo
     */
    private static void escorpiao(ArrayList<String[]> catalogo) {
        ArrayList<String[]> lista = new ArrayList<>();
        lista.add(catalogo.get(0));
        catalogo.remove(0);
        String[] dados = catalogo.get(1);
        //29
        for (String[] c : catalogo) {
            //14
            if (c[29].equalsIgnoreCase("sco")) {
                if (Float.parseFloat(c[14]) < Float.parseFloat(dados[14])) {
                    dados = c;
                }
            }
        }
        lista.add(dados);
        imprime(lista);
    }

}
