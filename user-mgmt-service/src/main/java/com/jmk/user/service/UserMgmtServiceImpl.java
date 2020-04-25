package com.jmk.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.eh.exception.EntityNotFoundException;
import com.jmk.user.model.Address;
import com.jmk.user.model.Identity;
import com.jmk.user.model.User;
import com.jmk.user.repository.UserRepository;

@Service("userMgmtService")
@Transactional
public class UserMgmtServiceImpl implements UserMgmtService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User saveUser(User userModel) {
		com.jmk.user.entity.User userEntity=modelMapper.map(updateUserModel(userModel), com.jmk.user.entity.User.class);
		userEntity=userRepository.save(userEntity);
		userModel=modelMapper.map(userEntity, User.class);
		return userModel;
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findUserDetailsByUserName(String userName) {
		com.jmk.user.entity.User userEntity=userRepository.findByUsername(userName);
		if(userEntity==null) {
			throw new EntityNotFoundException(User.class,"UserName",userName);
		}
		User userModel=modelMapper.map(userEntity, User.class);
		return userModel;
	}

	@Override
	public List<User> saveUsers(List<User> userModels) {
		final List<com.jmk.user.entity.User> userEntities = userModels.stream()
				.map(userModel -> modelMapper.map(updateUserModel(userModel), com.jmk.user.entity.User.class))
				.collect(Collectors.toList());
		Iterable<com.jmk.user.entity.User> iterableUsers = userRepository.saveAll(userEntities);
		userModels = StreamSupport.stream(iterableUsers.spliterator(), false)
				.map(userEntity -> modelMapper.map(userEntity, User.class)).collect(Collectors.toList());
		return userModels;
	}

	@Override
	public User findUserDetailsById(Long id) {
		Optional<com.jmk.user.entity.User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new EntityNotFoundException(User.class,"id",id.toString());
		}
		User userModel=modelMapper.map(optionalUser.get(), User.class);
		return userModel;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> userModels=new ArrayList<>();
		Iterable<com.jmk.user.entity.User> iterableUsers=userRepository.findAll();
		userModels=StreamSupport.stream(iterableUsers.spliterator(),false).map(userEntity->modelMapper.map(userEntity,User.class)).collect(Collectors.toList());
		return userModels;
	}

	
	@Override
	public int deleteUserByUsername(String username) {
		int userid=userRepository.deleteByUsername(username);
		return userid;
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