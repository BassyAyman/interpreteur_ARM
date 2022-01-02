package instruction;

public enum Operation {
    // categorie A - shift add sub move [ A1 - register/ A2 - Imm3/ A3 - Imm5/ A4 - Imm8]
    LSLS_A("000",Categorie.A3),
    LSRS_A("001",Categorie.A3),
    ASRS_A("010",Categorie.A3),
    ADDS1("01100",Categorie.A1),
    SUBS1("01101",Categorie.A1),
    ADDS2("01110",Categorie.A2),
    SUBS2("01111",Categorie.A2),
    ADDS3("110",Categorie.A4),
    SUBS3("111",Categorie.A4),
    MOVS("100",Categorie.A4),
    CMP_A("101",Categorie.A4),

    // categorie B - Data processing

    ANDS("0000",Categorie.B),
    EORS("0001",Categorie.B),
    LSLS_B("0010",Categorie.B),
    LSRS_B("0011",Categorie.B),
    ASRS_B("0100",Categorie.B),
    ADCS("0101",Categorie.B),
    SBCS("0110",Categorie.B),
    RORS("0111",Categorie.B),
    TST("1000",Categorie.B),
    RSBS("1001",Categorie.B),
    CMP_B("1010",Categorie.B),
    CMN("1011",Categorie.B),
    ORRS("1100",Categorie.B),
    MULS("1101",Categorie.B),
    BICS("1110",Categorie.B),
    MVNS("1111",Categorie.B),

    // categorie C - Load/Store

    STR("0",Categorie.C),
    LDR("1",Categorie.C),

    // categorie D - pointeur

    ADD("00000",Categorie.D),
    SUB("00001",Categorie.D),

    // categorie E1 - Conditional Branch ( codop sur les Conditions)

    B_EQ("0000",Categorie.E1),
    B_NE("0001",Categorie.E1),
    B_CS("0010",Categorie.E1),B_HS("0010",Categorie.E1),
    B_CC("0011",Categorie.E1),B_LO("0011",Categorie.E1),
    B_MI("0100",Categorie.E1),
    B_PL("0101",Categorie.E1),
    B_VS("0110",Categorie.E1),
    B_VC("0111",Categorie.E1),
    B_HI("1000",Categorie.E1),
    B_LS("1001",Categorie.E1),
    B_GE("1010",Categorie.E1),
    B_LT("1011",Categorie.E1),
    B_GT("1100",Categorie.E1),
    B_LE("1101",Categorie.E1),
    B_AL("1110",Categorie.E1),

    // categorie E2 - Unconditional Branch

    B("",Categorie.E2);


    /**
     * codop en String
     */
    private String codeOp;


    /**
     * Categorie de l'operation
     */
    private Categorie categorie;



    private Operation(String codeOp, Categorie cat){
        this.codeOp = codeOp;
        this.categorie=cat;
    }


    /**
     * @return codop d'une operation
     */
    public String getCodeOp(){
        return this.codeOp;
    }


    /**
     * @return categorie de l'instruction
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param label etiquette associer a l'operation
     * @param imm immediate de cette operation, 0 si registre
     * @return l'operation assossier
     */
    public static Operation getOperation(String label,ImmOperation imm) throws Exception{
        switch (label){
            case("LSLS") : {
                if(imm == ImmOperation.imm5) return LSLS_A;
                else return LSLS_B;
            }
            case("LSRS") : {
                if(imm == ImmOperation.imm5) return LSRS_A;
                else return LSRS_B;
            }
            case("ASRS") : {
                if(imm == ImmOperation.imm5) return ASRS_A;
                else return ASRS_B;
            }
            case("ADDS") : {
                if (imm == ImmOperation.imm0) return ADDS1;
                else if(imm == ImmOperation.imm3) return  ADDS2;
                else return ADDS3;
            }
            case("SUBS") : {
                if (imm == ImmOperation.imm0) return SUBS1;
                else if(imm == ImmOperation.imm3) return  SUBS2;
                else return SUBS3;
            }
            case("CMP") : {
                if (imm == ImmOperation.imm8) return CMP_A;
                else return CMP_B;
            }
            default:
                throw new Exception(" Syntax Error : Bad operator name ");
        }
    }

    public static Operation getOperation(String label) throws Exception{
        switch (label){
            case("MOVS") : return MOVS;
            case("ANDS") : return ANDS;
            case("EORS") : return EORS;
            case("ADCS") : return ADCS;
            case("SBCS") : return SBCS;
            case("RORS") : return RORS;
            case("TST") : return TST;
            case("RSBS") : return RSBS;
            case("CMN") : return CMN;
            case("ORRS") : return ORRS;
            case("MULS") : return MULS;
            case("BICS") : return BICS;
            case("MVNS") : return MVNS;
            case("STR") : return STR;
            case("LDR") : return LDR;
            case("ADD") : return ADD;
            case("SUB") : return SUB;
            case("B") : return B;
            // case de B avec condition
            case("B<EQ>") : return B_EQ;
            case("B<NE>") : return B_NE;
            case("B<CS>") : return B_CS;
            case("B<HS>") : return B_HS;
            case("B<CC>") : return B_CC;
            case("B<LO>") : return B_LO;
            case("B<MI>") : return B_MI;
            case("B<PL>") : return B_PL;
            case("B<VS>") : return B_VS;
            case("B<VC>") : return B_VC;
            case("B<HI>") : return B_HI;
            case("B<LS>") : return B_LS;
            case("B<GE>") : return B_GE;
            case("B<LT>") : return B_LT;
            case("B<GT>") : return B_GT;
            case("B<LE>") : return B_LE;
            case("B<AL>") : return B_AL;

            default:
                throw new Exception(" Syntax Error : Bad operator name ");
        }
    }
}
