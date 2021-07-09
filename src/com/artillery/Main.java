package com.artillery;

public class Main {


    public static void main(String[] args) {
	// write your code here
        RandArrayGen arrayGenerator = new RandArrayGen();
        ReadIntoComp fileReader = new ReadIntoComp();

        if(arrayGenerator.askuser()) {
            int[] infoArray = arrayGenerator.getInfo(); // getting info from user
            int[] outputArray = arrayGenerator.genArray(infoArray); // generating output array to be written to file
            arrayGenerator.fileWrite(outputArray);
        }

        String fileToRead = fileReader.fileNameRead();
        String newStringArray = fileReader.readArray(fileToRead);
        int[] algoTestArray = fileReader.stringtoArray(newStringArray);

    // Algo class initialize
       SelectionSort selSort = new SelectionSort();
       InsertionSort insSort = new InsertionSort();


    }
}
