package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Created by Lev on 13.09.2016.
 */
public class MyData {

    private int secondindex = 0, counterthreeGrams = 0;
    private String text, originalText, bestText = "NULL";
    private char[] key, mainKey, chanedString;
    private final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<Character, Integer> map;
    private HashMap<Character, Character> AutomatycalyMap;
    private Analyse analyse;

    public MyData(String text) {
        this.text = text;
        this.map = new TreeMap<Character, Integer>();
        key = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        mainKey = Arrays.copyOf(key, key.length);
        this.AutomatycalyMap = new HashMap<>();
        chanedString = new char[500];
        analyse = new Analyse();

    }


    public void swapLetter(String oldLetter, String newLetter) {

        this.text = this.text.replace(oldLetter, newLetter);
    }

   /* public  void swapLetterAutomatycaly(){
        while
    }
    /*private void oldText(){
        this.text.p
    }*/

    public void readFile(String string) {
        try (BufferedReader br = new BufferedReader(new FileReader(string))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                // System.out.println(sCurrentLine);
                this.text += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        frequency();
        this.originalText = new String(this.text);

    }

    public String getText() {

        return this.text;
    }


    private void frequency() {
        char letter;
        for (int i = 0; i < this.text.length(); i++) {
            letter = this.text.charAt(i);
            Integer val = map.get(new Character(letter));
            if (val != null) {
                map.put(letter, new Integer(val + 1));
            } else {
                map.put(letter, 1);
            }
        }
    }


    public void decodedText() {
        showText3();
        System.out.println("Count - " + counterthreeGrams);
    }

    public void showFrequency() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            //System.out.println("Char " + entry.getKey() + " fraquency " + entry.getValue().floatValue()/this.text.length());
            System.out.println("Char " + entry.getKey() + " fraquency " + entry.getValue());

        }

    }

    public void showText() {
        int counter = 0;
        System.out.println();
        for (int i = 0; i < this.text.length(); i++) {
            char letter;
            counter++;
            letter = this.text.charAt(i);
            if (counter == 100) {
                System.out.println(letter);
                counter = 0;
            } else
                System.out.print(letter);
        }
        System.out.print(this.text.length());
    }

    public void showText2() {
        int counter = 0;
        System.out.println();
        for (int i = 0; i < this.chanedString.length; i++) {
            char letter;
            counter++;
            letter = this.chanedString[i];
            if (counter == 100) {
                System.out.println(letter);
                counter = 0;
            } else
                System.out.print(letter);
        }

    }

    public void showText3() {
        int counter = 0;
        System.out.println();
        for (int i = 0; i < this.bestText.length(); i++) {
            char letter;
            counter++;
            letter = this.bestText.charAt(i);
            if (counter == 100) {
                System.out.println(letter);
                counter = 0;
            } else
                System.out.print(letter);
        }

    }

    public void show4() {
        this.analyse.showBestCoeficient();
        System.out.println(this.text.length());
    }

    public void swapped() {
        char letter;
        boolean lowerScape;
        String lowerScapeChar = "";
        for (int i = 0; i < this.text.length(); i++) {

            letter = this.text.charAt(i);
            if (Character.isLowerCase(letter)) {
                lowerScapeChar = lowerScapeChar + letter;
            } else {
                if (lowerScapeChar != "")
                    System.out.println(lowerScapeChar);
                lowerScapeChar = "";
            }

        }
    }

    public char[] generationRandomKey() {

        key = Arrays.copyOf(mainKey, mainKey.length);
        for (int j = 0; j < secondindex; j++) {

            if (j == secondindex - 1) {
                char tmp = key[j];
                key[j] = key[j + 1];
                key[j + 1] = tmp;
            }
        }
        secondindex++;
        if (secondindex == 25) {
            secondindex = 0;
           /* char tmp = key[5];
            key[5] = key[20];
            key[20] = tmp;
             tmp = key[25];
            key[25] = key[10];
            key[10] = tmp;*/
        }
        createNewKey();
        return key;
    }

    private void createNewKey() {

        for (int i = 0; i < letters.length(); i++) {
            AutomatycalyMap.put(new Character(letters.charAt(i)), new Character(key[i]));
        }

        atteckText();
    }

    private void atteckText() {

        this.text = new String(this.originalText);
        /*for (int i = 0; i <letters.length() ; i++) {
            this.text = text.replace(  letters.charAt(i),AutomatycalyMap.get(new Character (  letters.charAt(i))));
        }*/

        for (int i = 0; i < this.text.length(); i++) {
            chanedString[i] = AutomatycalyMap.get(new Character(this.text.charAt(i)));
        }


        if (analyse.analyseText(chanedString, key)) {
            secondindex = 0;
            mainKey = Arrays.copyOf(key, key.length);
        }
        //   System.out.println(analyse.analyseText(chanedString));
        // analysis(chanedString);
    }

    public void showTranslation() {
        for (int i = 0; i < this.text.length(); i++) {
            chanedString[i] = AutomatycalyMap.get(new Character(this.text.charAt(i)));
        }

        String TextText = new String(chanedString);
        System.out.println(TextText);
    }

    public void analysis(char[] value) {

        int counter = countSubstring("ING", value);
        int counter1 = countSubstring("AND", value);
        int counter2 = countSubstring("THE", value);
        int counter3 = countSubstring("HER", value);
        // int counter5 = countSubstring("BRO",value);
        int counter6 = countSubstringBE("TH", value);
        int counter10 = countSubstringBE("HE", value);
        int counter7 = countSubstringBE("IN", value);
        int counter8 = countSubstringBE("ER", value);
        int counter9 = countSubstringBE("AN", value);

        int counter4 = counter + counter1 + counter2 + counter3 + counter6
                + counter7 + counter8 + counter9 + counter10;
        if (counter4 > this.counterthreeGrams) {
            this.counterthreeGrams = counter4;
            bestText = String.valueOf(value);
        }
    }

    private int countSubstring(String s, char[] text) {
        int count = 0;
        for (int i = 0; i < text.length; i++) {
            if (s.charAt(0) == text[i])
                if (s.charAt(1) == text[i + 1])
                    if (s.charAt(2) == text[i + 2])
                        count++;
        }
        return count;
    }

    private int countSubstringBE(String s, char[] text) {
        int count = 0;
        for (int i = 0; i < text.length; i++) {
            if (s.charAt(0) == text[i])
                if (s.charAt(1) == text[i + 1])
                    count++;
        }
        return count;
    }
}
