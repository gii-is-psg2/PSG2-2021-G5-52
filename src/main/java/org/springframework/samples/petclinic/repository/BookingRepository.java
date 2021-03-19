package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Booking;


public interface BookingRepository extends CrudRepository<Booking, Integer>{

	@Query("SELECT b FROM Booking b WHERE b.pet.owner.id = :ownerId")
	List<Booking> getOwnersBookings(@Param("ownerId") int ownerId);
   
}
