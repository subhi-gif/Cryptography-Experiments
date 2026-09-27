
import java.math.BigInteger;
import java.util.Scanner;

public class RSA{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        //
        BigInteger p = BigInteger.valueOf(61);
        BigInteger q = BigInteger.valueOf(53);

       //calculate n = p*q
        BigInteger n = p.multiply(q);

       //calculate n=(p-1)x(q-1)
        BigInteger phi  = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

    //create a public exponent value
        BigInteger e = BigInteger.valueOf(17);
    // creat
        BigInteger d = e.modInverse(phi);

        System.out.println("===== RSA key Generation =====");
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = " + n);
        System.out.println("\nPublic key = (" + e +" ," + n +")");
        System.out.println("\nPrivate key = (" + d +" ," + n +")");

        // now enter plaintext message
        System.out.println("\nEnter a numerical message (less than " + n + ")):");
        BigInteger message = sc.nextBigInteger();
        
        //encrytion
        BigInteger ciphertext = message.modPow(e, n);
        //decrytion
        BigInteger decryptedMessage = ciphertext.modPow(d, n);

        System.out.println("\n===== RSA Encryption =====");
        System.out.println("Original Message : " + message);
        System.out.println("Encrypted Message : " + ciphertext);
        System.out.println("Decrypted Message : " + decryptedMessage);
                }
  }
} 
