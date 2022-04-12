import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 * @author Andrew Garcia
 */
public class BookingSystemTest {
    @Test
    public void testReserveBookingTrue() {
        RegisteredUser user = null;
        BookableEntity entity = null;
        assertTrue("failure- should be true", BookingSystem.reserveBooking(user, entity));
    }
    @Test
    public void testReserveBookingFalse() {
        RegisteredUser user = null;
        BookableEntity entity = null;
        assertFalse("failure- should be false", BookingSystem.reserveBooking(user, entity));
    }
    @Test
    public void testCancelBookingTrue() {
        RegisteredUser user = null;
        BookableEntity entity = null;
        assertTrue("failure- should be true", BookingSystem.cancelBooking(user, entity));
    }
    @Test
    public void testCancelBookingFalse() {
        RegisteredUser user = null;
        BookableEntity entity = null;
        assertFalse("failure- should be false", BookingSystem.cancelBooking(user, entity));
    }
}
