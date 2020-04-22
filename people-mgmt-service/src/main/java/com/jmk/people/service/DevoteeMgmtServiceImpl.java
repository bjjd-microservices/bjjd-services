package com.jmk.people.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.eh.exception.EntityNotFoundException;
import com.jmk.enums.Status;
import com.jmk.people.model.Devotee;
import com.jmk.people.repository.PersonRepository;

@Service("devoteeMgmtService")
public class DevoteeMgmtServiceImpl implements PersonMgmtService<Devotee> {
	
	@Autowired
	private PersonRepository<com.jmk.people.entity.Devotee> repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Devotee savePerson(Devotee devoteeModel) {
		com.jmk.people.entity.Devotee devoteeEntity=mapModelToEntity(mapper,devoteeModel, com.jmk.people.entity.Devotee.class);
		devoteeEntity=repository.save(devoteeEntity);
		devoteeModel=mapEntityToModel(mapper, devoteeEntity,Devotee.class);
		return devoteeModel;
	}

	@Override
	public Devotee findPersonDetailsById(Long id) {
		Optional<com.jmk.people.entity.Devotee> devoteeEntity=repository.findById(id);
		if(!devoteeEntity.isPresent()) {
		throw new EntityNotFoundException(com.jmk.people.entity.Devotee.class,"id",id.toString());
		}
		Devotee devoteeModel=mapEntityToModel(mapper,devoteeEntity.get(),Devotee.class);
		return devoteeModel;
	}

	@Override
	public void deletePersonById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Devotee> savePersons(List<Devotee> devoteeModels) {
		final List<com.jmk.people.entity.Devotee> devoteeEntities = new ArrayList<>();
		devoteeModels.forEach(devoteeModel -> devoteeEntities.add(mapModelToEntity(mapper, devoteeModel, com.jmk.people.entity.Devotee.class)));
		Iterable<com.jmk.people.entity.Devotee> iterableDevotees = repository.saveAll(devoteeEntities);
		final List<com.jmk.people.entity.Devotee> savedDevoteeEntities = StreamSupport.stream(iterableDevotees.spliterator(), false).collect(Collectors.toList());
		savedDevoteeEntities.forEach(sourceDevotee -> devoteeModels.add(mapEntityToModel(mapper, sourceDevotee, Devotee.class)));
		return devoteeModels;
	}

	@Override
	public List<Devotee> findAllPersonsByStatus(Status status) {
		List<Devotee> devoteeModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Devotee> iterableDevotees=repository.findAll();
		List<com.jmk.people.entity.Devotee> devoteeEntities=StreamSupport.stream(iterableDevotees.spliterator(),false).collect(Collectors.toList());
		devoteeEntities.forEach(sourceDevotee->devoteeModels.add(mapEntityToModel(mapper,sourceDevotee, Devotee.class)));
		return devoteeModels;
	}

	@Override
	public Devotee findPersonByMobileNumber(String mobileNumber) {
		return null;
	}

}
