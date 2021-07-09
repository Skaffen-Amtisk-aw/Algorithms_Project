package com.artillery;

import java.io.*;
import java.util.Arrays;

public class ReadIntoComp {
    public String fileNameRead () {
        System.out.println("Enter FileName you want to read with no file extension");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        try {
            name = reader.readLine() + ".txt";
        } catch (IOException ignored) { //suggested by the editor
            name = "Array.txt";
        }
        return name;
    }

    public String readArray(String filename) {
        String path = "F:\\CPP awwwww yeah\\Algorithms Test Bed\\";
        File file = new File(path + filename);
        StringBuilder text = new StringBuilder();
        String result = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();

            while (line != null) {
                text.append(line);
                line = br.readLine();
            }
            result = text.toString();
            //System.out.print(result);//test [passed]
            br.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return result;
    }
    public int[] stringtoArray(String result){ //will need to do abstraction to make array able to accept more values, good practice

        String input = result.substring(1,result.length() - 1); // removing limiting brackets from string input

        String[] array = input.split(", ");

        int[] algoArray = new int[array.length];

        for(int e = 0; e < array.length; e++){
            algoArray[e] = Integer.parseInt(array[e]);
        }
        // System.out.print(Arrays.toString(algoArray)); //test [SUCCESS]

    return algoArray;
    }
}
