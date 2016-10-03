package com.company.Vigenere;

import com.company.Analyse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Lev on 28.09.2016.
 */
public class Task2 {

    private String text;
    private HashMap<String, int[]> frequency;
    private ArrayList<Integer> positionAllRepeats;
    private AnalyseVigenere analyse;
    private char[] key, decodedText;

    public Task2() {
        frequency = new HashMap<>();
        positionAllRepeats = new ArrayList<>();
        key = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    }

    public void show() {

        System.out.println("Coordinates reps");
        frequency.forEach((k, v) -> System.out.println(k + "=" + v[0] + "|" + v[1] + "|" + v[2] + "|"
                + v[3] + "|" + v[4] + "|" + v[5] + "|" + v[6]));
        System.out.print("Distance between the trigrams:");
        System.out.print(positionAllRepeats);
        System.out.println();
    }

    public void inputText(String string) {
        try (BufferedReader br = new BufferedReader(new FileReader(string))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                // System.out.println(sCurrentLine);
                this.text += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void startAlgorithm() {

        analyzeTextBigrams();
        commonDivisor();
        show();
        showDivisor();

    }

    public void lengthWord(int length) {
        analyse = new AnalyseVigenere(text, length);
        analyse.startAlgorithm();
        System.out.print("frequency Of Main text");
        analyse.frequency(this.text);
    }

    private void analyzeTextBigrams() {

        char[] bigrams = new char[3];

        int count = 0;

        int[] valueOfFrequency;

        for (int i = 4; i < this.text.length() - 2; i++) {
            bigrams[0] = this.text.charAt(i);
            bigrams[1] = this.text.charAt(i + 1);
            bigrams[2] = this.text.charAt(i + 2);
            String begramsString = new String(bigrams);
            int index = 0;

            valueOfFrequency = new int[10];

            while (index != -1) {

                index = this.text.indexOf(begramsString, index + 3);

                if (index != -1)
                    valueOfFrequency[count] = index - 3;

                count++;

            }

            count = 0;

            if (valueOfFrequency[2] != 0) {
                if (!frequency.containsKey(begramsString))
                    toObject(valueOfFrequency);
                frequency.put(begramsString, valueOfFrequency);
            }
        }

    }

    private void commonDivisor() {

        for (int i = 0; i < positionAllRepeats.size() - 1; i++) {
            if (positionAllRepeats.get(i + 1) > positionAllRepeats.get(i))
                positionAllRepeats.set(i, positionAllRepeats.get(i + 1) - positionAllRepeats.get(i));
        }

    }

    private void toObject(int[] intArray) {

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0)
                positionAllRepeats.add(new Integer(intArray[i]));
        }
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    public void showDivisor() {
        System.out.println("ALL divisors - candidates of size word");
        for (int i = 0; i < positionAllRepeats.size() / 3 - 1; i++) {
            System.out.println(gcd(positionAllRepeats.get(i), positionAllRepeats.get(i + 1)));
        }
    }

    public void decoderText(String string) {

        int[] zdvig = new int[string.length()];
        decodedText = new char[this.text.length()];
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < key.length; j++) {
                if (string.charAt(i) == key[j])
                    zdvig[i] = j;
            }
        }
        int pp = 0;

        this.text = new String(this.text.substring(4));

        for (int i = 0; i < text.length(); i++) {

            decodedText[i] = swapChar(zdvig[pp], text.charAt(i));
            pp++;
            if (pp == string.length())
                pp = 0;
        }

    }

    private char swapChar(int zdvig, char bukva) {

        for (int i = 0; i < key.length; i++) {
            if (i == 26)
                i = 0;
            if (key[i] == bukva)
                if (i - zdvig < 0) {
                    int tmp = i - zdvig;
                    tmp = key.length + tmp;
                    i = 0;
                    return key[tmp];
                } else return key[i - zdvig];
        }

        return 'P';
    }

    public void showDecodetText() {
        System.out.println(new String(decodedText));
    }


}
