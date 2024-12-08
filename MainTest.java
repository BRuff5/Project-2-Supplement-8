import org.junit.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;


public class MainTest {

    @Test
    public void testGetCurrentDateTime() {
        LocalDateTime now = main.getCurrentDateTime();
        LocalDateTime expectedNow = LocalDateTime.now(ZoneId.systemDefault());
        
        // Allow for minor differences in time (up to 1 second)
        assertTrue(now.isAfter(expectedNow.minusSeconds(1)) && now.isBefore(expectedNow.plusSeconds(1)), 
                   "The current time is not consistent with the system time");
    }

    @Test
    public void testConvertToISO8601UTC() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 20, 12, 0);
        String expectedIsoString = ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
                                    .withZoneSameInstant(ZoneId.of("UTC"))
                                    .format(DateTimeFormatter.ISO_INSTANT);
        
        String actualIsoString = main.convertToISO8601UTC(localDateTime);
        
        assertEquals(expectedIsoString, actualIsoString, "ISO 8601 conversion is incorrect");
    }

    @Test
    public void testGetDaysBetweenDates() {
        LocalDateTime startDate = LocalDateTime.of(2024, 12, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 6, 0, 0);
        
        long expectedDaysBetween = 5; // 6th is not included in the range
        long actualDaysBetween = main.getDaysBetweenDates(startDate, endDate);
        
        assertEquals(expectedDaysBetween, actualDaysBetween, "Days between dates calculation is incorrect");
    }

    @Test
    public void testGetDaysBetweenDates_NegativeDifference() {
        LocalDateTime startDate = LocalDateTime.of(2024, 12, 6, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 1, 0, 0);
        
        long expectedDaysBetween = -5; // 1st is not included in range, hence 6th - 1st will yield -5
        long actualDaysBetween = main.getDaysBetweenDates(startDate, endDate);
        
        assertEquals(expectedDaysBetween, actualDaysBetween, "Days between dates calculation should be negative");
    }
}