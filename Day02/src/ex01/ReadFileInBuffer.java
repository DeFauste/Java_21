package ex01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class ReadFileInBuffer {
    private HashSet<String> dictionary_ = new HashSet<>();
    public ReadFileInBuffer(HashSet<String> dictionary) {
        dictionary_ = dictionary;
    }

    public HashSet<String> GetDictionaryFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^\\w]+");
                dictionary_.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary_;
    }

    public HashSet<String> GetDictionary = dictionary_;
}
