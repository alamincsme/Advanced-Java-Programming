package learn.alamin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyCounter {

    public static Map<String, Long> countFrequency (List<String> words ) {

        Map<String, Long> frequencyMap = new HashMap<>();

        for (String word : words) {

//            if (! frequencyMap.containsKey(word)) {
//                frequencyMap.put(word, 1L);
//            } else {
//                Long oldCount = frequencyMap.get(word);
//                frequencyMap.put(word, oldCount + 1);
//            }
//            frequencyMap.containsKey(word) ? frequencyMap.put(word, 1L) : frequencyMap.put((word, frequencyMap.get(word)) + 1);


            frequencyMap.merge(word, 1L, (oldValue , vlaue) -> oldValue + vlaue);



        }
        return frequencyMap;
    }

    public static void main(String[] args) {
         List<String> words = Arrays.asList("Hello", "World", "Bangladesh", "Dhaka", "Hello", "java", "Lambda");
         Map<String, Long> wordFrequency = countFrequency(words);

         for (Map.Entry<String, Long> entry : wordFrequency.entrySet()) {
             System.out.println(entry.getKey() + " " + entry.getValue());
         }

    }
}
