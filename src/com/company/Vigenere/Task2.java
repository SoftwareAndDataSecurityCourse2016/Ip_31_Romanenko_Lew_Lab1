package com.company.Vigenere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lev on 28.09.2016.
 */
public class Task2 {

    private String text;
    private Map<String, Integer> frequency;

    Task2() {
        frequency = new HashMap<>();
    }

    private void inputText(String string) {
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

    private void analyzeTextBigrams() {
        char[] bigrams = new char[]{};
        int count = 0;
        for (int i = 0; i < this.text.length(); i++) {
            bigrams[0] = this.text.charAt(i);
            bigrams[1] = this.text.charAt(i + 1);
            String begramsString = new String(bigrams);
            int index = 0;

            for (int j = 0; j < 6; j++) {

                if (index != -1) {
                    index = this.text.indexOf(begramsString, index);
                    count++;
                } else break;

            }
        }

    }

}
