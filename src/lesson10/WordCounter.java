package lesson10;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) throws IOException {
//        Arrays.stream(new String(Files.readAllBytes(Path.of("/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/words.txt")), StandardCharsets.UTF_8).split("\\W+"))
//                .collect(Collectors.groupingBy(Function.<String>identity(), HashMap::new, counting()))
//                .entrySet()
//                .stream()
//                .sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue())))
//                .forEach(System.out::println);
//    }
        Map<String, Integer> countByWords = new HashMap<>();
        Scanner s = new Scanner(new File("/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/words.txt"));
        while (s.hasNext()) {
            String next = s.next();
            Integer count = countByWords.get(next);
            if (count != null) {
                countByWords.put(next, count + 1);
            } else {
                countByWords.put(next, 1);
            }
        }
        s.close();
        countByWords.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

}
