package com.bowling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        try (Stream<String> stream = Files.lines(Paths.get("scores.txt"))) {
            stream
                   // .filter(line -> line.contains("print"))
                    .map(String::trim)
                    .forEach(x->Game.readLineFile(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World! Final2" );
    }
}
