package fr.epita.mnist.launcher;

import fr.epita.mnist.datamodel.Image;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Launcher {


    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("mnist_test.csv");
        Scanner sc = new Scanner(fr);
        String lineFromScanner = sc.nextLine();
        sc.close();
        // load the csv
        List<String> lines = Files.readAllLines(Path.of("mnist_test.csv"));
        lines.remove(0);
        List<Double[]> data = readData(lines);
        System.out.println(data.size());
        List<Image> images =getImages(data);

        Image image = images.get(0);
        //we display the image
        showMatrix(image);
        System.out.println(image.getLabel()); // label display

        System.out.println(images.size());
        Map<Double, Integer> countByLabel = new HashMap<>();
        for(Image img : images) {
            Integer i = countByLabel.get(img.getLabel());
            if(i == null) {
                countByLabel.put(img.getLabel(), 1);
            }else{
                countByLabel.put(img.getLabel(), i+1);
            }
        }
        System.out.println(countByLabel);




    }

    private static List<Double[]> readData(List<String> lines) {
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
        return data;
    }

    private static List<Image> getImages(List<Double[]> data) {
        List<Image> images = new ArrayList<>();

        for (int k = 0; k < data.size(); k++) {
            Double[] doubles = data.get(k);
            //Double[28][28]
            Double[][] imageData = new Double[28][28];
            //reshape the flat image data into a 2d array
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    imageData[i][j] = doubles[1 + i * 28 + j];
                }
            }
            Double label = doubles[0];
            Image image = new Image(label, imageData);
            images.add(image);
        }
        return images;
    }

    private static void showMatrix(Image image) {
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                if (image.getData()[i][j] > 100.0) {d
                    System.out.print( "xx");
                }else  {
                    System.out.print( "..");
                }

            }
            System.out.println();
        }
    }
}
