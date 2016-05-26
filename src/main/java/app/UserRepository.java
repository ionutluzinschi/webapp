package app;

import app.userlog.UserLog;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



/**
 * Created by V3790148 on 5/18/2016.
 */
@EnableJpaRepositories(basePackageClasses =UserLog.class)
@Repository
public interface UserRepository extends CrudRepository<UserLog, String> {
    List<UserLog> findByipAddress(String ipAdress);


}
