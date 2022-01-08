package categorieinstruction;

import instruction.Categorie;
import instruction.Operation;

public abstract class Instruction {

    /**
     * represente la categorie de l'instruction, permet de determiner lle type de l'instruction
     */
    private Categorie categorie;

    /**
     * represente l'operation de l'instruction, permet de determiner la categorie de l'instruction.
     */
    private Operation operation;

    /**
     * representation binaire de l'instruction completer
     */
    private String codeBinaire;

    public Instruction(Categorie categorie, Operation operation) throws Exception{
       if( operation != null && operation.getCategorie() != categorie)
           throw new RuntimeException("l'instruction ne match pas avec la categorie");
       this.setCategorie(categorie);
       this.setOperation(operation);
    }

    protected void setCategorie(Categorie categorie) throws Exception {
        if( categorie == null )
            throw new RuntimeException("categorie null");
        this.categorie = categorie;
    }

    protected void setOperation(Operation operation) {
        if( operation == null )
            throw new RuntimeException("Operation null");
        this.operation = operation;
    }
    protected void setCodeBinaire(String binaryStringCode) {

        if (binaryStringCode == null || binaryStringCode.length()!=16) {
            throw new RuntimeException("binary String Code setting Error");
        }
        this.codeBinaire = binaryStringCode;
    }

    public abstract void constructionCodeBinaire();

    public String getBinaireStringCode(){
        return codeBinaire;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Operation getOperation() {
        return operation;
    }

    public String toBinaireCode(){
        this.constructionCodeBinaire();
        return this.getBinaireStringCode();
    }


}
