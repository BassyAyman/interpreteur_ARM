import categorieinstruction.Instruction;
import categorieinstruction.InstructionFactory;

import java.util.ArrayList;
import java.util.List;

public class ManagerInstruction {

    private List<Instruction> romListeInstruction;

    private InstructionFactory instructionFactory;

    public ManagerInstruction(){
        this.romListeInstruction = new ArrayList<>();
        instructionFactory = new InstructionFactory();
    }

    /**
     * fait le traitement total d'une ligne
     * traitement label a venir
     * @param ligne
     * @param ligneNumero
     * @throws Exception
     */
    public void traitementLigne(String ligne,int ligneNumero) throws Exception {

        Instruction instruction = instructionFactory.getInstruction(ligne,ligneNumero);
        this.romListeInstruction.add(instruction);

    }

    /**
     * @return renvoie la rom
     */
    public List<Instruction> getTheROM(){
        return this.romListeInstruction;
    }
}
