package com.jmk.people.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.enums.Status;
import com.jmk.people.model.Sevadar;
import com.jmk.people.repository.PersonRepository;

@Service("sevadarMgmtService")
public class SevadarMgmtServiceImpl implements PersonMgmtService<Sevadar>{
	
	@Autowired
	private PersonRepository<com.jmk.people.entity.Sevadar> repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Sevadar savePerson(Sevadar sevadarModel) {
		com.jmk.people.entity.Sevadar sevadarEntity=mapModelToEntity(mapper,sevadarModel,com.jmk.people.entity.Sevadar.class);
		sevadarEntity=repository.save(sevadarEntity);
		sevadarModel=mapEntityToModel(mapper, sevadarEntity, Sevadar.class);
		return sevadarModel;
	}

	@Override
	public Sevadar findPersonDetailsById(Long id) {
		Optional<com.jmk.people.entity.Sevadar> sevadarEntity=repository.findById(id);
		Sevadar sevadarModel=mapEntityToModel(mapper,sevadarEntity.get(),Sevadar.class);
		return sevadarModel;
	}

	@Override
	public void deletePersonById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Sevadar> savePersons(List<Sevadar> sevadarModels) {
		final List<com.jmk.people.entity.Sevadar> sevadarEntities = new ArrayList<>();
		sevadarModels.forEach(sevadarModel -> sevadarEntities.add(mapModelToEntity(mapper, sevadarModel, com.jmk.people.entity.Sevadar.class)));
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars = repository.saveAll(sevadarEntities);
		final List<com.jmk.people.entity.Sevadar> savedSevadarEntities = StreamSupport.stream(iterableSevadars.spliterator(), false).collect(Collectors.toList());
		savedSevadarEntities.forEach(sourceSevadar -> sevadarModels.add(mapEntityToModel(mapper, sourceSevadar, Sevadar.class)));
		return sevadarModels;
	}

	@Override
	public List<Sevadar> findAllPersonsByStatus(Status status) {
		List<Sevadar> sevadarModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars=repository.findAll();
		List<com.jmk.people.entity.Sevadar> sevadarEntities=StreamSupport.stream(iterableSevadars.spliterator(),false).collect(Collectors.toList());
		sevadarEntities.forEach(sourceSevadar->sevadarModels.add(mapEntityToModel(mapper,sourceSevadar, Sevadar.class)));
		return sevadarModels;
	}

	@Override
	public Sevadar findPersonByMobileNumber(String mobileNumber) {
		return null;
	}

}
