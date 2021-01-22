package mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RefactoredSimpleRegistrartionServiceSpec {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BannedUsersClient bannedUsersClient;
    @InjectMocks
    private RegistrationService registrationService;

    @Test
    void defaultBehaviour() {
        //object
        System.out.println(userRepository.findByUsername("moris"));
        System.out.println(userRepository.save(new User()));

        System.out.println(bannedUsersClient.amountOfBannedAccounts());
        System.out.println(bannedUsersClient.banRate());
        System.out.println(bannedUsersClient.isBanned("mike", new Address()));
        System.out.println(bannedUsersClient.bannedUserId());
    }

    @Test
    void basicStubbing() {

        Mockito.when(bannedUsersClient.isBanned("mike", new Address())).thenReturn(true);

        System.out.println(bannedUsersClient.isBanned("mike", new Address()));


    }
}
