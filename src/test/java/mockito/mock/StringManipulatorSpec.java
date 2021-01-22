package mockito.mock;

import org.junit.jupiter.api.Test;

class StringManipulatorSpec {

    @Test
    void shouldStoreNewUser() {
        SimpleRegistrationService service = new SimpleRegistrationService();

        User actualUser = service.registerUser("moris");

    }
}
