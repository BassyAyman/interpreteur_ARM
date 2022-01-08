package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;
import instruction.Registre;

public class InstructionA3 extends Instruction{

    private String imm5;
    private Registre rn;
    private Registre rd;

    public InstructionA3(Operation operation, String imm5, Registre rn, Registre rd) throws Exception{
        super(Categorie.A3,operation);
        setImm5(imm5);
        setRd(rd);
        setRn(rn);
    }

    /**
     * ajuste le code binaire de l'imm3 en cas de depassement
     * @return representation binaire de la valeur
     */
    private String toBinaryString(int value){
        String val = "00000" + Integer.toBinaryString(value);
        return val.substring(val.length()-5);
    }

    private void setImm5(String imm5){
        if(imm5 == null)
            throw new RuntimeException("set une valeur de imm3 nul");
        if(!imm5.trim().startsWith("#"))
            throw new RuntimeException("erreur syntax");
        int val = Integer.parseUnsignedInt(imm5.substring(1));
        this.imm5 = toBinaryString(val);
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
                .append(this.imm5)
                .append(this.rn.toBinaryString())
                .append(this.rd.toBinaryString())
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
