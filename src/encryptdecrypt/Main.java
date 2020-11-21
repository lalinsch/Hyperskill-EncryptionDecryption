package encryptdecrypt;

import java.util.HashMap;

public class Main {
    //A hashmpa that stores all the arguments in pairs (key, value)
    public static HashMap<String, String> arguments = new HashMap<>();

    public static void main(String[] args) {

        //takes all the args[] input and stores in hashmap
        for (int i = 0; i < args.length; i += 2) {
            arguments.put(args[i], args[i + 1]);
        }
//         --Testing arguments--
//        arguments.put("-mode", "enc");
//        arguments.put("-key", "-5");
//        arguments.put("-alg", "unicode");
//        arguments.put("-data", "Hello world");

        //Finds the values or sets the default for each argument and stores it in a variable
        String command = arguments.getOrDefault("-mode", "enc");
        int key = Integer.parseInt(arguments.getOrDefault("-key", "0"));
        String data = arguments.getOrDefault("-data", "");
        String mode = arguments.getOrDefault("-alg", "shift");
        String inputFile = arguments.getOrDefault("-in", null);
        String outputFile = arguments.getOrDefault("-out", null);

        //creates a data processor to process the arguments and return the result
        new DataProcessor(command, key, data, mode, inputFile, outputFile).process();
    }

}
