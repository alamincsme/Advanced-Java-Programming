package learn.alamin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounterOne {

    public static Map<String, Long> countFrequency(List<String> words) {
       return words
               .stream()
               .collect(Collectors.groupingBy(
                       Function.identity(), Collectors.counting()
               ));
    }



    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Bangladesh", "Dhaka", "Hello", "java", "Lambda");
        Map<String, Long> wordFrequency = countFrequency(words);

        for (Map.Entry<String, Long> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
