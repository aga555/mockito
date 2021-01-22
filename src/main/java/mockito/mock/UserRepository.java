package mockito.mock;

public interface UserRepository {
    User save(User user);

    User findByUsername(String username);

    User findByUserName();
}
