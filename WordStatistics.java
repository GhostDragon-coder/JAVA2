import java.io.*;
import java.util.*;

public class WordStatistics {
    public static void main(String[] args) {
        String fileName = "C:\\!Desktop\\JAVA\\first-project\\src\\test\\java\\input.txt";

        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    if (!word.isEmpty()) {
                        words.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(STR."Ошибка при чтении файла: \{e.getMessage()}");
            return;
        }

        Map<String, Integer> frequencyMap = new TreeMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Статистика повторений слов (слова отсортированы по алфавиту):");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        String maxWord = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        if (maxWord != null) {
            System.out.println(STR."\nСлово с максимальным количеством повторений: \{maxWord} (\{maxCount} раз)");
        } else {
            System.out.println("Файл не содержит слов.");
        }
    }
}
