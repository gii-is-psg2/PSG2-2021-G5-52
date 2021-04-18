package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Adoption;
import org.springframework.samples.petclinic.repository.AdoptionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdoptionService {

	private final AdoptionsRepository adoptionsRepository;
	
	@Autowired
	public AdoptionService(final AdoptionsRepository adoptionsRepository) {
		super();
		this.adoptionsRepository = adoptionsRepository;
	}
	
	@Transactional
	public void saveAdoptions(final Adoption adoptions) {
		this.adoptionsRepository.save(adoptions);
	}
	
	@Transactional
	public void deleteAdoptions(final Adoption adoptions) {
		this.adoptionsRepository.delete(adoptions);
	}
	
	@Transactional
	public Iterable<Adoption> findAll() {
		return this.adoptionsRepository.findAll();
	}

	@Transactional
	public void deleteAdoptionsById(final int adoptionsId) {
		this.adoptionsRepository.deleteById(adoptionsId);
		
	}
	
	@Transactional(readOnly = true)
	public Optional<Adoption> getAdoptionsById(final int adoptionsId) {
		return this.adoptionsRepository.findById(adoptionsId);
	}

}
