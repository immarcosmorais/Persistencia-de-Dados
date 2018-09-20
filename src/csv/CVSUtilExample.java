/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author marcos
 */
public class CVSUtilExample {

    public static void main(String[] args) throws Exception {

        String csvFile = "/home/marcos/Desktop/clientes.csv";
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, Arrays.asList("a", "b", "c", "d"));

        //custom separator + quote
        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bb,b", "cc,c"), ',', '"');

//        //custom separator + quote
        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bbb", "cc,c"), '|', '\'');
//
//        //double-quotes
        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bbb", "cc\"c"));
        CSVUtils.writeLine(writer, Arrays.asList("111", "bbb", "cc\"c"));


        writer.flush();
        writer.close();

    }

}