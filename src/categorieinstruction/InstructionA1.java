package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;
import instruction.Registre;

public class InstructionA1 extends Instruction{

    private Registre rm;
    private Registre rn;
    private Registre rd;

    public InstructionA1(Operation operation, Registre rm, Registre rn, Registre rd) throws Exception{
        super(Categorie.A1,operation);
        setRm(rm);
        setRn(rn);
        setRd(rd);
    }

    public void setRm(Registre rm) throws Exception {
        if (rm == null ) {
            throw new RuntimeException("Essaye de set une valeur null pour le registre rm");
        }
        this.rm = rm;
    }

    public void setRn(Registre rn) throws Exception {

        if (rn == null ) {
            throw new RuntimeException("Trying to Set a null value in a Rn register");
        }
        this.rn = rn;
    }

    public void setRd(Registre rd) throws Exception {
        if (rd == null ) {
            throw new RuntimeException("Trying to Set a null value in a Rd register");
        }
        this.rd = rd;
    }

    @Override
    public void constructionCodeBinaire() {
        String codeBinaire = new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.rm.toBinaryString())
                .append(this.rn.toBinaryString())
                .append(this.rd.toBinaryString())
                .toString();
        this.setCodeBinaire(codeBinaire);
    }
}
