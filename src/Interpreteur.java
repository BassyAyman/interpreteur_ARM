import categorieinstruction.Instruction;
import categorieinstruction.InstructionFactory;

import java.util.List;

/**
 * classe qui interprete les lignes de donnée une a une
 * prend une donnée d'entre, liste de string, l'analyse et renvoie les elements a
 * ecrire dans le nouveau fichier.
 */
public class Interpreteur {

    private ManagerInstruction instructionManager;

    public Interpreteur(){
        this.instructionManager = new ManagerInstruction();
    }

    public void interpretation(Lecture programe) throws Exception {

        String ligne = programe.lecture();
        int instructionPtr = 1;

        while(ligne != null){
            if(!(ligne.trim().startsWith(";") || ligne.trim().startsWith("@"))){
                try {
                    this.instructionManager.traitementLigne(ligne,instructionPtr);
                }
                catch (Exception e) {
                    throw new Exception(e.getMessage().concat(" [ On line : " + instructionPtr +" ]" ));
                }
            }

            ligne = programe.lecture();
            instructionPtr++;
        }

        List<Instruction> rom = instructionManager.getTheROM();
    }
}
