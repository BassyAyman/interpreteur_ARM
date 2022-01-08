package categorieinstruction;

import instruction.Categorie;
import instruction.ImmOperation;
import instruction.Operation;
import instruction.Registre;

public class InstructionA2 extends Instruction {

    private String imm3;
    private Registre rn;
    private Registre rd;

    public InstructionA2(Operation operation, String imm3, Registre rn, Registre rd) throws Exception{
        super(Categorie.A2,operation);
        setImm3(imm3);
        setRd(rd);
        setRn(rn);
    }

    /**
     * ajuste le code binaire de l'imm3 en cas de depassement
     * @return representation binaire de la valeur
     */
    private String toBinaryString(int value){
        String val = "000" + Integer.toBinaryString(value);
        return val.substring(val.length()-3);
    }

    private void setImm3(String imm3){
        if(imm3 == null)
            throw new RuntimeException("set une valeur de imm3 nul");
        if(!imm3.trim().startsWith("#"))
            throw new RuntimeException("erreur syntax");
        int val = Integer.parseUnsignedInt(imm3.substring(1));
        this.imm3 = toBinaryString(val);
    }

    private void setRn(Registre rn) throws Exception {
        if (rn == null ) {
            throw new RuntimeException("Set une valuer null de Rn");
        }

        this.rn = rn;
    }

    private void setRd(Registre rd) throws Exception {
        if (rd == null ) {
            throw new RuntimeException("set une valeur null de Rd");
        }

        this.rd = rd;
    }

    @Override
    public void constructionCodeBinaire() {
        String binaryCode =  new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.imm3)
                .append(this.rn.toBinaryString())
                .append(this.rd.toBinaryString())
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
