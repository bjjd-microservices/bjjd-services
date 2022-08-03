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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.eh.exception.EntityNotFoundException;
import com.jmk.enums.Status;
import com.jmk.people.enums.PersonType;
import com.jmk.people.model.Member;
import com.jmk.people.repository.PersonRepository;

@Service("memberMgmtService")
@Transactional
public class MemberMgmtServiceImpl implements PersonMgmtService<Member> {
	
	@Autowired
	private PersonRepository<com.jmk.people.entity.Member> repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	@CachePut(value = "memberCacheByMobileNo", key = "#memberModel.mobileNo")
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public Member savePerson(Member memberModel) {
		com.jmk.people.entity.Member memberEntity=mapModelToEntity(mapper,memberModel,com.jmk.people.entity.Member.class);
		memberEntity=repository.save(memberEntity);
		memberModel=mapEntityToModel(mapper, memberEntity, Member.class);
		return memberModel;
	}

	@Override
	public Member findPersonDetailsById(Long id) {
		Optional<com.jmk.people.entity.Member> memberEntity = repository.findById(id);
		if (!memberEntity.isPresent()) {
			throw new EntityNotFoundException(com.jmk.people.entity.Member.class,"id",id.toString());
		}
		Member memberModel = mapEntityToModel(mapper, memberEntity.get(), Member.class);
		return memberModel;
	}

	@Override
	@CacheEvict(value = "memberCacheByMobileNo", key = "#mobileNo")
	public void deletePersonById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Member> savePersons(List<Member> memberModels) {
		final List<com.jmk.people.entity.Member> memberEntities = memberModels.stream().map(memberModel->mapModelToEntity(mapper, memberModel, com.jmk.people.entity.Member.class)).collect(Collectors.toList());
		Iterable<com.jmk.people.entity.Member> iterableMembers = repository.saveAll(memberEntities);
		memberModels = StreamSupport.stream(iterableMembers.spliterator(), false).map(memberEntity->mapEntityToModel(mapper, memberEntity, Member.class)).collect(Collectors.toList());
		return memberModels;
	}

	@Override
	public List<Member> findAllPersonsByStatus(Status status) {
		List<Member> memberModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Member> iterableMembers=repository.findAll();
		memberModels = StreamSupport.stream(iterableMembers.spliterator(), false).map(memberEntity->mapEntityToModel(mapper, memberEntity, Member.class)).collect(Collectors.toList());
		return memberModels;
	}

	@Override
	@Cacheable(value="memberCacheByMobileNo",key="#mobileNo",unless="#result == null")
	public Member findPersonByMobileNumber(String mobileNumber) {
		Member memberModel = null;
		com.jmk.people.entity.Member memberEntity = repository.findPersonByTypeAndMobileNo(PersonType.MEMBER.getType(),
				mobileNumber);
		if (memberEntity != null) {
			memberModel = mapEntityToModel(mapper, memberEntity, Member.class);
		}
		return memberModel;
	}

}
