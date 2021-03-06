package instruction;

import java.util.Locale;

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
     * @param valeur faux si pas de # ,vrai si # dans l'expression (donc si imm)
     * @param isImm8 appliquer a adds ou subs, vrai si imm8 (SUBS3/ADDS3), faux si pas imm8
     * @return l'operation assossier
     */
    public static Operation getOperation(String label,boolean valeur,boolean isImm8) throws Exception{
        switch (label.toUpperCase(Locale.ROOT)){
            case("LSLS") : {
                if(valeur) return LSLS_A;
                else return LSLS_B;
            }
            case("LSRS") : {
                if(valeur) return LSRS_A;
                else return LSRS_B;
            }
            case("ASRS") : {
                if(valeur) return ASRS_A;
                else return ASRS_B;
            }
            case("ADDS") : {
                if(valeur){
                    if(isImm8) return ADDS3;
                    else return ADDS2;
                }else return ADDS1;
            }
            case("SUBS") : {
                if(valeur){
                    if(isImm8) return SUBS3;
                    else return SUBS2;
                }else return SUBS1;
            }
            case("CMP") : {
                if (valeur) return CMP_A;
                else return CMP_B;
            }
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
            case("b") : return B;
            // case de B avec condition
            case("bEQ") : return B_EQ;
            case("bNE") : return B_NE;
            case("bCS") : return B_CS;
            case("bHS") : return B_HS;
            case("bCC") : return B_CC;
            case("bLO") : return B_LO;
            case("bMI") : return B_MI;
            case("bPL") : return B_PL;
            case("bVS") : return B_VS;
            case("bVC") : return B_VC;
            case("bHI") : return B_HI;
            case("bLS") : return B_LS;
            case("bGE") : return B_GE;
            case("bLT") : return B_LT;
            case("bGT") : return B_GT;
            case("bLE") : return B_LE;
            case("bAL") : return B_AL;
            default:
                throw new Exception(" Syntax Error : Bad operator name ");
        }
    }
}
