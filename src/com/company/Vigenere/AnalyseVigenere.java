package com.company.Vigenere;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Lev on 01.10.2016.
 */
public class AnalyseVigenere {

    private String text, textDevidePeriodOfLengthWord;
    private int lengthWord, counterForPopularLetter = 0, indexPopularLeter = 0;
    private char[] key;
    private char popularChar;

    public AnalyseVigenere(String string, int lengthWord) {
        this.text = string;
        this.lengthWord = lengthWord;
        key = new char[lengthWord];
    }

    public void startAlgorithm() {

        devideText();

    }

    private void devideText() {

        for (int j = 4; j < 4 + lengthWord; j++) {

            this.textDevidePeriodOfLengthWord = "";

            for (int i = j; i < this.text.length(); i = i + lengthWord) {

                this.textDevidePeriodOfLengthWord = this.textDevidePeriodOfLengthWord + this.text.substring(i, i + 1);
            }

            frequency(this.textDevidePeriodOfLengthWord);

        }

    }

    public void frequency(String text) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        char letter;
        for (int i = 0; i < text.length(); i++) {
            letter = text.charAt(i);
            Integer val = map.get(new Character(letter));
            if (val != null) {
                map.put(letter, new Integer(val + 1));
            } else {
                map.put(letter, 1);
            }
        }

        showFrequency(map);

        map.forEach((k, v) -> searchSecretword(k, v));
        setindexPopularLeter0();
        recordLetter(this.indexPopularLeter);

        this.indexPopularLeter++;

    }

    private void showFrequency(Map<Character, Integer> map) {

        System.out.println("Frequency for words");
        map.forEach((k, v) -> System.out.println(k + " - " + v));
    }

    private void searchSecretword(Character k, Integer v) {

        if (v.intValue() > counter()) {
            this.popularChar = k.charValue();
            this.counterForPopularLetter = v.intValue();
        }
    }

    private int counter() {
        return this.counterForPopularLetter;
    }

    private void recordLetter(int index) {
        key[index] = this.popularChar;
    }

    public char[] getKey() {

        return this.key;
    }

    private void setindexPopularLeter0() {

        this.counterForPopularLetter = 0;
    }
}
