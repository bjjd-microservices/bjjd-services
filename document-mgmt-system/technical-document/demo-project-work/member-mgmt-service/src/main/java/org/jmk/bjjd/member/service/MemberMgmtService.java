package org.jmk.bjjd.member.service;

import org.jmk.bjjd.member.model.MemberModel;

public interface MemberMgmtService {

	public MemberModel save(MemberModel member);
	
	public void deleteById(Long id);
	
}
