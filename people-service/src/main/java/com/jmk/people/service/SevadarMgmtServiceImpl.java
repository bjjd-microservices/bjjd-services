package com.jmk.people.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.jmk.people.model.Devotee;
import com.jmk.people.model.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jmk.eh.exception.EntityNotFoundException;
import com.jmk.enums.Status;
import com.jmk.people.enums.PersonType;
import com.jmk.people.model.Sevadar;
import com.jmk.people.repository.PersonRepository;
import com.jmk.project.model.Project;

@Service("sevadarMgmtService")
public class SevadarMgmtServiceImpl implements PersonMgmtService<Sevadar>{
	
	@Autowired
	private PersonRepository<com.jmk.people.entity.Sevadar> repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	@CachePut(value = "sevadarCacheByMobileNo", key = "#sevadarModel.mobileNo")
	public Sevadar savePerson(Sevadar sevadarModel) {
		com.jmk.people.entity.Sevadar sevadarEntity=mapModelToEntity(mapper,sevadarModel,com.jmk.people.entity.Sevadar.class);
		sevadarEntity=repository.save(sevadarEntity);
		sevadarModel=mapEntityToModel(mapper, sevadarEntity, Sevadar.class);
		return sevadarModel;
	}

	@Override
	public List<Sevadar> savePersons(List<Sevadar> sevadarModels) {
		final List<com.jmk.people.entity.Sevadar> sevadarEntities = sevadarModels.stream().map(sevadarModel->mapModelToEntity(mapper, sevadarModel, com.jmk.people.entity.Sevadar.class)).collect(Collectors.toList());
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars = repository.saveAll(sevadarEntities);
		sevadarModels = StreamSupport.stream(iterableSevadars.spliterator(), false).map(sevadarEntity->mapEntityToModel(mapper, sevadarEntity, Sevadar.class)).collect(Collectors.toList());
		return sevadarModels;
	}

	/**
	 * @return
	 */
	@Override
	public List<Sevadar> findAllPersons() {
		List<Sevadar> sevadarModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars=repository.findAllByType(PersonType.SEVADAR.getType());
		sevadarModels = StreamSupport.stream(iterableSevadars.spliterator(), false).map(sevadarEntity->mapEntityToModel(mapper, sevadarEntity, Sevadar.class)).collect(Collectors.toList());
		return sevadarModels;
	}

	@Override
	public Sevadar findPersonById(Long id) {
		com.jmk.people.entity.Sevadar sevadarEntity=repository.findPersonByTypeAndId(PersonType.SEVADAR.getType(),id);
		if(sevadarEntity==null) {
			throw new EntityNotFoundException(Project.class,"id",id.toString());
		}
		Sevadar sevadarModel=mapEntityToModel(mapper,sevadarEntity,Sevadar.class);
		return sevadarModel;
	}

	@Override
	//@Cacheable(value="sevadarCacheByMobileNo",key="#mobileNo",unless="#result == null")
	public Sevadar findPersonByMobileNumber(String mobileNumber) {
		Sevadar sevadarModel = null;
		com.jmk.people.entity.Sevadar sevadarEntity = repository
				.findPersonByTypeAndMobileNo(PersonType.SEVADAR.getType(), mobileNumber);
		if (sevadarEntity != null) {
			sevadarModel = mapEntityToModel(mapper, sevadarEntity, Sevadar.class);
		}
		return sevadarModel;
	}

	@Override
	public List<Sevadar> findAllPersonsByStatus(Status status) {
		List<Sevadar> sevadarModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Sevadar> iterableSevadars=repository.findByStatus(status);
		sevadarModels = StreamSupport.stream(iterableSevadars.spliterator(), false).map(sevadarEntity->mapEntityToModel(mapper, sevadarEntity, Sevadar.class)).collect(Collectors.toList());
		return sevadarModels;
	}

	@Override
	public Sevadar updatePerson(Long id, Sevadar sevadar) {
		Optional<com.jmk.people.entity.Sevadar> optionalEntity= repository.findById(id);
		if(optionalEntity.isEmpty()) {
			throw new EntityNotFoundException(Devotee.class,"id",id.toString());
		}
		com.jmk.people.entity.Sevadar sevadarEntity=mapModelToEntity(mapper,sevadar, com.jmk.people.entity.Sevadar.class);
		sevadarEntity.setId(id);
		sevadarEntity=repository.save(sevadarEntity);
		sevadar=mapEntityToModel(mapper, sevadarEntity, Sevadar.class);
		return sevadar;
	}

	@Override
	@CacheEvict(value = "sevadarCacheByMobileNo", key = "#mobileNo")
	public void deletePersonById(Long id) {
		repository.deleteById(id);
	}


	

}
