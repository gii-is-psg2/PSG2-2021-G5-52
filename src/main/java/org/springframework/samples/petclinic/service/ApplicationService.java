package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

	private ApplicationRepository applicationRepository;
	private OwnerService ownerService;
	private AdoptionService adoptionService;
}
