package ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        StringBuilder buffer = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String inpLine;
        byte curStep = 1;
        int weekCount = 0,maxWeekC = 16;
        while (scanner.hasNextLine() && weekCount < maxWeekC) {
            inpLine = scanner.nextLine();
            if (inpLine.equals("42")) {
                break;
            }
            if (curStep == 1 & inpLine.split(" ")[0].equals("Week")) {
                weekCount++;
                curStep = 2;
                buffer.append(inpLine);
                buffer.append("|");
            } else if (curStep == 2) {
                curStep = 1;
                buffer.append(inpLine);
                buffer.append("|");
            } else {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            buffer.append("\n");
        }
        int min = 10;
        String outLine = buffer.toString();
        for (int i = 0; i < outLine.length(); i++) {
            if (curStep == 1) {
                min = 10;
                if(outLine.charAt(i) == '\n') continue;
                if (outLine.charAt(i) == '|') {
                    System.out.print(" ");
                    curStep = 2;
                    continue;
                }
                System.out.print(outLine.charAt(i));
            } else {
                if(outLine.charAt(i) == '\n' || outLine.charAt(i) == ' ') continue;
                if (outLine.charAt(i) == '|') {
                    for (int eq = 0; eq < min; eq++) {
                        System.out.print("=");
                    }
                    System.out.print(">");
                    curStep = 1;
                    continue;
                }
                int n = outLine.charAt(i) - '0';
                if (min > n) min = n;
            }
        }
    }
}