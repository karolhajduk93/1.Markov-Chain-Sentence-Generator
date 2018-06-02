package com.mycompany;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        /*
        to do:
        check if hashmap file is existing
        if not:
        read file
        creat hashmap from this file
        save hashmap to file
        if is:
        make sentence
        */

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        try {
            String fileName = "C:\\Users\\Karol_Hajduk\\IdeaProjects\\MarkovChainSentenceGenerator\\The_War_ of_the_Worlds.txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String lastWord = null;

            while ((line = bufferedReader.readLine()) != null) {
                line = line.toLowerCase();
                //System.out.println(line);
                String[] words = line.split("\\W+");
                if (words.length == 0)
                    continue;
                if (lastWord != null){
                    hashMap.get(lastWord).add(words[0]);
                }

                for (int i = 0; i < words.length; i++) {
                    hashMap.putIfAbsent(words[i], new ArrayList<>());
                    if (i == words.length - 1){
                        lastWord = words[words.length-1];
                        //System.out.println(lastWord);
                        break;
                    }
                    hashMap.get(words[i]).add(words[i + 1]);
                }

            }

           /* for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()){
                System.out.println("[" + entry.getKey() + "] " +  entry.getValue());
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
