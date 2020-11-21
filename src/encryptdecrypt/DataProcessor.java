package encryptdecrypt;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

//This class has methods that process the data after they've been passed as arguments
public class DataProcessor {
    String command;
    int key;
    String data;
    String mode;
    String inputFile;
    String outputFile;
    String decipheredMessage;
    MessageDecipher messageDecipher;
    boolean hasValidArguments;

    //public constructor
    public DataProcessor(String command, int key, String data, String mode, String inputFile, String outputFile) {
        this.command = command;
        this.key = key;
        this.mode = mode;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.hasValidArguments = true;
        if (hasInputFile()) try {
            this.data = new String(Files.readAllBytes(Paths.get(inputFile)));
        } catch (Exception e) {
            hasValidArguments = false;
            System.out.println("Error" + e);
        }
        else {
            this.data = data;
        }
    }

    //simple method to validate certain conditions of the programme to run - can be expanded
    public void validateInput() {
        if (key > 10 || key < 0) {
            hasValidArguments = false;
            System.out.println("Input error: Key has to be between 0 and 10");
        }
    }

    //uses the MessageDecipherFactory to choose the algorithm nad return a result to console or external file
    public void process() {
        validateInput();
        if (hasValidArguments) {
            messageDecipher = MessageDecipherFactory.setAlgorithm(mode, data, key);
            decipheredMessage = "enc".equals(command) ? messageDecipher.encrypt() : messageDecipher.decrypt();
            outputResult();
        } else {
            System.out.println("Invalid arguments");
        }
    }

    //checks if the input/output files are present in the arguments
    public boolean hasInputFile() {
        return !(inputFile == null);
    }

    public boolean hasOutputFile() {
        return !(outputFile == null);
    }

    //returns the output to either an external file or to the console depending on the arguments
    public void outputResult() {
        if (hasOutputFile()) {
            File output = new File(outputFile);
            try (PrintWriter printWriter = new PrintWriter(output)) {
                printWriter.println(decipheredMessage);
            } catch (Exception e) {
                System.out.println("Error, something wrong with output." + e);
            }
        } else {
            System.out.println(decipheredMessage);
        }
    }
}
