import java.math.BigInteger;
 import java.util.Scanner;
public class DiffieHellman {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println("===== Diffie-Hellman Key Exchange =====");
 
     // Public parameters
    BigInteger p = BigInteger.valueOf(23);
    BigInteger g = BigInteger.valueOf(5);
    System.out.println("Public Prime (p) : " + p);
    System.out.println("Public Generator (g) : " + g);
 
 
   // Private keys
 System.out.print("\nEnter Alice's private key: ");
 BigInteger a = sc.nextBigInteger(); 
 
 System.out.print("Enter Bob's private key: ");
 BigInteger b = sc.nextBigInteger();
 
 // Alice calculates public key
 BigInteger A = g.modPow(a, p);
 
 // Bob calculates public key
 BigInteger B = g.modPow(b, p);
 System.out.println("\n===== Public Key Exchange =====");
 System.out.println("Alice's Public Key : " + A);
 System.out.println("Bob's Public Key : " + B);
 
 // Shared secret calculated by Alice
 BigInteger secretAlice = B.modPow(a, p);
 
 // Shared secret calculated by Bob
 BigInteger secretBob = A.modPow(b, p);
 System.out.println("\n===== Shared Secret =====");
 System.out.println("Alice's Shared Secret : " + secretAlice);
 System.out.println("Bob's Shared Secret : " + secretBob);
 if (secretAlice.equals(secretBob)) {
 System.out.println("\nKey Exchange Successful!");
 System.out.println("Both parties have established the same shared
secret.");
 } else {
 System.out.println("\nKey Exchange Failed!");
 }
 sc.close();
 }
}  