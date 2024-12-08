import java.time.LocalDateTime;

public class main {

    /**
     * Current date and time 
     *
     * @return The current date and time
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static void main(String[] args) {
        // Example usage
        LocalDateTime now = getCurrentDateTime();
        System.out.println("Current Date and Time: " + now);

    
    }
}
