package mockito.mock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefactoredSimpleRegistrartionServiceSpec {

    @Test
    void shouldStoreNewUser() {

        RefactoredSimpleRegistrartionService service= new RefactoredSimpleRegistrartionService(new FakeUserRepository());

        User actualUser = service.registerUser("tom");

    }
}
