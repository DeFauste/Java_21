package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ReadSignatures {
    private HashMap<String, String> keyMap = new HashMap<>();
    private File file = null;
    private FileInputStream fileInputStream = null;

    public ReadSignatures(String nameFile) {
        file = new File(nameFile);
    }

    public HashMap<String, String> GetMapKey() {
        return keyMap;
    }

    public boolean ContainsKey(String key) {
        return keyMap.containsKey(key);
    }
    public String GetValuesOnKey(String key) {
        return keyMap.get(key);
    }

    public void ReadFileKey() {
        if (file != null) {
            StringBuilder buffer = new StringBuilder();
            char c;
            try {
                fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    c = (char) fileInputStream.read();
                    if (c != '\n' ) {
                        buffer.append(String.format(" %c", c));
                    }
                    if(c == '\n'){
                        PutToMap(buffer.toString());
                        buffer.delete(0, buffer.length());
                    }
                }
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private void PutToMap(String line) {
        if (line != null) {
            String[] pair = line.split(", ");
            keyMap.put(pair[1], pair[0]);
        }
    }

}
