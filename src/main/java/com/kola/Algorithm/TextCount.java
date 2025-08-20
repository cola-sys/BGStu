package com.kola.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TextCount {
    public static void main(String[] args) {
        case1();
        System.out.println("=================");
        case2();
    }

    public static void case1() {
        String text = "hello world!hello java. java is powerful,and java is popular.";
        String words = text.replaceAll("[^a-z\\s]", " ");
        String[] s = words.trim().split("\\s+");
        Map<String, Integer> count = new HashMap<>();
        for (String word : s) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        Set<Map.Entry<String, Integer>> entries = count.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    public static void case2() {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 小写 + 替换标点为空格
                line = line.toLowerCase().replaceAll("[^a-z\\s]", " ");
                // 分割单词
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    if (word.isEmpty()) continue;
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 输出词频
        wordCount.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
