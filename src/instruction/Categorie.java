package instruction;

/**
 * categorie d'instruction
 * A - shift add sub move (A1-register,A2-im3,A3-im5,A4-im8)
 * B - Data processing
 * C - Load/ Store
 * D - Stack pointer
 * E - Branch (E1 conditional, E2 unconditional)
 */
public enum Categorie {
    A1("00"),   // code + codop + Rm + Rn + Rd
    A2("00"),   // code + codop + imm3 + Rn + Rd
    A3("00"),    // code + codop + imm5 + Rm + Rd
    A4("00"),      // code + codop + Rd + imm8
    B("010000"),  // code + codop + registre + registre
    C("1001"),    // code + 0/1 + Rt + imm8
    D("1011"),   // code + codop + imm7
    E1("1101"),  // code + cond + imm8
    E2("11100");  // code + imm11

    private String code;


    private Categorie(String code){
        this.code = code;
    }

    /**
     * @return le code binaire d'une categorie
     */
    public String getCode(){
        return this.code;
    }
}
