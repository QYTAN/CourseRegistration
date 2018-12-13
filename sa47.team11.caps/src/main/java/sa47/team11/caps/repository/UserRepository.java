package sa47.team11.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team11.caps.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	
    
	@Query("SELECT u FROM User u WHERE u.email=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	/*@Query("SELECT u FROM User u")
	ArrayList<User> getAllUsers();*/

}
