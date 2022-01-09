import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Lecture lecture = new Lecture("test.txt");
        Interpreteur interpreteur = new Interpreteur();
        interpreteur.interpretation(lecture);

    }
}
