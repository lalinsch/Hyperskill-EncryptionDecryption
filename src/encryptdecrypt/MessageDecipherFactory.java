package encryptdecrypt;

public class MessageDecipherFactory {

    //returns one of the algorithm classes depending on the input
    public static MessageDecipher setAlgorithm(String mode, String message, int key) {
        switch (mode.toLowerCase()) {
            case "unicode":
                return new UnicodeAlgorithm(message, key);
            case "shift":
                return new ShiftingAlgorithm(message, key);
            default:
                //if there's no valid input, it defaults to the shifting algorithm
                System.out.println("Invalid input, using Shift as default");
                return new ShiftingAlgorithm(message, key);
        }
    }
}
