package org.KFU;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    static ArrayList<String> result = new ArrayList<String>();
    static String file;
    public static void main(String[] args )
    {
        /*
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new  BufferedWriter(new FileWriter(args[1])))
        {
            while (reader.ready())
            {
                String str = reader.readLine();
                writer.write(str);
                if (reader.ready()) {
                    writer.newLine();
                }
            }

        } catch (IOException e)
        {
        }*/
        file = args[1];
        try {
            Files.lines(Paths.get(args[0]))
                    .map(Metods::conversion)
                    .map(Metods::registrVniz)
                    //.forEach(System.out::println);
                    .map(Metods::registrVverx)
                    //.map(Metods::collichSymbol)
                    .forEach(App::writeToFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String text) {
        try {
            result.add(text);
            Files.write(Paths.get(file), result, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        int n =10;
        try {
            n = Integer.parseInt(args[0]);
        } catch (Exception e){

        }
        Random rng = new Random();
        for (int i = 0; i<n-1; i++ ){
            System.out.println(rng.nextInt() + " ");
        }
        System.out.println( "Hello World!" );
*/
    }
}
