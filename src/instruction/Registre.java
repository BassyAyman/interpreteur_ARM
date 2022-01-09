package instruction;

import java.util.Locale;

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
        return switch (code.toUpperCase(Locale.ROOT).replace("[", "")) {
            case "R0" -> Registre.R0;
            case "R1" -> Registre.R1;
            case "R2" -> Registre.R2;
            case "R3" -> Registre.R3;
            case "R4" -> Registre.R4;
            case "R5" -> Registre.R5;
            case "R6" -> Registre.R6;
            case "R7" -> Registre.R7;
            default -> throw new Exception("Syntax Error : Bad register name ");
        };
    }
}
