import java.security.SecureRandom;
import java.util.*;

class RandomPassGen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int genTime = 1;

        while (genTime == 1) {
            ClearScreen();

            System.out.println("<------------------Welcome to Random Password Generator------------------>");
            System.out.println("Do you have any string preference to Randomise the password?");
            System.out.print("Please Press 'R' for randomise system generated Password or Press 'P' for your own String Preference: ");
            char ch = input.next().charAt(0);

            if (ch == 'r' || ch == 'R') {
                randomPassGenSystem(input);
                genTime = restart(input);
            } else if (ch == 'p' || ch == 'P') {
                stringPreference(input);
                genTime = restart(input);
            } else {
                ClearScreen();
                System.out.print("Please give valid input :");
                genTime = 1;
            }
        }
        ClearScreen();
        input.close();
    }

    // For Random Password Generation by System
    public static void randomPassGenSystem(Scanner input) {
        System.out.println("Enter the desired password length:");
        int length = input.nextInt();

        System.out.println("Do you want to include Uppercase letters? (Y/N): ");
        char includeUppercase = input.next().charAt(0);

        System.out.println("Do you want to include Lowercase letters? (Y/N): ");
        char includeLowercase = input.next().charAt(0);

        System.out.println("Do you want to include Numbers? (Y/N): ");
        char includeNumbers = input.next().charAt(0);

        System.out.println("Do you want to include Special Characters? (Y/N): ");
        char includeSpecialChars = input.next().charAt(0);

        String password = generateRandomPassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Random Password: " + password);
    }

    // For user preferred Strings
    public static void stringPreference(Scanner input) {
        System.out.println("Enter the desired password length:");
        int length = input.nextInt();

        System.out.println("Enter the string to base the password on (you can mix letters, numbers, special chars):");
        String baseString = input.next();

        String password = generateCustomPassword(length, baseString);
        System.out.println("Generated Password from Your String: " + password);
    }

    // Generates a random password based on user-defined conditions
    public static String generateRandomPassword(int length, char includeUppercase, char includeLowercase, char includeNumbers, char includeSpecialChars) {
        StringBuilder charPool = new StringBuilder();

        if (includeUppercase == 'Y' || includeUppercase == 'y') {
            charPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeLowercase == 'Y' || includeLowercase == 'y') {
            charPool.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeNumbers == 'Y' || includeNumbers == 'y') {
            charPool.append("0123456789");
        }
        if (includeSpecialChars == 'Y' || includeSpecialChars == 'y') {
            charPool.append("!@#$%^&*()-_=+<>?/[]{}|\\");
        }

        if (charPool.length() == 0) {
            System.out.println("No character set selected. Exiting password generation.");
            return "";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length());
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }

    // Generates a password based on a custom string and desired length
    public static String generateCustomPassword(int length, String baseString) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(baseString.length());
            password.append(baseString.charAt(randomIndex));
        }

        return password.toString();
    }

    // To Restart the code
    public static int restart(Scanner input) {
        System.out.print("Do you want to re-generate Password again? (Yes = Y | No = N) :");
        char re = input.next().charAt(0);
        while (true) {
            if (re == 'Y' || re == 'y') {
                return 1;
            } else if (re == 'N' || re == 'n') {
                return 0;
            } else {
                System.out.println("Please type valid input :");
                re = input.next().charAt(0);
            }
        }
    }

    // To clear Screen
    public static void ClearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
