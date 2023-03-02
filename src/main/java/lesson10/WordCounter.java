package main.java.lesson10;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

        //Scanner s = new Scanner(new File("/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/words.txt"));
        String basePath=System.getProperty("user.dir");
        Scanner s = new Scanner(new File(basePath+"/src/main/java/resources/words.txt"));
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

        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(countByWords.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        countByWords.clear();
        for (Map.Entry<String, Integer> entry : entryList) {
            countByWords.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
