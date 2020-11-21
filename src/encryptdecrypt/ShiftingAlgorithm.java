package encryptdecrypt;

public class ShiftingAlgorithm extends MessageDecipher {

    public ShiftingAlgorithm(String message, int key) {
        super(message, key);
    }

    //goes through a char[] and shifts each character individually
    //then returns the completed string
    @Override
    public String encrypt() {
        char[] chars = message.toCharArray();
        StringBuilder encrypted = new StringBuilder();
        for (char c : chars) {
            encrypted.append(encryptShift(c));
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt() {
        char[] chars = message.toCharArray();
        StringBuilder decrypted = new StringBuilder();
        for (char c : chars) {
            decrypted.append(decryptShift(c));
        }
        return decrypted.toString();
    }

    //takes a chapter and shifts its value according to the encryption key
    public char encryptShift(char c) {
        int newCharValue;
        if (c >= 'a' && c <= 'z') {
            newCharValue = c + key;
            if (newCharValue > 122) {
                newCharValue = 96 + (newCharValue - 122); //min + (difference)
            }
            return (char) newCharValue;
        } else if (c >= 'A' && c <= 'Z') {
            newCharValue = c + key;
            if (newCharValue > 90) {
                newCharValue = 64 + (newCharValue - 90); //min + (difference)
            }
            return (char) newCharValue;
        }
        return c;
    }

    //takes a chapter and shifts its value according to the encryption key
    public char decryptShift(char c) {
        int newCharValue;
        if (c >= 'a' && c <= 'z') {
            newCharValue = c - key;
            if (newCharValue < 97) {
                newCharValue = 123 - (97 - newCharValue); //max - (difference)
            }
            return (char) newCharValue;
        } else if (c >= 'A' && c <= 'Z') {
            newCharValue = c - key;
            if (newCharValue < 65) {
                newCharValue = 91 - (65 - newCharValue); //MAX - (difference)
            }
            return (char) newCharValue;
        }
        return c;
    }

}
