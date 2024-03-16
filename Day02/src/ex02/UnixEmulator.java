package ex02;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class UnixEmulator {
    private String exit = "exit";
    private String currentPath = null;
    Path path = null;

    public UnixEmulator(String[] currPath) {
        currentPath = currPath[0].substring(currPath[0].indexOf('=') + 1);
        try {
            path = Paths.get(currentPath);
            Terminal();
        } catch (InvalidPathException e) {
            System.out.println("Directory not exist");
            e.printStackTrace();
        }
    }

    public void Terminal() {
        ShowCurPath();
        Scanner reader = new Scanner(System.in);
        String command = "zero";
        while (!command.equals(exit)) {
            command = reader.nextLine();
            if (command.equals("ls")) {
                ShowAllFile();

            } else if (command.equals("cd..")) {
                CDDownFolder();
            } else if (command.equals("pwd")) {
                ShowPWD();
            } else if (command.contains("cd ")) {
                CD(command);
            } else if(command.contains("mv ")) {
                MV(command);
            }
        }
    }

    private void CD(String command) {
        command = command.trim();
        String[] sp = command.split(" ");
        if (sp[0].equals("cd")) {
            String newPath = new StringBuilder().append(path.toString()).append("\\").append(sp[1]).toString();
            try {
                Path nPath = Paths.get(newPath).normalize();
                if (Files.isDirectory(nPath)) {
                    path = nPath;
                    ShowCurPath();
                } else  {
                    System.out.println("Directory not exist");
                }
            } catch (InvalidPathException e) {
                System.out.println("Directory not exist");
            }
        } else {
            System.out.println("Error command");
        }
    }
    private void MV(String command) {
        command = command.trim();
        String[] sp = command.split(" ");
        if (sp[0].equals("mv")) {
            try {
                String start = new StringBuilder().append(path.toString()).append("\\").append(sp[1]).toString();
                String end = new StringBuilder().append(path.toString()).append("\\").append(sp[2]).toString();
                Path source = Paths.get(start).normalize();
                Path target = Paths.get(end).normalize();
                if (Files.exists(source)) {
                    Files.move(source, target);
                } else  {
                    System.out.println("Directory or file not exist");
                }
            } catch (InvalidPathException e) {
                System.out.println("Directory not exist");
            } catch (IOException e) {
                System.out.println("File not exist");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error command");
            }
        } else {
            System.out.println("Error command");
        }
    }

    private void ShowCurPath() {
        System.out.println(path.toString());
    }

    private void ShowPWD() {
        System.out.println(path.subpath(0, path.getNameCount()));
    }

    private void ShowAllFile() {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path path : files) {
                if (Files.isDirectory(path))
                    System.out.printf("%s\n", path.getFileName());
                else
                    System.out.printf("%s %d KB\n", path.getFileName(), Files.size(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CDDownFolder() {
        try {
            path = Paths.get(path.getParent().toString());
            ShowCurPath();
        } catch (InvalidPathException e) {
            System.out.println("Directory not exist");
        }
    }

}
