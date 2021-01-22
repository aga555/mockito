package mockito.mock;

import java.time.LocalDateTime;

public class SimpleRegistrationService {
    private UserRepository userRepository = new JpaUserRepository();

    public User registerUser(String username) {
        User existinUser = userRepository.findByUsername();
        if (existinUser != null) {
            return existinUser;
        }
        User user = new User();
        user.setUsername(username);
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }


}
