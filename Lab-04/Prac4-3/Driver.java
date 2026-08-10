import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {

    public static void main(String[] args) {

        String template = "Dear {name}, order {id} ships {date}.";

        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String placeholder = matcher.group(1);
            String replacement = TemplateFiller.findValue(placeholder, names, values);

            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result);

        System.out.println(result.toString());
    }
}