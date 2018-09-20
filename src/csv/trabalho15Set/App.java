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
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> catalogo = CSVUtils.readFile("../Persistencia/src/csv/trabalho15Set/arquivos/hygdata_v3.csv");
//        classificaMagnetude(catalogo);
//        estrelasVisiveis(catalogo);
    }
}
