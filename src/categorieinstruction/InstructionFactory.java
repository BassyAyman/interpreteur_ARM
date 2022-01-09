package categorieinstruction;

import instruction.Operation;
import instruction.Registre;

import java.util.concurrent.ExecutionException;

public class InstructionFactory {

    public InstructionFactory(){}

    /**
     * verifie si dans l'instruction adds ou subs il y a la presence d'un caractere
     * [ ou ] qui signifierai qu'il s'agit d'une instruction imm8 et donc
     * renvoie true, false sinon
     */
    private boolean isImm8String(String line){
        String[] tab = line.split(" ");
        for (String partie: tab) {
            if(partie.contains("[") || partie.contains("]")) return true;
        }
        return false;
    }

    private boolean isImmIn(String line){
        return line.contains("#");
    }

    /**
     * renvoie l'instruction etablie apres lecture.
     */
    public Instruction getInstruction(String line, int lineNumber) throws Exception{

        String lineToProcess = line.trim();

        int firstSepPosition = lineToProcess.indexOf(" ");

        String instrWord = lineToProcess.substring(0,firstSepPosition);

        Operation operation = Operation.getOperation(instrWord,isImmIn(lineToProcess),isImm8String(lineToProcess));

        if(operation == null) throw new Exception("Syntax Error : Unknow Operation "+instrWord);

        String operandesString = lineToProcess.substring(firstSepPosition).trim();

        return switch (operation.getCategorie()) {
            case A1 -> buildInstCatA1(operation, operandesString);
            case A2 -> buildInstCatA2(operation, operandesString);
            case A3 -> buildInstCatA3(operation, operandesString);
            case A4 -> buildInstCatA4(operation, operandesString);
            case B -> buildInstCatB(operation, operandesString);
            case C -> buildInstCatC(operation, operandesString);
            case D -> buildInstCatD(operation, operandesString);
            default -> throw new RuntimeException(" Unknow Instruction categorie");
        };

    }

    public Instruction buildInstCatA1(Operation op, String operandesString) throws Exception {

        String [] operandesTab = processOperands(operandesString,3);

        Registre rd = Registre.getRegistre(operandesTab[0].trim());
        Registre rn = Registre.getRegistre(operandesTab[1].trim());
        Registre rm = Registre.getRegistre(operandesTab[2].trim());

        return new InstructionA1(op, rm, rn, rd);
    }

    public Instruction buildInstCatA2(Operation op, String operandesString) throws Exception {

        String [] operandesTab = processOperands(operandesString,3);

        Registre rd = Registre.getRegistre(operandesTab[0].trim());
        Registre rm = Registre.getRegistre(operandesTab[1].trim());
        String imm3 = operandesTab[2].trim();

        return new InstructionA2(op,imm3,rm,rd);
    }

    public Instruction buildInstCatA3(Operation op, String operandesString) throws Exception {

        String [] operandesTab = processOperands(operandesString,3);

        Registre rd = Registre.getRegistre(operandesTab[0].trim());
        Registre rm = Registre.getRegistre(operandesTab[1].trim());
        String imm5 = operandesTab[2].trim();

        return new InstructionA3(op,imm5,rm,rd);
    }

    public Instruction buildInstCatA4(Operation op, String operandesString) throws Exception{

        String [] operandesTab = processOperands(operandesString,2);

        Registre rd = Registre.getRegistre(operandesTab[0].trim());
        String imm8 = operandesTab[1].trim();

        return new InstructionA4(op,rd,imm8);
    }

    public Instruction buildInstCatB(Operation op, String operandesString) throws Exception{
        String [] operandesTab;
        if(op.getCodeOp().equals("1001") || op.getCodeOp().equals("1101")){
            operandesTab = processOperands(operandesString,3);
        }else {operandesTab = processOperands(operandesString,2);}

        Registre regPos0 = Registre.getRegistre(operandesTab[0].trim());
        Registre regPos1 = Registre.getRegistre(operandesTab[1].trim());

        return new InstructionB(op,regPos0,regPos1);

    }

    public Instruction buildInstCatC(Operation op, String operandesString) throws Exception{
        String [] operandesTab = processOperands(operandesString,3);

        Registre rt = Registre.getRegistre(operandesTab[0].trim());
        //a voir ici pour la maj des variables
        String imm8 = operandesTab[2].trim();

        return new InstructionC(op,rt,imm8);
    }

    public Instruction buildInstCatD(Operation op, String operandesString) throws Exception{
        String [] operandesTab = processOperands(operandesString,2); // bizarre dans la doc c 3 dans les tests c'est 2
        String imm7 = operandesTab[1].trim();

        return new InstructionD(op,imm7);
    }

    private String [] processOperands(String opString, int NbOprandsRequired ) throws Exception{

        String [] opTab = opString.split(",");

        if (opTab.length != NbOprandsRequired) {
            throw new Exception("Syntax Error : Bad number of operandes");
        }
        return opTab;
    }



}
