import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Choose two prime numbers
        BigInteger p = BigInteger.valueOf(61);
        BigInteger q = BigInteger.valueOf(53);

        // Step 2: Multiply p and q
        BigInteger n = p.multiply(q);

        // Step 3: Calculate phi = (p-1)(q-1)
        BigInteger phi = p.subtract(BigInteger.ONE)
                          .multiply(q.subtract(BigInteger.ONE));

        // Step 4: Choose public exponent
        BigInteger e = BigInteger.valueOf(17);

        // Step 5: Calculate private key d = e^-1 mod phi
        BigInteger d = e.modInverse(phi);

        // Display RSA keys
        System.out.println("====== RSA Key Generation ======");
        System.out.println("P = " + p);
        System.out.println("Q = " + q);
        System.out.println("N = " + n);
        System.out.println("Phi = " + phi);

        System.out.println("\nPublic Key = (" + e + ", " + n + ")");
        System.out.println("Private Key = (" + d + ", " + n + ")");

        // Input message
        System.out.print("\nEnter a numerical message (less than " + n + "): ");
        BigInteger message = sc.nextBigInteger();

        // Check message
        if (message.compareTo(n) >= 0 || message.compareTo(BigInteger.ZERO) < 0) {
            System.out.println("Message must be between 0 and " + (n.subtract(BigInteger.ONE)));
            sc.close();
            return;
        }

        // Encryption
        BigInteger ciphertext = message.modPow(e, n);

        // Decryption
        BigInteger decryptedMessage = ciphertext.modPow(d, n);

        // Display results
        System.out.println("\n===== RSA Encryption =====");
        System.out.println("Original Message  : " + message);
        System.out.println("Encrypted Message : " + ciphertext);
        System.out.println("Decrypted Message : " + decryptedMessage);

        sc.close();
    }

}
