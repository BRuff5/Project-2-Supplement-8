import org.junit.*;

import java.time.LocalDateTime;

public class MainTest {

    @Test
    public void testGetCurrentDateTime() {
        // Call the method to test
        LocalDateTime now = main.getCurrentDateTime();

        // Assert that the returned value is not null
        assertNotNull(now, "The current date and time should not be null");

        // Additional assertions can be made, such as checking if the time is within a reasonable range
        LocalDateTime nowMinusOneSecond = now.minusSeconds(1); // 1 second in the past
        LocalDateTime nowPlusOneSecond = now.plusSeconds(1);   // 1 second in the future

        LocalDateTime current = LocalDateTime.now();
        assertTrue(current.isAfter(nowMinusOneSecond) && current.isBefore(nowPlusOneSecond),
                "The current date and time should be within 1 second of the fetched time");
    }
}