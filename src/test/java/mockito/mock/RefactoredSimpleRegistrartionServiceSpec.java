package mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


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

        when(bannedUsersClient.isBanned("mike", new Address())).thenReturn(true);

        System.out.println(bannedUsersClient.isBanned("mike", new Address()));

    }

    @Test
    void basicsStubbingWithArgumentMatchers() {
        when(bannedUsersClient.isBanned(eq("duke"), any(Address.class))).thenReturn(true);

        when(bannedUsersClient.isBanned(ArgumentMatchers.argThat(s -> s.length() <= 3), ArgumentMatchers.isNotNull())).thenReturn(false);
        when(bannedUsersClient.isBanned(ArgumentMatchers.anyString(), any(Address.class))).thenReturn(true);
        System.out.println(bannedUsersClient.isBanned("mike", new Address()));
        System.out.println(bannedUsersClient.isBanned("dddddddddd", new Address()));
        System.out.println(bannedUsersClient.isBanned("foo", new Address()));

    }

    @Test
    void basicStubbingUsageThrows() {
        when(bannedUsersClient.isBanned(eq("mike"), any())).thenThrow(new RuntimeException("Rmote sysstem is down"));
        System.out.println(bannedUsersClient.isBanned("tom", new Address()));
        //System.out.println(bannedUsersClient.isBanned("mike", new Address()));
        assertThrows(RuntimeException.class, () -> System.out.println(bannedUsersClient.isBanned("mike", new Address())));

    }

    @Test
    void basicStubbingUsagCallRealMethod() {
        when(bannedUsersClient.isBanned(eq("mike"), any(Address.class))).thenCallRealMethod();
        System.out.println(bannedUsersClient.isBanned("mike", new Address()));
    }
}
