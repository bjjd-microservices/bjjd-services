package com.jmk.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		com.jmk.user.entity.User userEntity=modelMapper.map(userModel, com.jmk.user.entity.User.class);
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
		User userModel=modelMapper.map(userEntity, User.class);
		return userModel;
	}

	@Override
	public List<User> saveUsers(List<User> userModels) {
		List<com.jmk.user.entity.User> userEntities=new ArrayList<>();
		BeanUtils.copyProperties(userModels, userEntities);
		Iterable<com.jmk.user.entity.User> iterableUsers=userRepository.saveAll(userEntities);
		userEntities=StreamSupport.stream(iterableUsers.spliterator(),false).collect(Collectors.toList());
		BeanUtils.copyProperties(userEntities,userModels);
		return userModels;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> userModels=new ArrayList<>();
		Iterable<com.jmk.user.entity.User> iterableUsers=userRepository.findAll();
		List<com.jmk.user.entity.User> userEntities=StreamSupport.stream(iterableUsers.spliterator(),false).collect(Collectors.toList());
		userEntities.forEach(sourceUser->userModels.add(modelMapper.map(sourceUser, User.class)));
		return userModels;
	}

	@Override
	public User findUserDetailsById(Long id) {
		Optional<com.jmk.user.entity.User> userEntity=userRepository.findById(id);
		User userModel=modelMapper.map(userEntity, User.class);
		return userModel;
	}

	@Override
	public int deleteUserByUsername(String username) {
		int userid=userRepository.deleteByUsername(username);
		return userid;
	}

}