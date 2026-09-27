import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.util.Base64;

public class AES {

    public static void main(String[] args) throws Exception {

        // Text message
        String message = "Hello BTech Students";

        // ---------------- AES ENCRYPTION ----------------

        // Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        // Create AES cipher
        Cipher cipher = Cipher.getInstance("AES");

        // Encrypt the message
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

        // Convert encrypted data to readable text
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);

        // Decrypt the message
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        String decryptedMessage = new String(decryptedBytes);

        // ---------------- SHA-256 HASHING ----------------

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = md.digest(message.getBytes());

        // Convert hash to hexadecimal
        StringBuilder hash = new StringBuilder();

        for (byte b : hashBytes) {
            hash.append(String.format("%02x", b));
        }

        // ---------------- OUTPUT ----------------

        System.out.println("Original Message : " + message);

        System.out.println("\nAES Encryption");
        System.out.println("Encrypted Text  : " + encryptedMessage);
        System.out.println("Decrypted Text  : " + decryptedMessage);

        System.out.println("\nSHA-256 Hashing");
        System.out.println("SHA-256 Hash    : " + hash);
    }
}