package app.db;

import app.db.DbService;
import app.db.UserRepository;
import app.userlog.User;
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

    public void save(User user){
        repository.save(user);
    }

    public List<User> findByipAddress(String ip){
        return repository.findByipAddress(ip);
    }

}
