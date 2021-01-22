package mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RefactoredSimpleRegistrartionServiceSpecV1 {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BannedUsersClient bannedUsersClient;
    @InjectMocks
    private RegistrationService registrationService;

    @Test
    void shouldStoreNewUser() {


        System.out.println(userRepository.toString());
        System.out.println(userRepository.getClass());

        System.out.println(bannedUsersClient.toString());
        System.out.println(bannedUsersClient.getClass());

        System.out.println(registrationService.toString());
        //    System.out.println(registrationService.getClass());


    }
}
