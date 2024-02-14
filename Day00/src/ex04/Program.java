package ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int unLetter = 0;
        int[] frequency = new int[999];
        char[] letters = new char[999];
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        char[] allCharLine = inputLine.toCharArray();
        int lent = allCharLine.length;
        for (int i = 0; i < allCharLine.length; i++) {
            if (lent > 1 && allCharLine[i] == '4' && allCharLine[i + 1] == '2') break;
            char c = allCharLine[i];
            boolean checkChar = false;
            for (int l = 0; l < unLetter; l++) {
                if (letters[l] == c) {
                    checkChar = true;
                    frequency[l] += 1;
                }
            }
            if (!checkChar) {
                frequency[unLetter] += 1;
                letters[unLetter] = c;
                unLetter++;
            }
        }

        for (int i = 0; i < unLetter - 1; i++) {
            for (int j = i; j < unLetter; j++) {
                char l = letters[i];
                int f = frequency[i];
                if (frequency[i] < frequency[j]) {
                    frequency[i] = frequency[j];
                    letters[i] = letters[j];
                    frequency[j] = f;
                    letters[j] = l;
                } else if (frequency[i] == frequency[j] && letters[i] > letters[j]) {
                    frequency[i] = frequency[j];
                    letters[i] = letters[j];
                    frequency[j] = f;
                    letters[j] = l;
                }
            }
        }

        double step = (frequency[0] / 10.0);
        int wGr = 10, hGr = 12;
        String[][] graph = new String[hGr][wGr];
        for (int i = 0; i < unLetter && i < wGr; i++) {
            int height = (int)(frequency[i] / step);
            boolean prFr = false;
            for (int j = (hGr - height-2); j < hGr; j++) {
                if (!prFr) {
                    graph[j][i] = String.valueOf(frequency[i]);
                    prFr = true;
                } else if (j == hGr - 1) {
                    graph[j][i] = String.valueOf(letters[i]);
                } else {
                    graph[j][i] = "#";
                }
            }
        }
        for (int i = 0; i < hGr; i++) {
            for (int j = 0; j < wGr; j++) {
                if (graph[i][j] != null) {
                    System.out.print(graph[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
