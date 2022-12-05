package org.example.utils;

import java.io.*;
import java.util.ArrayList;

public class FileManager<T> {
    private final String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveToFile(ArrayList<T> objects) {
        try {
            FileOutputStream f = new FileOutputStream(filePath);
            ObjectOutputStream o = new ObjectOutputStream(f);

            objects.forEach(object -> {
                try {
                    o.writeObject(object);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public ArrayList<T> readFile() {
        var objectList = new ArrayList<T>();

        try {
            FileInputStream fi = new FileInputStream(filePath);
            ObjectInputStream oi = new ObjectInputStream(fi);

            T o;
            for (;;) {
                try {
                    o = (T) oi.readObject();
                    objectList.add(o);
                }
                catch (EOFException e) {
                    break;
                }
            }

            oi.close();
            fi.close();

            return objectList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
