package lesson10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;

public class JSonConverter {
    //  public  void getObjectFromJson() throws IOException {

    public static int countLinesInFile() throws IOException {
        String fileName = "/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/file2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        System.out.println(lines);
        return lines;
    }

    public static ArrayList<User> createUserFromFile() throws IOException {
        int lines = countLinesInFile();
        String fileName = "/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/file2.txt";
        ArrayList<User> user = new ArrayList<>();
        try (BufferedReader readerBF = new BufferedReader(new FileReader(fileName))) {
            readerBF.readLine();
            for (int i = 1; i < lines; i++) {
                String[] count = readerBF.readLine().split(" ");
                String name = count[0];
                String age = count[1];
                user.add(new User(name, Integer.parseInt(age)));
            }

            for (User u : user) {
                System.out.println(u.getName() + u.getAge());

            }
//          }
        } catch (Exception e) {
            System.err.println("error reading from file " + fileName);
            e.printStackTrace();
        }
        return user;
    }

    public static void writeUserToFile() throws IOException {
        ArrayList<User> sampleList = createUserFromFile();

        String path = "/Users/boiaryntseva/IdeaProjects/GoIt/src/resources/user.txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(sampleList);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        JSonConverter.createUserFromFile();
        JSonConverter.writeUserToFile();
    }

}
