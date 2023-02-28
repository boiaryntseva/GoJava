package lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomFileReader {

    public static void writeAllMatchingTelNumbers() throws IOException{
        Path fileName = Path.of("/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/file.txt");

        String str = Files.readString(fileName);

        Pattern pattern = Pattern.compile("[1-9]\\d{2}[-][1-9]\\d{2}[-]\\d{4}|[(][1-9]\\d{2}[)][-][1-9]\\d{2}[-]\\d{4}");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    public static void main(String[] args) throws IOException {
      CustomFileReader.writeAllMatchingTelNumbers();

    }

}
