package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;
import instruction.Registre;

public class InstructionA4 extends Instruction{

    private Registre rd;

    private String imm8;

    public InstructionA4(Operation operation, Registre rd, String imm8) throws Exception{
        super(Categorie.A4,operation);
        setImm8(imm8);
        setRd(rd);
    }

    /**
     * ajuste le code binaire de l'imm8 en cas de depassement
     * @return representation binaire de la valeur
     */
    private String toBinaryString(int value){
        String val = "00000000" + Integer.toBinaryString(value);
        return val.substring(val.length()-8);
    }

    private void setImm8(String imm8){
        if(imm8 == null)
            throw new RuntimeException("set une valeur de imm3 nul");
        if(!imm8.trim().startsWith("#"))
            throw new RuntimeException("erreur syntax");
        int val = Integer.parseUnsignedInt(imm8.substring(1));
        this.imm8 = toBinaryString(val);
    }

    private void setRd(Registre rd) throws Exception {
        if (rd == null ) {
            throw new RuntimeException("Set une valuer null de Rd");
        }

        this.rd = rd;
    }

    @Override
    public void constructionCodeBinaire() {
        String binaryCode =  new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.rd.toBinaryString())
                .append(this.imm8)
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
