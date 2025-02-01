import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        String strength = checkPasswordStrength(password);
        
        System.out.println("Password Strength: " + strength);
        
        scanner.close();
    }
    
    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        
        if (length >= 12 && hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Very Strong";
        } else if (length >= 10 && hasUpper && hasLower && hasDigit) {
            return "Strong";
        } else if (length >= 8 && (hasUpper || hasLower) && hasDigit) {
            return "Moderate";
        } else if (length >= 6) {
            return "Weak";
        } else {
            return "Very Weak";
        }
    }
}
