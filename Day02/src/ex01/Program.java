package ex01;

import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        ReadFileInBuffer readFileInBuffer = new ReadFileInBuffer(dict);
        String f1 = "src/ex01/text_2.txt";
        String f2 = "src/ex01/text_2.txt";

        dict.addAll(readFileInBuffer.GetDictionaryFile("src/ex01/text_1.txt"));
        dict.addAll(readFileInBuffer.GetDictionaryFile("src/ex01/text_2.txt"));
        System.out.println(dict);
        AnalyzeSimilarityText analyzeSimilarityText = new AnalyzeSimilarityText(f1, f2, dict);
        double r = analyzeSimilarityText.GetSimilarityValue();
        System.out.println(r);
    }
}
