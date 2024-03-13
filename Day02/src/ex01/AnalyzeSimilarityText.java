package ex01;


import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class AnalyzeSimilarityText {
    private HashMap<String, Pair<Integer, Integer>> similarityMap = new HashMap<>();
    private HashSet<String> dictionary_ = new HashSet<>();
    private String firstFileName_;
    private String secondFileName_;

    public AnalyzeSimilarityText(String fileFirstName, String fileSecondName, HashSet<String> dictionary) {
        firstFileName_ = fileFirstName;
        secondFileName_ = fileSecondName;
        dictionary_ = dictionary;
        FillMapSimilarity();
    }

    private void FillMapSimilarity() {
        for (String w : dictionary_) {
            similarityMap.put(w, new Pair<>(0, 0));
        }
    }

    private void ExecuteAnalyseFile(String fileName, int nFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^\\w]+");
                for (String word : words) {
                    if (dictionary_.contains(word)) {
                        Pair<Integer, Integer> p = similarityMap.get(word);
                        int first = p.getKey();
                        int second = p.getValue();
                        if (nFile == 1) {
                            first += 1;
                        } else if (nFile == 2) {
                            second += 1;
                        }
                        similarityMap.replace(word, new Pair<>(first, second));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double GetSimilarityValue() {
        ExecuteAnalyseFile(firstFileName_, 1);
        ExecuteAnalyseFile(secondFileName_, 2);
        double dividend = 0.0;
        double divisor = 0.0;
        double A = 0.0;
        double B = 0.0;

        double quotient = 0.0;
        for (Pair<Integer, Integer> t : similarityMap.values()) {
            dividend += t.getKey() * t.getValue();
            A += t.getKey() * t.getKey();
            B += t.getValue() * t.getValue();
        }
        divisor = Math.sqrt(A) * Math.sqrt(B);
        quotient = dividend / divisor;

        return quotient;
    }
}
