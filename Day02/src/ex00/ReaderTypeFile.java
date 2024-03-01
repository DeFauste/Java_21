package ex00;

import java.io.*;
import java.util.Map;

public class ReaderTypeFile {
    Map<String, String> keyMap;
    File fileWrite;
    File fileReadKey;
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;

    public ReaderTypeFile(String fileReadKey, String fileWrite) {
        this.fileReadKey = new File(fileReadKey);
        ReadKeyFile(this.fileReadKey);
        this.fileWrite = new File(fileWrite);
    }


    public void InputFilePathForMagicKey(String name) {
        File file = new File(name);
        String magicKey = GetMagicKeyFile(file);
//        boolean contain = CheckContainsMap(magicKey);
    }

    private boolean CheckContainsMap(String key) {
        return keyMap.containsKey(key);
    }

    private void ReadKeyFile(File file) {
        if (file != null) {
            StringBuilder buffer = new StringBuilder();
            char c;
            try {
                fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    c = (char) fileInputStream.read();
                    if (c != '\n') {
                        buffer.append(String.format("%c", c));
                    } else {
                        ParseStrToMap(buffer.toString());
                        buffer.delete(0, buffer.length());
                    }
                }
                fileInputStream.close();
                System.out.println(buffer.toString());
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private void ParseStrToMap(String line) {
        if (line != null) {
            String[] pair = line.split(",");
            keyMap.put(pair[1], pair[0]);
        }
    }

    private String GetMagicKeyFile(File file) {
        StringBuilder buffer = new StringBuilder();
        if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                for (int i = 0; i < 8 && fileInputStream.available() > 0; ++i) {
                    buffer.append(String.format(" %02X", fileInputStream.read()));
                }
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return buffer.toString();
    }
}
