package com.jmk.people.service;

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
import com.jmk.people.enums.PersonType;
import com.jmk.people.model.Devotee;
import com.jmk.people.repository.PersonRepository;
import com.jmk.project.model.Project;

@Service("devoteeMgmtService")
public class DevoteeMgmtServiceImpl implements PersonMgmtService<Devotee> {

    @Autowired
    private PersonRepository<com.jmk.people.entity.Devotee> repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @CachePut(value = "devoteeCacheByMobileNo", key = "#devoteeModel.mobileNo")
    public Devotee savePerson(Devotee devoteeModel) {
        com.jmk.people.entity.Devotee devoteeEntity = mapModelToEntity(mapper, devoteeModel, com.jmk.people.entity.Devotee.class);
        devoteeEntity = repository.save(devoteeEntity);
        devoteeModel = mapEntityToModel(mapper, devoteeEntity, Devotee.class);
        return devoteeModel;
    }

    @Override
    public List<Devotee> savePersons(List<Devotee> devoteeModels) {
        final List<com.jmk.people.entity.Devotee> devoteeEntities = devoteeModels.stream().map(devoteeModel -> mapModelToEntity(mapper, devoteeModel, com.jmk.people.entity.Devotee.class)).collect(Collectors.toList());
        Iterable<com.jmk.people.entity.Devotee> iterableDevotees = repository.saveAll(devoteeEntities);
        devoteeModels = StreamSupport.stream(iterableDevotees.spliterator(), false).map(devoteeEntity -> mapEntityToModel(mapper, devoteeEntity, Devotee.class)).collect(Collectors.toList());
        return devoteeModels;
    }

    /**
     * @return
     */
    @Override
    public List<Devotee> findAllPersons() {
        List<Devotee> devoteeModels = new ArrayList<>();
        Iterable<com.jmk.people.entity.Devotee> iterableDevotees = repository.findAllByType(PersonType.DEVOTEE.getType());
        devoteeModels = StreamSupport.stream(iterableDevotees.spliterator(), false).map(devoteeEntity -> mapEntityToModel(mapper, devoteeEntity, Devotee.class)).collect(Collectors.toList());
        return devoteeModels;
    }

    @Override
    public Devotee findPersonById(Long id) {
        com.jmk.people.entity.Devotee devoteeEntity = repository.findPersonByTypeAndId(PersonType.DEVOTEE.getType(), id);
        if (devoteeEntity == null) {
            throw new EntityNotFoundException(com.jmk.people.entity.Devotee.class, "id", id.toString());
        }
        Devotee devoteeModel = mapEntityToModel(mapper, devoteeEntity, Devotee.class);
        return devoteeModel;
    }

    @Override
    public List<Devotee> findAllPersonsByStatus(Status status) {
        List<Devotee> devoteeModels = new ArrayList<>();
        Iterable<com.jmk.people.entity.Devotee> iterableDevotees = repository.findByStatus(status);
        devoteeModels = StreamSupport.stream(iterableDevotees.spliterator(), false).map(devoteeEntity -> mapEntityToModel(mapper, devoteeEntity, Devotee.class)).collect(Collectors.toList());
        return devoteeModels;
    }

    @Override
   // @Cacheable(value = "devoteeCacheByMobileNo", key = "#mobileNo", unless = "#result == null")
    public Devotee findPersonByMobileNumber(String mobileNo) {
        Devotee devoteeModel = null;
        com.jmk.people.entity.Devotee devoteeEntity = repository
                .findPersonByTypeAndMobileNo(PersonType.DEVOTEE.getType(), mobileNo);
        if (devoteeEntity != null) {
            devoteeModel = mapEntityToModel(mapper, devoteeEntity, Devotee.class);
        }
        return devoteeModel;
    }

    /**
     * @param id
     * @param devotee
     * @return
     */
    @Override
    public Devotee updatePerson(Long id, Devotee devotee) {
        Optional<com.jmk.people.entity.Devotee> optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new EntityNotFoundException(Devotee.class, "id", id.toString());
        }
        com.jmk.people.entity.Devotee devoteeEntity = mapModelToEntity(mapper, devotee, com.jmk.people.entity.Devotee.class);
        devoteeEntity.setId(id);
        devoteeEntity = repository.save(devoteeEntity);
        devotee = mapEntityToModel(mapper, devoteeEntity, Devotee.class);
        return devotee;
    }


    @Override
    public void deletePersonById(Long id) {
        repository.deleteById(id);
    }


}


