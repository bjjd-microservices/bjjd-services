package com.jmk.darshan.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.darshan.enums.VisitorType;
import com.jmk.darshan.feign.client.PeopleMgmtServiceClient;
import com.jmk.darshan.model.Darshan;
import com.jmk.eh.exception.StatusNotActiveException;
import com.jmk.enums.Status;
import com.jmk.people.model.Person;

@Component
public class DarshanRequestValidator implements RequestValidator {

	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceClient;

	@Override
	public boolean validate(Darshan darshan) {
		boolean validRequest = false;

		if (darshan.getVisitorType() == VisitorType.DEVOTEE && darshan.getVisitorId() == null) {
			validRequest = true;
		} else if (darshan.getVisitorMobileNo() != null && darshan.getVisitorType() != null) {
			VisitorType visitorType = darshan.getVisitorType();
			ResponseEntity<? extends Person> responseEntity = null;
			switch (visitorType) {
			case MEMBER:
				responseEntity = peopleMgmtServiceClient.findMemberDetailsById(darshan.getVisitorId());
				break;
			case SEVADAR:
				responseEntity = peopleMgmtServiceClient.findSevadarDetailsById(darshan.getVisitorId());
				break;
			case DEVOTEE:
				responseEntity = peopleMgmtServiceClient.findDevoteeDetailsById(darshan.getVisitorId());
				break;
			default:
			}
			Person person = responseEntity.getBody();
			if (person != null && Status.A.equals(person.getStatus())) {
				validRequest = true;
			} else {
				throw new StatusNotActiveException(person.getClass(), "id", person.getId().toString());
			}
		}

		return validRequest;
	}

}

