package ex01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class AnalizatorTextSimilarity {
    public void ShowSimilarityTwoFiles(String fileOneName, String fileTwoName) {
        HashSet<String> dictionary = new HashSet<>();
        ReadFileInBuffer readFileInBuffer = new ReadFileInBuffer(dictionary);
        dictionary.addAll(readFileInBuffer.AddDictionaryFromFile(fileOneName));
        dictionary.addAll(readFileInBuffer.AddDictionaryFromFile(fileTwoName));
        AnalyzeSimilarityText analyzeSimilarityText = new AnalyzeSimilarityText(fileOneName, fileTwoName, dictionary);
        double similarity = analyzeSimilarityText.GetSimilarityValue();
        System.out.printf("Similarity = %.2f", similarity);
        FileWriteDictionary("src/ex01/result.txt", dictionary);
    }

    private void FileWriteDictionary(String fileName, HashSet<String> dictionary) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            for(String w: dictionary) {
                bufferedWriter.write(w);
                bufferedWriter.write(", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
