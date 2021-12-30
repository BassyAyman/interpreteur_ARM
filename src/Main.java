import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Lecture lecture = new Lecture("test.txt");
        ArrayList<String> liste = lecture.lecture();
        for (String s : liste) {
            System.out.println(s);
        }
    }
}
