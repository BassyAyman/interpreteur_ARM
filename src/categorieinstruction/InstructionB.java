package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;
import instruction.Registre;

public class InstructionB extends Instruction{

    /**
     * The register declared at position 0
     */
    private Registre regPos0;

    /**
     * The register declared at position 1
     */
    private Registre regPos1;


    public InstructionB(Operation concreteOperation, Registre regPos0 , Registre regPos1) throws Exception {
        super(Categorie.B, concreteOperation);
        this.setRegPos0(regPos0);
        this.setRegPos1(regPos1);
    }


    public void setRegPos0(Registre r0) throws Exception {

        if (r0 == null ) {
            throw new RuntimeException("Trying to Set a null value in a register");
        }
        this.regPos0 = r0;
    }


    public void setRegPos1(Registre r1) throws Exception {

        if (r1 == null ) {
            throw new RuntimeException("Trying to Set a null value in a register");
        }
        this.regPos1 = r1;
    }

    @Override
    public void constructionCodeBinaire() {
        String binaryCode =  new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.regPos1.toBinaryString())
                .append(this.regPos0.toBinaryString())
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
