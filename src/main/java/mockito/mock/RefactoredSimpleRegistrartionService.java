package mockito.mock;

import java.time.LocalDateTime;

public class RefactoredSimpleRegistrartionService {
    private  final UserRepository userRepository;

    RefactoredSimpleRegistrartionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(String username) {
        User existingUser = userRepository.findByUserName();
        if (existingUser != null) {
            return existingUser;
        }
        User user = new User();
        user.setUsername(username);
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
}
