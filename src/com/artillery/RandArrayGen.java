package com.artillery;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandArrayGen {
    public boolean askuser(){
        System.out.println("Do you want to make a randomized number file Y/N?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        boolean result = false;
        try {
            answer = reader.readLine();
            answer = answer.toUpperCase();
            result = answer.equals("Y");
        } catch(IOException ignored){ //suggested by the editor

        }
        return result;
    }

    public int[] getInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired array length as an integer");
        int length = input.nextInt();
        System.out.println("Enter desired number seed as an integer or enter zero");
        int seed = input.nextInt();

        int[] array = new int[2];

        array[0] = length;
        array[1] = seed;

        System.out.println("Array length is " +array[0]+ ". Num Sequence seed is " + array[1] + ".");

        return array;
    }

    public int[] genArray(int[] array) {
        int outputLength = array[0];
        int seed = array[1];
        int[] outputArray = new int[outputLength];

        if (seed == 0) {
            Random random = new Random();
            for (int e = 0; e < outputLength; e++) {
                outputArray[e] = random.nextInt(outputLength);
            }

        } else {
            Random random = new Random(seed);
            for (int e = 0; e < outputLength; e++) {
                outputArray[e] = random.nextInt(outputLength);
            }

        }
        return outputArray;
    }
    public String fileName (){
        System.out.println("Enter FileName with no file extension");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        try {
            name = reader.readLine() +".txt";
        } catch(IOException ignored){ //suggested by the editor
            name = "Array.txt";
        }
    return name;
    }
    public void fileWrite(int[] outputArray){
        String filename = fileName();
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter(filename));

            outputWriter.write(Arrays.toString(outputArray));

            outputWriter.close(); //flushes and closes the stream. Likely necessary for larger arrays

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }

    }
}
