package com.jmk.upload.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.jmk.account.enums.DonorType;
import com.jmk.cache.PeopleCache;
import com.jmk.cache.ProjectCache;
import com.jmk.enums.AddressType;
import com.jmk.enums.DocumentType;
import com.jmk.enums.Status;
import com.jmk.people.model.Address;
import com.jmk.people.model.Identity;
import com.jmk.people.model.Person;
import com.jmk.project.model.Project;
import com.jmk.upload.model.Donation;

@Component
public class DonationValidator extends LocalValidatorFactoryBean implements Validator {
	
	@Autowired
	private ProjectCache projectCache;
	
	@Autowired
	private PeopleCache peopleCache;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Donation.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Donation donation = (Donation) target;

		//Project Name is Required value
		if (StringUtils.isEmpty(donation.getProjectName())) {
			errors.rejectValue("projectName", "project.name.required", "Project Name is Required.");
		}
		
		//Project Code is Required value
		if (StringUtils.isEmpty(donation.getProjectCode())) {
				errors.rejectValue("projectCode", "project.code.required", "Project code is Required.");
		}else {
			Project project=projectCache.getProjectByCode(donation.getProjectCode());
			if(project==null) {
				errors.rejectValue("projectCode","project.code.notExist","Project Code does not exist.");
			}else if(project.getStatus()!=Status.A){
				errors.rejectValue("projectCode","project.code.notActive","Project Code is not active.");
			}else {
				enrichDonationWithProjectDetails(donation,project);
			}
		}
				
		//Donor Type is required value
		if (StringUtils.isEmpty(donation.getDonorType())) {
			errors.rejectValue("donorType", "donation.donorType.requrired", "Donor Type is required.");
		}
		
		//Donor Name is required value
		if(StringUtils.isEmpty(donation.getDonorName())) {
			errors.rejectValue("donorName", "donation.donorName.requrired", "Donor name is required.");
		}
		
		//Donor MobileNo is required value
		if(StringUtils.isEmpty(donation.getDonorMobileNo())) {
			errors.rejectValue("donorMobileNo", "donation.donorMobileNo.requrired", "Donor MobileNo is required.");
		}else if(!StringUtils.isEmpty(donation.getDonorType())){
			DonorType donorType=donation.getDonorType();
			Person person=null;
			
			switch(donorType) {
			case MEMBER:
				person=peopleCache.getMemberByMobile(donation.getDonorMobileNo());
				break;
			case SEVADAR:
				person=peopleCache.getSevadarByMobile(donation.getDonorMobileNo());
				break;
			case DEVOTEE:
				person=peopleCache.getDevoteeByMobile(donation.getDonorMobileNo());
				break;
			default:
			}
			if (person == null) {
				if (donorType != DonorType.DEVOTEE) {
					errors.rejectValue("donorMobileNo", "donation.donorMobileNo.requrired",
							"Donor does not exist having this mobile number.");
				}
			} else {
				enrichDonationWithDonorDetails(donation, person);
			}
		}
		
		if(donation.getAmount().doubleValue()<=0) {
			errors.rejectValue("donationAmount","donation.amount.invalid","Donation Amount is invalid");
		}
	
	}
	
	private void enrichDonationWithProjectDetails(Donation donation,Project project) {
		donation.setProjectId(project.getId());
		donation.setProjectName(project.getName());
	}
	
	private void enrichDonationWithDonorDetails(Donation donation, Person person) {
		donation.setDonorId(person.getId());
		donation.setDonorName(person.getFirstName() + " " + person.getLastName());
		donation.setDonorMobileNo(person.getMobileNo());
		Identity aadharIdentity = person.getIdentities().stream()
				.filter(identity -> identity.getDocumentType() == DocumentType.AADHARCARD).findAny().orElse(null);
		if (aadharIdentity != null) {
			donation.setDonorAadharNo(aadharIdentity.getDocumentNumber());
		}
		Identity panIdentity = person.getIdentities().stream()
				.filter(identity -> identity.getDocumentType() == DocumentType.PANCARD).findAny().orElse(null);
		if (panIdentity != null) {
			donation.setDonorPANNo(panIdentity.getDocumentNumber());
		}
		Address personAddress = person.getAddresses().stream()
				.filter(address -> address.getAddressType() == AddressType.PERMANENT).findAny().orElse(null);

		if (personAddress != null) {
			donation.setDonorAddress(personAddress.getAddressLine1());
			donation.setDonorCity(personAddress.getCity());
			donation.setDonorState(personAddress.getState());
		}
	}
}
