package sa47.team11.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sa47.team11.caps.model.Role;
import sa47.team11.caps.model.User;
import sa47.team11.caps.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override
	public ArrayList<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Role> findRolesForUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> findRoleNamesForUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> findManagerNameByUID(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}
	
}
