import java.util.Random; // Import Random class to generate random characters

public class Question2 {

    // Function to generate a random key that has the same length as the message
    public static String generateKey(String message) {

        Random rand = new Random(); // Random object used to generate random letters
        StringBuilder key = new StringBuilder(); // Used to build the key string efficiently

        // Loop through each character of the message
        for (int i = 0; i < message.length(); i++) {

            char c = message.charAt(i); // Get the current character from the message

            // If the character is a space, keep it as space in the key
            if (c == ' ') {
                key.append(' ');
            } 
            else {
                // Generate a random uppercase letter between A-Z
                key.append((char) ('A' + rand.nextInt(26)));
            }
        }

        // Return the generated key
        return key.toString();
    }

    // Function to encrypt a message using the One-Time Pad algorithm
    public static String encrypt(String message, String key) {

        StringBuilder cipher = new StringBuilder(); // Stores the encrypted text

        // Loop through each character of the message
        for (int i = 0; i < message.length(); i++) {

            char m = message.charAt(i); // Character from the message
            char k = key.charAt(i);     // Corresponding character from the key

            // If the character is a space, keep it unchanged
            if (m == ' ') {
                cipher.append(' ');
            } 
            else {

                /*
                 Encryption Formula:
                 (message letter + key letter) mod 26
                 
                 Example:
                 A = 0, B = 1, ... Z = 25
                 Result converted back to a letter
                */

                int encryptedChar = ((m - 'A') + (k - 'A')) % 26 + 'A';

                // Append encrypted character to cipher text
                cipher.append((char) encryptedChar);
            }
        }

        // Return encrypted message
        return cipher.toString();
    }

    // Function to decrypt the encrypted message using the same key
    public static String decrypt(String cipher, String key) {

        StringBuilder message = new StringBuilder(); // Stores the decrypted message

        // Loop through each character of the cipher text
        for (int i = 0; i < cipher.length(); i++) {

            char c = cipher.charAt(i); // Character from cipher text
            char k = key.charAt(i);    // Corresponding character from key

            // If the character is a space, keep it unchanged
            if (c == ' ') {
                message.append(' ');
            } 
            else {

                /*
                 Decryption Formula:
                 (cipher letter - key letter + 26) mod 26
                 
                 +26 ensures the result stays positive
                */

                int decryptedChar = ((c - 'A') - (k - 'A') + 26) % 26 + 'A';

                // Append decrypted character to the message
                message.append((char) decryptedChar);
            }
        }

        // Return the decrypted message
        return message.toString();
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Original plaintext message
        String text = "MY NAME IS UNKNOWN";

        // Generate a random key for the message
        String key = generateKey(text);
        System.out.println("Key:     " + key);

        // Encrypt the message using the generated key
        String cipher = encrypt(text, key);
        System.out.println("Cipher:  " + cipher);

        // Decrypt the cipher text using the same key
        String decrypted = decrypt(cipher, key);
        System.out.println("Decrypted: " + decrypted);
    }
}