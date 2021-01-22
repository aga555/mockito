package mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RefactoredSimpleRegistrartionServiceSpec {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private BannedUsersClient bannedUsersClient = Mockito.mock(BannedUsersClient.class);
    private RegistrationService registrationService = new RegistrationService(userRepository, bannedUsersClient);
    private UserRepository realUserRepository = new JpaUserRepository();
    private SimpleRegistrationService service = new SimpleRegistrationService();

    @Test
    void shouldStoreNewUser() {

        System.out.println(service.toString());
        System.out.println(service.getClass());

        System.out.println(realUserRepository.toString());
        System.out.println(realUserRepository.getClass());

        System.out.println(userRepository.toString());
        System.out.println(userRepository.getClass());

        System.out.println(bannedUsersClient.toString());
        System.out.println(bannedUsersClient.getClass());


    }
}
