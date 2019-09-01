package com.bowling;

import java.io.File;
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
        System.out.println( "Welcome to the Bowling");
        Game game=new Game();
        File f = new File(args[0]);
        if(f.exists() && !f.isDirectory()) {
            // do something
            // Read the file with the Game's data
            try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
                stream
                        .map(String::trim)
                        .forEach(x->game.processData(x));
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.scoreGame();

        } else
            System.out.println("The file: "+args[0]+" do not exist in this directory.");

        System.out.println( "Game over" );
    }
}
