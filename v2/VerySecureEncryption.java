

public class VerySecureEncryption {

    public String encrypt(String message, int[] key, int K) {
        char[] messageToEncrypt = message.toCharArray();
        char[] encryptedMessage = new char[message.length()];

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < message.length(); j++) {
                encryptedMessage[key[j]] = messageToEncrypt[j];
            }
            messageToEncrypt = encryptedMessage.clone();
        }

        return String.valueOf(messageToEncrypt);
    }

    public static void main(String args[]) {
        VerySecureEncryption verySecureEncryption = new VerySecureEncryption();
        String message = "uogcodlk";
        int[] key = {4, 3, 6, 2, 5, 1, 0, 7};
        int k = 44;

        System.out.println(verySecureEncryption.encrypt(message, key, k));
    }
}
