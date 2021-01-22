package mockito.mock;

public class FakeUserRepository implements UserRepository {
    @Override
    public User save(final User user) {

        System.out.println("#Fake user repository save");
        return null;
    }

    @Override
    public User findByUsername(final String username) {
        if (username.equals("moris")) {
            System.out.println("Extra name");
            return new User();
        } else if (username.equals("tom")){
            System.out.println("So sorry");
            throw new RuntimeException("Error in DB");}
        else return new User();

    }

    @Override
    public User findByUserName() {
        System.out.println("#Fake user repository find");
        return null;
    }
}
