package app.db;

import app.userlog.User;

import java.util.List;

/**
 * Created by p3700657 on 5/23/2016.
 */
public interface DbService {
    public void save(User user);
    List<User> findByipAddress(String ip);

}
