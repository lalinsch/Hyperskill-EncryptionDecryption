package encryptdecrypt;

public class UnicodeAlgorithm extends MessageDecipher {

    public UnicodeAlgorithm(String message, int key) {
        super(message, key);
    }

    //Changes the given String according to its unicode values and key value
    @Override
    public String encrypt() {
        char[] chars = message.toCharArray();
        StringBuilder encrypted = new StringBuilder();
        for (char c : chars) {
            int newCharValue = c + key;
            encrypted.append((char) newCharValue);
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt() {
        char[] chars = message.toCharArray();
        StringBuilder decrypted = new StringBuilder();
        for (char c : chars) {
            int newCharValue = c - key;
            decrypted.append((char) newCharValue);
        }
        return decrypted.toString();
    }
}
