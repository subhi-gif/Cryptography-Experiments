import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.util.Base64;

public class SecurityDemo {

    // SHA-256 Hash Function
    public static String generateHash(String message) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = md.digest(message.getBytes());

        StringBuilder hash = new StringBuilder();

        for (byte b : hashBytes) {
            hash.append(String.format("%02x", b));
        }

        return hash.toString();
    }

    public static void main(String[] args) throws Exception {

        // Original message
        String message = "Hello BTech Students";

        // ---------------- SHA-256 ----------------

        String originalHash = generateHash(message);

        // ---------------- AES ENCRYPTION ----------------

        // Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);

        SecretKey secretKey = keyGenerator.generateKey();

        // Create AES cipher
        Cipher cipher = Cipher.getInstance("AES");

        // Encrypt message
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes =
                cipher.doFinal(message.getBytes());

        String encryptedMessage =
                Base64.getEncoder().encodeToString(encryptedBytes);

        // ---------------- AES DECRYPTION ----------------

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedBytes =
                cipher.doFinal(encryptedBytes);

        String decryptedMessage =
                new String(decryptedBytes);

        // ---------------- SHA-256 VERIFICATION ----------------

        String decryptedHash = generateHash(decryptedMessage);

        boolean verified = originalHash.equals(decryptedHash);

        // ---------------- OUTPUT ----------------

        System.out.println("Original Message : " + message);

        System.out.println("\nAES Encryption");
        System.out.println("Encrypted Text  : " + encryptedMessage);

        System.out.println("\nAES Decryption");
        System.out.println("Decrypted Text  : " + decryptedMessage);

        System.out.println("\nSHA-256 Verification");

        System.out.println("Original Hash   : " + originalHash);
        System.out.println("Decrypted Hash  : " + decryptedHash);

        if (verified) {
            System.out.println("Verification    : SUCCESS");
            System.out.println("Message is unchanged.");
        } else {
            System.out.println("Verification    : FAILED");
            System.out.println("Message has been modified.");
        }
    }
}
