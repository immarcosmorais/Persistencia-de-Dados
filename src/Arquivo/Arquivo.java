/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author marcos
 * @param <T>
 */
public class Arquivo<T> {

//    public static ArrayList Recuperar(String caminho) throws FileNotFoundException, IOException, ClassNotFoundException {
//        File file = new File(caminho);
//        file.createNewFile();
//        FileInputStream restFile = new FileInputStream(file);
//        ArrayList<Cliente> obj;
//        try (ObjectInputStream stream = new ObjectInputStream(restFile)) {
//            obj = (ArrayList<Cliente>) stream.readObject();
//        }
//        return obj;
//    }
//
//    public static void Gravar(String caminho, ArrayList obj) throws FileNotFoundException, IOException {
//        File file = new File(caminho);
//        file.createNewFile();
//        FileOutputStream saveFile = new FileOutputStream(file);
//        try (ObjectOutputStream stream = new ObjectOutputStream(saveFile)) {
//            stream.writeObject(obj);
//        }
//    }
    
    private final FileInputStream fileInputStream;
    private final ObjectInputStream inputStream;
    private final FileOutputStream fileOutputStream;
    private final ObjectOutputStream objectOutputStream;
    private final File file;

    public Arquivo(String path) throws IOException {
        this.file = new File(path);
        if (file.exists()) {
            this.file.createNewFile();
        }
        this.fileInputStream = new FileInputStream(file);
        this.inputStream = new ObjectInputStream(fileInputStream);
        this.fileOutputStream = new FileOutputStream(file);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }
    
//    Gravar
    
//    Recuperar
}
