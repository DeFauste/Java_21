package ex02;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
        UnixEmulator unixEmulator = new UnixEmulator(args);



    }
}
