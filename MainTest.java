import org.junit.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MainTest {

    @Test
    public void testGetCurrentDateTime() {
        // Here we can only verify that this method does return a LocalDateTime
        LocalDateTime currentDateTime = main.getCurrentDateTime();
        assertNotNull(currentDateTime, "Current date and time should not be null");
    }

    @Test
    public void testConvertToISO8601UTC() {
        // Setup: A known LocalDateTime value
        LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 1, 12, 0);

        // Call the method under test
        String isoString = main.convertToISO8601UTC(localDateTime);

        // Expected result calculation
        ZonedDateTime utcDateTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
        String expectedISO8601 = utcDateTime.toInstant().toString();

        // Assert the expected result
        assertEquals(expectedISO8601, isoString, "The ISO 8061 UTC time string should match the expected value");
    }
}