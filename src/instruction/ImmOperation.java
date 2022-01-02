package instruction;

public enum ImmOperation {
    imm0(0),
    imm3(3),
    imm5(5),
    imm8(8),
    imm11(11);

    public int valeur;

    ImmOperation(int valeur){
        this.valeur=valeur;
    }

    public int getValeur() {
        return valeur;
    }
}
