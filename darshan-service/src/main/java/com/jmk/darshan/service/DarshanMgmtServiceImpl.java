package com.jmk.darshan.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.darshan.model.Darshan;
import com.jmk.darshan.repository.DarshanRepository;
import com.jmk.eh.exception.EntityNotFoundException;

@Service
public class DarshanMgmtServiceImpl implements DarshanMgmtService{
	
	@Autowired
	private DarshanRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Darshan saveDarshan(Darshan darshanModel) {
		com.jmk.darshan.entity.Darshan darshanEntity=mapper.map(darshanModel, com.jmk.darshan.entity.Darshan.class);
		darshanEntity=repository.save(darshanEntity);
		darshanModel=mapper.map(darshanEntity, Darshan.class);
		return darshanModel;
	}

	@Override
	public List<Darshan> saveDarshans(List<Darshan> darshanModels) {
		List<com.jmk.darshan.entity.Darshan> darshanEntities=darshanModels.stream().map(darshanModel->mapper.map(darshanModel, com.jmk.darshan.entity.Darshan.class)).collect(Collectors.toList());
		Iterable<com.jmk.darshan.entity.Darshan> iterableDarshan=repository.saveAll(darshanEntities);
		darshanModels=StreamSupport.stream(iterableDarshan.spliterator(), false).map(darshanEntity->mapper.map(darshanEntity,Darshan.class)).collect(Collectors.toList());
		return darshanModels;
	}

	@Override
	public Darshan findDarshanDetailsById(Long id) {
		Optional<com.jmk.darshan.entity.Darshan> optionalDarshan=repository.findById(id);
		if(!optionalDarshan.isPresent()) {
			throw new EntityNotFoundException(Darshan.class, "id",id.toString());
		}
		Darshan darshanModel=mapper.map(optionalDarshan.get(),Darshan.class);
		return darshanModel;
	}

	@Override
	public void deleteDarshanById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Darshan> findDarshanDetailsByDateRange(LocalDate startDate, LocalDate endDate) {
		return null;
	}
	
}

