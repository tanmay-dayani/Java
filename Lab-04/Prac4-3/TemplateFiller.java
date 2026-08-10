public class TemplateFiller {

    public static String findValue(String placeholder, String[] names, String[] values) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(placeholder)) {
                return values[i];
            }
        }

        return "[?]";
    }
}