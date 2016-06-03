package app.db;

import app.userlog.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



/**
 * Created by V3790148 on 5/18/2016.
 */
@EnableJpaRepositories(basePackageClasses =User.class)
@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByipAddress(String ipAdress);


}
