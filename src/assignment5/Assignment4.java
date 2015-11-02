package assignment5;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.text.*;

/**
 *
 * @author: Donnie Sandlin 
 * Assignment 4 
 * 11/1/2015
 */
public class Assignment4 extends MyLinkedList {

    private double wordfound;
    private double wordnotfound;
    private int[] record = new int[1];
    private double numRWNF = 0;
    private double numRWF = 0;
    MyLinkedList[] dict = new MyLinkedList[26];
    private String[] split;

    Assignment4() {
    }

    public void readFile() {
        for (int i = 0; i < dict.length; i++) {
            dict[i] = new MyLinkedList<>();
        }
        try {
            FileReader input = new FileReader("random_dictionary.txt");
            String word = "";
            int i = 0;
            char ch;
            while ((i = input.read()) != -1) {
                ch = (char) i;
                if (Character.isLetter(ch)) {
                    word += ch;
                }
                if (ch == 10 || ch == 45 || ch == 32 && word.length() != 0) {
                    word = word.toLowerCase();
                    dict[word.charAt(0) - 97].add(word);
                    word = "";
                }
            }
            input.close();
        } catch (IOException Ex) {
            System.out.println("No File Found. ");
        }
    }

    public void readSpelling() {

        try {
            File data2 = new File("oliver.txt");
            Scanner read2 = new Scanner(data2);

            while (read2.hasNext()) {
                String c1 = read2.next();
                String c2 = c1.toLowerCase();
                c2 = c2.trim();
                split = c2.split("[ \\| \\{ \\~ \\}` = : _ - \\& # $ % ^ ( ) + \\, \\. ; ! / ? < > \\* \\- \" '  \\[ \\] \\+ \\@ 1 2 3 4 5 6 7 8 9 0]");

                for (int i = 0; i < split.length; i++) {

                    if (!split[i].isEmpty()) {

                        if (dict[(int) split[i].charAt(0) - 97].contains(split[i], record)) {
                            wordfound++;
                            numRWF += record[0];
                        } else {
                            //System.out.println(analyze[i]);
                            wordnotfound++;
                            numRWNF += record[0];

                        }
                        record[0] = 0;
                    }

                }
            }

            read2.close();
        } catch (IOException E) {
            System.out.println("File not found");
        }
    }

    @Override
    public String toString() {
        return "Words found or correct words: " + wordfound + "\nWords Not Found or incorrect: " + wordnotfound
                + "\ncomparsions for words found : " + numRWF + "\ncomparisons for words not found: " + numRWNF + "\naverage comparisons for words found: " + numRWF / wordfound
                + "\naverage comparisons for words not found " + numRWNF / wordnotfound;
    }
}
