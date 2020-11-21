package encryptdecrypt;

//abstract class that can be used as a base class for
//multiple encryption algorithms
abstract class MessageDecipher {
    String message;
    int key;

    MessageDecipher(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public abstract String encrypt();

    public abstract String decrypt();
}
