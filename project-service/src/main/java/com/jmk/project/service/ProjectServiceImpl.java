package com.jmk.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jmk.eh.exception.EntityNotFoundException;
import com.jmk.enums.Status;
import com.jmk.project.model.Project;
import com.jmk.project.repository.ProjectRepository;

@Service
public class ProjectServiceImpl  implements ProjectService {

	@Autowired
	private ProjectRepository projectRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@CachePut(value = "projectCacheByCode", key = "#projectModel.code")
	public Project saveProject(Project projectModel) {
		com.jmk.project.entity.Project projectEntity=modelMapper.map(projectModel, com.jmk.project.entity.Project.class);
		projectEntity=projectRespository.save(projectEntity);
		projectModel=modelMapper.map(projectEntity,Project.class);
		return projectModel;
	}

	@Override
	@Cacheable(value="projectCacheByCode",key="#code",unless="#result == null")
	public Project findProjectByCode(String code) {
		Project projectModel=null;
		com.jmk.project.entity.Project projectEntity=projectRespository.findByCode(code);
		if(projectEntity!=null) {
		 projectModel=modelMapper.map(projectEntity, Project.class);
		}
		return projectModel;
	}
	
	@Override
	@CacheEvict(value = "projectCacheByCode", key = "#code")
	public void deleteProjectById(Long id) {
		projectRespository.deleteById(id);;
	}

	
	@Override
	public Project findProjectDetailsById(Long id) {
		Optional<com.jmk.project.entity.Project> optionalProject= projectRespository.findById(id);
		if(!optionalProject.isPresent()) {
			throw new EntityNotFoundException(Project.class,"id",id.toString());
		}
		Project projectModel=modelMapper.map(optionalProject.get(),Project.class);
		return projectModel;
	}

	
	@Override
	public List<Project> saveProjects(List<Project> projectModels) {
		List<com.jmk.project.entity.Project> projectEntities=projectModels.stream().map(projectModel->modelMapper.map(projectModel,com.jmk.project.entity.Project.class)).collect(Collectors.toList());
		Iterable<com.jmk.project.entity.Project> iterableProjects=projectRespository.saveAll(projectEntities);
		projectModels=StreamSupport.stream(iterableProjects.spliterator(),false).map(projectEntity->modelMapper.map(projectEntity, Project.class)).collect(Collectors.toList());
		return projectModels;
	}

	@Override
	public List<Project> findAllProjectsByStatus(Status status) {
		List<Project> projectModels=new ArrayList<>();
		Iterable<com.jmk.project.entity.Project> iterableProjects=projectRespository.findAll();
		projectModels=StreamSupport.stream(iterableProjects.spliterator(),false).map(projectEntity->modelMapper.map(projectEntity, Project.class)).collect(Collectors.toList());
		return projectModels;
	}

	
	
}

