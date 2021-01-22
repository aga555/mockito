package mockito.mock;

public class FakeUserRepository implements  UserRepository {
    @Override
    public User save(final User user) {
        System.out.println("#Fake user repository save");
        return null;
    }

    @Override
    public User findByUsername(final String username) {
        return null;
    }

    @Override
    public User findByUserName() {
        System.out.println("#Fake user repository find");
        return null;
    }
}
