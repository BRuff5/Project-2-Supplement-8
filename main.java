import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

    /**
     * Calculates the number of days between two dates.
     *
     * @param startDate The start date - LocalDateTime object.
     * @param endDate   The end date - LocalDateTime object.
     * @return The number of days between the two dates
     */
    public static long getDaysBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public static void main(String[] args) {
    
        LocalDateTime now = getCurrentDateTime();
        System.out.println("Current Date and Time: " + now);

        String isoDate = convertToISO8601UTC(now);
        System.out.println("ISO 8061 UTC Time String: " + isoDate);

        LocalDateTime startDate = LocalDateTime.of(2024, 12, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 6, 0, 0);
        long daysBetween = getDaysBetweenDates(startDate, endDate);
        System.out.println("Days Between " + startDate + " and " + endDate + ": " + daysBetween);
    }

}
