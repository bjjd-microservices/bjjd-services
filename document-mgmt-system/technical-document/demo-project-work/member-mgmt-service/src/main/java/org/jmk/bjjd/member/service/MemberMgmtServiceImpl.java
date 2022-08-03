package org.jmk.bjjd.member.service;

import javax.transaction.Transactional;

import org.jmk.bjjd.member.entity.MemberEntity;
import org.jmk.bjjd.member.model.MemberModel;
import org.jmk.bjjd.member.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberMgmtServiceImpl implements MemberMgmtService {
	
	@Autowired
	private MemberRepository repository;

	@Override
	public MemberModel save(MemberModel memberModel) {
		MemberEntity memberEntity=new MemberEntity();
		BeanUtils.copyProperties(memberModel, memberEntity);
		memberEntity=repository.save(memberEntity);
		BeanUtils.copyProperties(memberEntity, memberModel);
		return memberModel;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}
