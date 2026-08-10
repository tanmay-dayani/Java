public class PasswordChecker {

    public static boolean hasMinimumLength(String pw) {
        return pw.length() >= 8;
    }

    public static boolean hasUppercase(String pw) {
        return pw.matches(".*[A-Z].*");
    }

    public static boolean hasDigit(String pw) {
        return pw.matches(".*[0-9].*");
    }

    public static boolean hasSpecialCharacter(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

    public static String strength(String pw) {
        int passedRules = 0;

        if (hasMinimumLength(pw)) {
            passedRules++;
        }

        if (hasUppercase(pw)) {
            passedRules++;
        }

        if (hasDigit(pw)) {
            passedRules++;
        }

        if (hasSpecialCharacter(pw)) {
            passedRules++;
        }

        if (passedRules <= 1) {
            return "Weak";
        } else if (passedRules <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}