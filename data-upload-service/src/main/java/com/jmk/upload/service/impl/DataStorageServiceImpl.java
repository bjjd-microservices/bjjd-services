package com.jmk.upload.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jmk.project.model.Project;
import com.jmk.upload.feign.client.ProjectMgmtServiceClient;
import com.jmk.upload.model.Base;
import com.jmk.upload.model.UploadFileResponse;
import com.jmk.upload.service.DataStorageService;

@Service
public class DataStorageServiceImpl implements DataStorageService{
	
	@Autowired
	private ProjectMgmtServiceClient projectMgmtServiceClient;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UploadFileResponse storeData(Map<String, List<? extends Base>> sheetMapping) {
		sheetMapping.entrySet().stream().forEach(entry->{
			if(entry.getKey().equals("Project")) {
				ResponseEntity<List<Project>> responseEntity=projectMgmtServiceClient.createProjects(entry.getValue().stream().map(project->modelMapper.map(project,Project.class)).collect(Collectors.toList()));
				System.out.println("Result: "+responseEntity.getBody());
			}
		});
		return null;
	}

}
