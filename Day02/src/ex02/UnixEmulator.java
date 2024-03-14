package ex02;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnixEmulator {
    String currentPath = null;
    Path path = null;

    public UnixEmulator(String[] currPath) {
        currentPath = currPath[0].substring(currPath[0].indexOf('=') + 1);
        try {
            path = Paths.get(currentPath);
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
    }

    public void ShowPath() {
        System.out.println(currentPath);
    }
}
