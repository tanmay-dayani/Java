import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob Java is fun",
            "10:15 charlie hello again",
            "badline"
        };

        Scanner input = new Scanner(System.in);

        System.out.print("Enter keyword: ");
        String keyword = input.nextLine();

        int matches = 0;
        StringBuilder report = new StringBuilder();

        for (String line : logs) {
            String[] parts = line.split(" ", 3);

            if (parts.length < 3) {
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            if (ChatFilter.containsKeyword(message, keyword)) {
                matches++;
                report.append(time)
                      .append(" ")
                      .append(user)
                      .append(": ")
                      .append(message)
                      .append("\n");
            }
        }

        System.out.println("Matches: " + matches);
        System.out.print(report.toString());

        input.close();
    }
}