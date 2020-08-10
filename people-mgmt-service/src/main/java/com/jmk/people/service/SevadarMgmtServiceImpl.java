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
import com.jmk.people.enums.PersonType;
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
		final List<com.jmk.people.entity.Sevadar> sevadarEntities = sevadarModels.stream().map(sevadarModel->mapModelToEntity(mapper, sevadarModel, com.jmk.people.entity.Sevadar.class)).collect(Collectors.toList());
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars = repository.saveAll(sevadarEntities);
		sevadarModels = StreamSupport.stream(iterableSevadars.spliterator(), false).map(sevadarEntity->mapEntityToModel(mapper, sevadarEntity, Sevadar.class)).collect(Collectors.toList());
		return sevadarModels;
	}

	@Override
	public List<Sevadar> findAllPersonsByStatus(Status status) {
		List<Sevadar> sevadarModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars=repository.findAll();
		sevadarModels = StreamSupport.stream(iterableSevadars.spliterator(), false).map(sevadarEntity->mapEntityToModel(mapper, sevadarEntity, Sevadar.class)).collect(Collectors.toList());
		return sevadarModels;
	}

	@Override
	public Sevadar findPersonByMobileNumber(String mobileNumber) {
		Sevadar sevadarModel = null;
		com.jmk.people.entity.Sevadar sevadarEntity = repository
				.findPersonByTypeAndMobileNo(PersonType.SEVADAR.getType(), mobileNumber);
		if (sevadarEntity != null) {
			sevadarModel = mapEntityToModel(mapper, sevadarEntity, Sevadar.class);
		}
		return sevadarModel;
	}

}
