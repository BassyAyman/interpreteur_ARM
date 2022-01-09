import java.io.File;
import java.io.IOException;
import java.util.*;

public class Lecture{

    private String nomFichier;

    public String getNomFichier() {
        return nomFichier;
    }

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
    public String lecture(){
        try{
            return scan.nextLine();
        }
        catch(NoSuchElementException e){
            System.out.println("fin lecture fichier");
            scan.close();
            return null;
        }
    }

}
