package ex00;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FileSignaturesLog {
    private String pathKey = "src/ex00/signatures.txt";
    private String pathLog = "src/ex00/result.txt";
    private File signaturesFile = null;
    private File logFile = new File(pathLog);
    private ReadSignatures readSignatures = new ReadSignatures(pathKey);
    private GetFileSignatures getFileSignatures = new GetFileSignatures();
    private FileOutputStream fileOutputStream = null;
    private Scanner scanner = new Scanner(System.in);

    public FileSignaturesLog() {
        readSignatures.ReadFileKey();
        try {
            fileOutputStream = new FileOutputStream(pathLog);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void Start() {
        if (fileOutputStream != null) {
            String inputLine = "";
            boolean writen = false;
            while (!inputLine.equals("42")) {
                inputLine = scanner.nextLine();
                writen = WriteLogFileSignatures(inputLine);
                if(writen ) {
                    System.out.println("PROCESSED");
                } else {
                    System.out.println("NOT FOUND SIGNATURES");
                }
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean WriteLogFileSignatures(String pathFile) {
        boolean ret = false;
        String signaturesKey = getFileSignatures.GetMagicKeyFile(pathFile);
        if (readSignatures.ContainsKey(signaturesKey)) {
            try {
                fileOutputStream.write(readSignatures.GetValuesOnKey(signaturesKey).getBytes());
                ret = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ret;
    }

}
