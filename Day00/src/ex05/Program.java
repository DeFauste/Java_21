package ex05;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String stepTrigger = ".";
        String bufferInp;

        int maxStudent = 10;
        int maxNameLength = 10;
        String[] students = new String[maxStudent];

        int maxClasses = 10;
        String[][] classes = new String[maxClasses][2];

        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (count < maxStudent) {
                bufferInp = scanner.nextLine();
                if (bufferInp.equals(stepTrigger)) {
                    break;
                }
                if (bufferInp.length() < maxNameLength) {
                    students[count++] = bufferInp;
                } else {
                    System.err.println("Very long name. Max length 10 symbols.");
                }
            } else {
                System.err.println("Limit students 10. Enter dote (.)");
            }
        }
        System.out.println(Arrays.toString(students));

        count = 0;
        while (true) {
            if (count < maxClasses) {
                bufferInp = scanner.next();
                if (bufferInp.equals(stepTrigger)) {
                    break;
                }
                classes[0][count] = bufferInp;
                classes[1][count] = scanner.next();
                count++;
            } else {
                System.err.println("Limit classes 10. Enter dote (.)");
            }
        }
        showArray2D(classes);
        
        scanner.close();
    }

    public static void showArray2D(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print("    ");
            }
            System.out.println();
        }
    }
}
