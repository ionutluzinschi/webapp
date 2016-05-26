package app;

import app.userlog.UserLog;

import java.util.List;

/**
 * Created by p3700657 on 5/23/2016.
 */
public interface DbService {
    public void save(UserLog userLog);
    List<UserLog> findByipAddress(String ip);

}
