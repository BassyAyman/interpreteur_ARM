package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;

public class InstructionE2 extends Instruction{

    private String imm11;

    public InstructionE2(Categorie categorie, Operation operation, String imm11) throws Exception {
        super(categorie, operation);
        setImm11(imm11);
    }

    /**
     * ajuste le code binaire de l'imm8 en cas de depassement
     * @return representation binaire de la valeur
     */
    private String toBinaryString(int value){
        String val = "00000000000" + Integer.toBinaryString(value);
        return val.substring(val.length()-11);
    }

    private void setImm11(String imm11){
        if(imm11 == null)
            throw new RuntimeException("set une valeur de imm3 nul");
        if(!imm11.trim().startsWith("#"))
            throw new RuntimeException("erreur syntax");
        int val = Integer.parseUnsignedInt(imm11.substring(1));
        this.imm11 = toBinaryString(val);
    }

    @Override
    public void constructionCodeBinaire() {
        String binaryCode =  new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.imm11)
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
