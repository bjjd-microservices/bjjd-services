package com.jmk.upload.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jmk.account.model.Donation;
import com.jmk.project.model.Project;
import com.jmk.upload.feign.client.AccountMgmtServiceClient;
import com.jmk.upload.feign.client.ProjectMgmtServiceClient;
import com.jmk.upload.model.Base;
import com.jmk.upload.service.DataStorageService;

@Service
public class DataStorageServiceImpl implements DataStorageService{
	
	@Autowired
	private ProjectMgmtServiceClient projectMgmtServiceClient;
	
	@Autowired
	private AccountMgmtServiceClient accountMgmtServiceClient;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Map<String,List<? extends Object>> storeData(Map<String, List<? extends Base>> sheetMapping) {
		Map<String,List<? extends Object>> resultSheetMapping=new HashMap<>();
		
		sheetMapping.entrySet().stream().forEach(entry->{
			if(entry.getKey().equals("Project")) {
				ResponseEntity<List<Project>> responseEntity=projectMgmtServiceClient.createProjects(entry.getValue().stream().map(project->modelMapper.map(project,Project.class)).collect(Collectors.toList()));
				resultSheetMapping.put("Project", responseEntity.getBody());
			}
			if(entry.getKey().equals("Donation")) {
				ResponseEntity<List<Donation>> responseEntity=accountMgmtServiceClient.saveDonations(entry.getValue().stream().map(donation->modelMapper.map(donation,Donation.class)).collect(Collectors.toList()));
				resultSheetMapping.put("Donation", responseEntity.getBody());
			}
		});
		return resultSheetMapping;
	}

}
