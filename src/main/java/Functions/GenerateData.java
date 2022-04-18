package Functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateData {
    public static String generateString () {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dateTimeFormatter);
    }

    public static String generateRandomEmail (String email) {
        String[] parts = email.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        return part1 + generateString() + "@" + part2;
    }
}
