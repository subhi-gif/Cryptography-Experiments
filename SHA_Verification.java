import java.security.MessageDigest;
import java.util.Scanner;

public class SHA_Verification {

    static String hash(String msg) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(msg.getBytes());

        StringBuilder result = new StringBuilder();
        for (byte b : bytes)
            result.append(String.format("%02x", b));

        return result.toString();
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original message: ");
        String original = sc.nextLine();

        String originalHash = hash(original);

        System.out.print("Enter message for verification: ");
        String received = sc.nextLine();

        String receivedHash = hash(received);

        System.out.println("\nOriginal Hash  : " + originalHash);
        System.out.println("Received Hash  : " + receivedHash);

        if (originalHash.equals(receivedHash))
            System.out.println("Verification: SUCCESS - Message is unchanged.");
        else
            System.out.println("Verification: FAILED - Message has been altered.");

        sc.close();
    }
}
