package com.jmk.project.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.enums.Status;
import com.jmk.project.model.Project;
import com.jmk.project.repository.ProjectRepository;

@Service
public class ProjectMgmtServiceImpl  implements ProjectMgmtService {

	@Autowired
	private ProjectRepository projectRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Project saveProject(Project projectModel) {
		com.jmk.project.entity.Project projectEntity=modelMapper.map(projectModel, com.jmk.project.entity.Project.class);
		projectEntity=projectRespository.save(projectEntity);
		projectModel=modelMapper.map(projectEntity,Project.class);
		return projectModel;
	}

	@Override
	public Project findProjectDetailsById(Long id) {
		Optional<com.jmk.project.entity.Project> projectEntity= projectRespository.findById(id);
		Project projectModel=modelMapper.map(projectEntity.get(),Project.class);
		return projectModel;
	}

	@Override
	public void deleteProjectById(Long id) {
		projectRespository.deleteById(id);;
	}

	@Override
	public List<Project> saveProjects(List<Project> projectModels) {
		List<com.jmk.project.entity.Project> projectEntities=new ArrayList<>();
		BeanUtils.copyProperties(projectModels, projectEntities);
		Iterable<com.jmk.project.entity.Project> iterableUsers=projectRespository.saveAll(projectEntities);
		projectEntities=StreamSupport.stream(iterableUsers.spliterator(),false).collect(Collectors.toList());
		BeanUtils.copyProperties(projectEntities,projectModels);
		return projectModels;
	}

	@Override
	public List<Project> findAllProjectsByStatus(Status status) {
		List<Project> projectModels=new ArrayList<>();
		Iterable<com.jmk.project.entity.Project> iterableProjects=projectRespository.findAll();
		List<com.jmk.project.entity.Project> projectEntities=StreamSupport.stream(iterableProjects.spliterator(),false).collect(Collectors.toList());
		projectEntities.forEach(sourceProject->projectModels.add(modelMapper.map(sourceProject, Project.class)));
		return projectModels;
	}
	
}

