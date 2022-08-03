package org.jmk.bjjd.member.repository;

import org.jmk.bjjd.member.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<MemberEntity,Long> {

}