package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;
import instruction.Registre;

public class InstructionC extends Instruction{

    private Registre Rt;

    private String imm8;

    public InstructionC(Operation operation, Registre Rt, String imm8) throws Exception{
        super(Categorie.C,operation);
        setImm8(imm8);
        setRd(Rt);
    }


    /**
     * methode qui va prendre la valeur d'un imm7
     * et va le diviser par 4.
     */
    private int divis4(int value){
        return (value/4);
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
        int val = Integer.parseUnsignedInt(imm8.replace("]","").substring(1));
        this.imm8 = toBinaryString( divis4(val));
    }

    private void setRd(Registre Rt) throws Exception {
        if (Rt == null ) {
            throw new RuntimeException("Set une valuer null de Rd");
        }

        this.Rt = Rt;
    }

    @Override
    public void constructionCodeBinaire() {
        String binaryCode =  new StringBuilder()
                .append(this.getCategorie().getCode())
                .append(this.getOperation().getCodeOp())
                .append(this.Rt.toBinaryString())
                .append(this.imm8)
                .toString();
        this.setCodeBinaire(binaryCode);
    }
}
