import categorieinstruction.Instruction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class EcriveurFichier {


    private FileWriter createNewFile(String filename, String extension) throws IOException {

        FileWriter fileWriter;

        fileWriter = new FileWriter(Paths.get( System.getProperty("user.dir") + System.getProperty("file.separator") + filename + extension).normalize().toFile());

        return fileWriter;
    }

    private void appendInFile(String contenue, String spacer, FileWriter fileWriter) throws Exception{
        try {
            fileWriter.append(contenue + spacer);
        } catch (IOException e) {
            throw new Exception("unable to append data to log file.");
        }
    }

    private void closeFile(FileWriter fileWriter) throws Exception {
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new Exception("unable to release log file handle.");
        }
    }

    public void createROMFile(List<Instruction> list , String filename, String fileExtension) throws Exception{

        FileWriter fileWriter= createNewFile(filename,fileExtension);

        appendInFile("v2.0 raw","\n",fileWriter);

        for (Instruction instruction : list) {
            appendInFile(String.valueOf(instruction.toHexCode())," ",fileWriter);
        }

        closeFile(fileWriter);
    }
}
