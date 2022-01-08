package instruction;

public enum Registre {
    R0(0),
    R1(1),
    R2(2),
    R3(3),
    R4(4),
    R5(5),
    R6(6),
    R7(7);

    /**
     * valeur assossier a un registre ( numero du registre )
     */
    public int value;


    private Registre(int value){
        this.value = value;
    }


    /**
     * @return representation binaire de la valeur
     */
    public String toBinaryString(){
        String val = "000" + Integer.toBinaryString(value);
        return val.substring(val.length()-3);
    }



    /**
     * @param code
     * @return  le registre correspondant a son string
     */
    public static Registre getRegistre(String code) throws Exception{
        switch (code) {
            case "R0": return Registre.R0;
            case "R1": return Registre.R1;
            case "R2": return Registre.R2;
            case "R3": return Registre.R3;
            case "R4": return Registre.R4;
            case "R5": return Registre.R5;
            case "R6": return Registre.R6;
            case "R7": return Registre.R7;
            default:
                throw new Exception("Syntax Error : Bad register name ");
        }
    }
}
