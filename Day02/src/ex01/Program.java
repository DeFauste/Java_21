package ex01;

import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        String f1 = "src/ex01/text_1.txt";
        String f2 = "src/ex01/text_2.txt";
        AnalizatorTextSimilarity textSimilarity = new AnalizatorTextSimilarity();
        textSimilarity.ShowSimilarityTwoFiles(f1,f2);
    }
}
