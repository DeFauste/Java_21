package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetFileSignatures {
    private String lastKey = "";
    private FileInputStream fileInputStream = null;

    public String getLastKey() {
        return lastKey;
    }

    public String GetMagicKeyFile(String fileName) {
        File file = new File(fileName);
        StringBuilder buffer = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            for (int i = 0; i < 8 && fileInputStream.available() > 0; ++i) {
                buffer.append(String.format("%02X", fileInputStream.read()));
            }
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        lastKey = buffer.toString();
        return lastKey;
    }
}
