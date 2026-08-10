public class Driver {

    public static void main(String[] args) {

        String[] passwords = {
            "abc",
            "abcdefgh",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String password : passwords) {

            System.out.println("-----------------------------");
            System.out.println("Password: " + password);

            System.out.println("Length >= 8: " 
                    + PasswordChecker.hasMinimumLength(password));

            System.out.println("Has uppercase: " 
                    + PasswordChecker.hasUppercase(password));

            System.out.println("Has digit: " 
                    + PasswordChecker.hasDigit(password));

            System.out.println("Has special character: " 
                    + PasswordChecker.hasSpecialCharacter(password));

            System.out.println("Strength: " + PasswordChecker.strength(password));
        }
    }
}