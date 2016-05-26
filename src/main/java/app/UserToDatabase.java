package app;

import app.userlog.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by p3700657 on 5/23/2016.
 */
@Service
public class UserToDatabase implements DbService {

    @Autowired
    UserRepository repository;

    public UserToDatabase(){
    }

    public void save(UserLog userLog){
        repository.save(userLog);
    }

    public List<UserLog> findByipAddress(String ip){
        return repository.findByipAddress(ip);
    }

}
