package com.jmk.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import com.jmk.project.model.Project;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.jmk.eh.exception.EntityNotFoundException;
import com.jmk.user.model.Address;
import com.jmk.user.model.Identity;
import com.jmk.user.model.User;
import com.jmk.user.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	

	@Override
	@Caching(put = { @CachePut(value = "usersCacheById", key = "#result.id"),
			@CachePut(value = "usersCacheByUsername", key = "#result.username") })
	public User saveUser(User userModel) {
		com.jmk.user.entity.User userEntity= mapper.map(updateUserModel(userModel), com.jmk.user.entity.User.class);
		userEntity= repository.save(userEntity);
		userModel= mapper.map(userEntity, User.class);
		return userModel;
	}

	@Override
	public List<User> saveUsers(List<User> userModels) {
		final List<com.jmk.user.entity.User> userEntities = userModels.stream()
				.map(userModel -> mapper.map(updateUserModel(userModel), com.jmk.user.entity.User.class))
				.collect(Collectors.toList());
		Iterable<com.jmk.user.entity.User> iterableUsers = repository.saveAll(userEntities);
		userModels = StreamSupport.stream(iterableUsers.spliterator(), false)
				.map(userEntity -> mapper.map(userEntity, User.class)).collect(Collectors.toList());
		return userModels;
	}


	@Override
	public List<User> findAllUsers() {
		List<User> userModels=new ArrayList<>();
		Iterable<com.jmk.user.entity.User> iterableUsers= repository.findAll();
		userModels=StreamSupport.stream(iterableUsers.spliterator(),false).map(userEntity-> mapper.map(userEntity,User.class)).collect(Collectors.toList());
		return userModels;
	}

	@Override
	@Cacheable(value="usersCacheById",key="#id",unless="#result == null")
	public User findUserDetailsById(Long id) {
		Optional<com.jmk.user.entity.User> optionalUser= repository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new EntityNotFoundException(User.class,"id",id.toString());
		}
		User userModel= mapper.map(optionalUser.get(), User.class);
		return userModel;
	}

	@Override
	@Cacheable(value="usersCacheByUsername",key="#username",unless="#result == null")
	public User findUserDetailsByUserName(String username) {
		com.jmk.user.entity.User userEntity= repository.findByUsername(username);
		if(userEntity==null) {
			throw new EntityNotFoundException(User.class,"UserName",username);
		}
		User userModel= mapper.map(userEntity, User.class);
		return userModel;
	}



	/**
	 * @param id
	 * @param user
	 * @return
	 */
	@Override
	public User updateUser(Long id, User user) {
		Optional<com.jmk.user.entity.User> optionalEntity= repository.findById(id);
		if(optionalEntity.isEmpty()) {
			throw new EntityNotFoundException(Project.class,"id",id.toString());
		}
		com.jmk.user.entity.User userEntity=mapper.map(updateUserModel(user), com.jmk.user.entity.User.class);
		userEntity.setId(id);
		userEntity=repository.save(userEntity);
		user=mapper.map(userEntity,User.class);
		return user;
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "usersCacheById", key = "#id"),
			@CacheEvict(value = "usersCacheByUsername", key = "#username") })
	public void deleteUserById(Long id) {
		repository.deleteById(id);
	}


	@Override
	@Caching(evict = { @CacheEvict(value = "usersCacheById", key = "#id"),
			@CacheEvict(value = "usersCacheByUsername", key = "#username") })
	public int deleteUserByUsername(String username) {
		int deleteRecords= repository.deleteByUsername(username);
		return deleteRecords;
	}
	
	/**
	 * To update the user model to set the user object reference in the associated reference object
	 * @param userModel
	 * @return
	 */
	protected User updateUserModel(User userModel) {
		for(Address address:userModel.getAddresses()) {
			address.setUser(userModel);
		}
		for(Identity identity:userModel.getIdentities()) {
			identity.setUser(userModel);
		}
		userModel.getProfile().setUser(userModel);
		return userModel;
	}
	
	

}