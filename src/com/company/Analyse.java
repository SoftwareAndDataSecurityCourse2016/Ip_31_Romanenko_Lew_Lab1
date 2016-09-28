package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Lev on 13.09.2016.
 */
public class Analyse {

    private static final HashMap<Character, Double> frequencyOfLetters;
    private double coefficient;
    private Map<Character, Double> map;
    private char[] key;

    Analyse() {

    }

    public boolean analyseText(char[] text, char[] key) {
        this.map = new TreeMap<Character, Double>();
        this.key = key;
        return computeCoefficient(text);
    }

    private boolean computeCoefficient(char[] text) {
        double p = 0;
        char letter;
        for (int i = 0; i < text.length; i++) {
            letter = text[i];
            Double val = map.get(new Character(letter));
            if (val != null) {
                map.put(letter, new Double(val + 1));
            } else {
                map.put(letter, 1.0);
            }
        }

        for (Map.Entry<Character, Double> entry : map.entrySet()) {
            entry.setValue(entry.getValue() / text.length);
        }

        for (int i = 0; i < key.length; i++) {
            if (this.map.get(new Character(this.key[i])) != null)
                p = this.frequencyOfLetters.get(new Character(this.key[i])) * this.map.get(new Character(this.key[i])) + p;
        }
        if (p > this.coefficient) {
            this.coefficient = p;
            System.out.println(this.coefficient);
            return true;
        }

        return false;
    }

    public void showBestCoeficient() {

        System.out.println(this.coefficient);

    }

    static {
        frequencyOfLetters = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            frequencyOfLetters.put('E', 12.7);
            frequencyOfLetters.put('T', 9.06);
            frequencyOfLetters.put('I', 8.17);
            frequencyOfLetters.put('O', 7.51);
            frequencyOfLetters.put('A', 6.97);
            frequencyOfLetters.put('N', 6.75);
            frequencyOfLetters.put('S', 6.33);
            frequencyOfLetters.put('H', 6.09);
            frequencyOfLetters.put('R', 5.99);
            frequencyOfLetters.put('L', 4.25);
            frequencyOfLetters.put('C', 4.03);
            frequencyOfLetters.put('F', 2.78);
            frequencyOfLetters.put('U', 2.76);
            frequencyOfLetters.put('M', 2.41);
            frequencyOfLetters.put('W', 2.36);
            frequencyOfLetters.put('D', 2.23);
            frequencyOfLetters.put('G', 2.02);
            frequencyOfLetters.put('Y', 1.97);
            frequencyOfLetters.put('P', 1.93);
            frequencyOfLetters.put('B', 1.49);
            frequencyOfLetters.put('V', 0.98);
            frequencyOfLetters.put('K', 0.77);
            frequencyOfLetters.put('X', 0.15);
            frequencyOfLetters.put('J', 0.15);
            frequencyOfLetters.put('Q', 0.1);
            frequencyOfLetters.put('Z', 0.05);
        }
    }
}
