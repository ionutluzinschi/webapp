package app;

import app.userlog.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


import java.util.List;



/**
 * Created by V3790148 on 5/18/2016.
 */
@EnableJpaRepositories(basePackageClasses =User.class)
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByipAddress(String ipAdress);

}
