package ex03;

import java.io.*;
import java.util.ArrayList;
public class ReadUrlString {
    File urlsFile;
    ReadUrlString(File file) {
        urlsFile = file;
    }

    public String[] GetStringArrUrl() {
        ArrayList<String> urls = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(urlsFile))) {
            String line = reader.readLine();
            while (line != null) {
                urls.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return urls.toArray(new String[0]);
    }
}
