package com.jmk.people.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.enums.Status;
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
	public Member savePerson(Member memberModel) {
		com.jmk.people.entity.Member memberEntity=mapModelToEntity(mapper,memberModel,com.jmk.people.entity.Member.class);
		memberEntity=repository.save(memberEntity);
		memberModel=mapEntityToModel(mapper, memberEntity, Member.class);
		return memberModel;
	}

	@Override
	public Member findPersonDetailsById(Long id) {
		Optional<com.jmk.people.entity.Member> memberEntity=repository.findById(id);
		Member memberModel=mapEntityToModel(mapper,memberEntity.get(),Member.class);
		return memberModel;
	}

	@Override
	public void deletePersonById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Member> savePersons(List<Member> memberModels) {
		final List<com.jmk.people.entity.Member> memberEntities = new ArrayList<>();
		memberModels.forEach(memberModel -> memberEntities.add(mapModelToEntity(mapper, memberModel, com.jmk.people.entity.Member.class)));
		Iterable<com.jmk.people.entity.Member> iterableMembers = repository.saveAll(memberEntities);
		final List<com.jmk.people.entity.Member> savedMemberEntities = StreamSupport.stream(iterableMembers.spliterator(), false).collect(Collectors.toList());
		savedMemberEntities.forEach(sourceMember -> memberModels.add(mapEntityToModel(mapper, sourceMember, Member.class)));
		return memberModels;
	}

	@Override
	public List<Member> findAllPersonsByStatus(Status status) {
		List<Member> memberModels=new ArrayList<>();
		Iterable<com.jmk.people.entity.Member> iterableMembers=repository.findAll();
		List<com.jmk.people.entity.Member> memberEntities=StreamSupport.stream(iterableMembers.spliterator(),false).collect(Collectors.toList());
		memberEntities.forEach(sourceMember->memberModels.add(mapEntityToModel(mapper,sourceMember, Member.class)));
		return memberModels;
	}

	@Override
	public Member findPersonByMobileNumber(String mobileNumber) {
		return null;
	}

}
