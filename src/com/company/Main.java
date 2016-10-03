package com.company;

import com.company.Vigenere.Task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyData data = new MyData("");
        data.readFile("D:\\ProjectPrograming\\Java\\" +
                "FirsProgramCryptography\\src\\com\\company\\Data.txt");
        System.out.println("Ручний режим - 1, Напівавтоматичний - 2");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (a == 1) {
            String firstLetter, secondLetter, end = "0";

            while (end != "end") {
                end = in.nextLine();
                System.out.println("end- кінець,swap - міняти літери,fra - частоти, swaped - замінені слова, " +
                        "task2 - task2, task3 - task3");
                switch (end) {
                    case "end":
                        end = "end";
                        break;
                    case "swap":
                        System.out.println("Введіть літери які потрібно поміняти");
                        firstLetter = in.nextLine();
                        secondLetter = in.nextLine();
                        data.swapLetter(firstLetter, secondLetter);
                        System.out.println("Текст");
                        data.showText();
                        break;
                    case "fra":
                        data.showFrequency();
                        break;
                    case "swaped":
                        data.swapped();
                        break;
                    case "task2":
                        Task2 task2 = new Task2();
                        task2.inputText("D:\\ProjectPrograming\\Java\\" +
                                "FirsProgramCryptography\\src\\com\\company\\Vigenere\\VigenerData.txt");
                        Scanner inn = new Scanner(System.in);
                        task2.startAlgorithm();
                        System.out.println("Input length word");
                        int length = inn.nextInt();
                        task2.lengthWord(length);
                        System.out.println("Input word");
                        Scanner innn = new Scanner(System.in);
                        String word = innn.nextLine();
                        task2.decoderText(word);
                        task2.showDecodetText();
                        break;
                    case "task3":
                        Task2 task3 = new Task2();
                        task3.inputText("D:\\ProjectPrograming\\Java\\" +
                                "FirsProgramCryptography\\src\\com\\company\\Vigenere\\Vigenere2");
                        Scanner inn2 = new Scanner(System.in);
                        task3.startAlgorithm();
                        System.out.println("Input length word");
                        int length2 = inn2.nextInt();
                        task3.lengthWord(length2);
                        System.out.println("Input word");
                        Scanner innn2 = new Scanner(System.in);
                        String word2 = innn2.nextLine();
                        task3.decoderText(word2);
                        task3.showDecodetText();
                        break;

                }

            }
        } else {
            for (int i = 0; i < 2000; i++) {
                data.generationRandomKey();
            }
            data.showTranslation();
            data.show4();
            data.decodedText();
        }

    }
}
