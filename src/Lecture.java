import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecture{

    private String nomFichier;

    private Scanner scan;

    /**
     * initialise le fichier qui va etre lu
     * et le scanner.
     * @param fichier fichier a lire
     * @throws IOException
     */
    Lecture(String fichier) throws IOException {
        this.nomFichier = fichier;
        this.scan = new Scanner((new File(fichier)));
    }

    /**
     * effectue la lecture du fichier sur une ligne
     * et renvoie ligne par ligne une liste string des elements
     */
    public ArrayList<String> lecture(){
        String ligne = scan.nextLine();
        return new ArrayList<>(List.of(ligne.split(" ")));
    }


}
