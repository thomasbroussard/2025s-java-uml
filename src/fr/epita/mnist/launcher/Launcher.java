package fr.epita.mnist.launcher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {


    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("mnist_test.csv");
        Scanner sc = new Scanner(fr);
        String lineFromScanner = sc.nextLine();
        sc.close();
        // load the csv
        List<String> lines = Files.readAllLines(Path.of("mnist_test.csv"));
        lines.remove(0);
        List<Double[]> data = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            //convert a line to an array of double
            Double[]  values = new Double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                values[i] = Double.parseDouble(parts[i]);
            }
            data.add(values);
        }


        //we isolate an image
        Double[] doubles = data.get(0); //Double[784]
        //Double[28][28]
        Double[][] imageData = new Double[28][28];
        //reshape the flat image data into a 2d array
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                imageData[i][j] = doubles[1 + i * 28 + j];
            }
        }

        //we display the image
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                if (imageData[i][j] > 100.0) {
                    System.out.print( "xx");
                }else  {
                    System.out.print( "..");
                }

            }
            System.out.println();
        }
        System.out.println(doubles[0]); // label display



        /*
        ooooooooo
        ooo
        ooo
        ooo
         */

    }
}
