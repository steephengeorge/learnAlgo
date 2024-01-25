package com.soulmeadows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LimitedLengthQueue {

    private List<String> innerStore;
    private int size;
    private static final String FILENAME="C:/filepath.txt.txt";
    public LimitedLengthQueue(int size) {
        this.innerStore = new ArrayList<>();
        this.size = size;
    }

    boolean add(String s){
        if(innerStore.size() == size){
            innerStore.remove(0);
            innerStore.add(s);
            return true;
        }
        innerStore.add(s);
        return true;
    }


    public static void main(String[] args)
            throws FileNotFoundException, IOException  {
        LimitedLengthQueue inputQueue =
                new LimitedLengthQueue(Integer.parseInt(args[0]));
        String key = args[1];

        try( FileReader fr = new FileReader(FILENAME);
             BufferedReader br = new BufferedReader(fr)){

            String input = null;

            while( (input = br.readLine()) != null){

                if(key.equals(input.trim())){
                    inputQueue.innerStore.forEach(System.out::println);
                    System.out.println(input);
                    break;
                }
                inputQueue.add(input);
            }
        }
    }
}