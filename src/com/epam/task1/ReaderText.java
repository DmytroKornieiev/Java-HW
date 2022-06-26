package com.epam.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderText {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("src/com/epam/task1/text.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        String[] words;
        List<String> coll = new ArrayList<>();
        words =line.replaceAll("[.,/()\"]", "").replaceAll("[—-]"," ").split(" ");
        for (int i = 0; i < words.length; i++) {
            coll.add(words[i]);
        }
        List<String> collection = coll.stream()
                    .filter(s -> s.startsWith("O") || s.startsWith("o"))
                    .collect(Collectors.toList());
        for(String s : collection){
            System.out.println(s);
        }
        System.out.println("Count of words, which starts with letter 'O':"+collection.size());
    }
}
