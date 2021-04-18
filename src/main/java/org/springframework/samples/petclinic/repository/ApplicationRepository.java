package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer>{

}
