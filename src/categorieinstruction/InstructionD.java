package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;
import instruction.Registre;

public class InstructionD extends Instruction{

    private String imm7;

    public InstructionD(Operation operation, String imm7) throws Exception{
        super(Categorie.D,operation);
        setImm7(imm7);
    }

    /**
     * ajuste le code binaire de l'imm8 en cas de depassement
     * @return representation binaire de la valeur
     */
    private String toBinaryString(int value){
        String val = "0000000" + Integer.toBinaryString(value);
        return val.substring(val.length()-7);
    }

    private void setImm7(String imm7){
        if(imm7 == null)
            throw new RuntimeException("set une valeur de imm3 nul");
        if(!imm7.trim().startsWith("#"))
            throw new RuntimeException("erreur syntax");
        int val = Integer.parseUnsignedInt(imm7.substring(1));
        this.imm7 = toBinaryString(val);
    }

    @Override
    public void constructionCodeBinaire() {
        String binaryCode =  new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.imm7)
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
