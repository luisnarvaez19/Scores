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

        System.out.println( "Welcome to the Bowling" );
        Game game=new Game();
        // Read the file with the Game's data
        try (Stream<String> stream = Files.lines(Paths.get("scores.txt"))) {
            stream
                    .map(String::trim)
                    .forEach(x->game.processData(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.scoreGame();

        System.out.println( "Game over" );
    }
}
