package com.company;

import java.util.Scanner;

import static com.company.Permutations.perm1;
import static com.company.Permutations.perm2;

public class Main {

    public static void main(String[] args) {
        MyData data = new MyData("");
        data.readFile("D:\\ProjectPrograming\\Java\\" +
                "FirsProgramCryptography\\src\\com\\company\\Data.txt");
        //System.out.println(data.getText());
        System.out.println("Ручний режим - 1, Напівавтоматичний - 2");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (a == 1) {
            String firstLetter, secondLetter, end = "0";

            while (end != "end") {
                end = in.nextLine();
                System.out.println("end- кінець,swap - міняти літери,fra - частоти, swaped - замінені слова");
                switch (end) {
                    case "end":
                        end = "end";
                        break;
                    case "swap":
                        System.out.println("Введіть літери які потрібно поміняти");
                        firstLetter = in.nextLine();
                        secondLetter = in.nextLine();
                        data.swapLetter(firstLetter, secondLetter);
                        //  data.swapLetter("",secondLetter);
                        //  data.swapLetter(firstLetter,secondLetter);
                        System.out.println("Текст");
                        data.showText();
                        break;
                    case "fra":
                        data.showFrequency();
                        break;
                    case "swaped":
                        data.swapped();
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
