package mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class RefactoredSimpleRegistrartionServiceSpec {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BannedUsersClient bannedUsersClient;
    @InjectMocks
    private RegistrationService registrationService;

    @Test
    void defaultBehaviour() {


        System.out.println(userRepository.findByUsername("moris"));
        System.out.println(userRepository.save(new User()));

        System.out.println(bannedUsersClient.amountOfBannedAccounts());
        System.out.println(bannedUsersClient.banRate());
        System.out.println(bannedUsersClient.isBanned("mike", new Address()));
        System.out.println(bannedUsersClient.bannedUserId());


    }
}
