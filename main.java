import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class main {

    /**
     * Current date and time 
     *
     * @return The current date and time
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Converts a given LocalDateTime object to an ISO 8061 UTC time string.
     *
     * @param dateTime The LocalDateTime object to convert
     * @return The ISO 8061 UTC time string representation of the given date and time
     */
    public static String convertToISO8601UTC(LocalDateTime dateTime) {
        ZonedDateTime utcDateTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
        return utcDateTime.format(DateTimeFormatter.ISO_INSTANT);
    }

    public static void main(String[] args) {
    
        LocalDateTime now = getCurrentDateTime();
        System.out.println("Current Date and Time: " + now);

        String isoDate = convertToISO8601UTC(now);
        System.out.println("ISO 8061 UTC Time String: " + isoDate);

    
    }
}
