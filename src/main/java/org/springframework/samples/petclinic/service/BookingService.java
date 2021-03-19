package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	public BookingService(final BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}
	
	public void saveBooking(final Booking booking) {
		this.bookingRepository.save(booking);
	}
	
	public void deleteBooking(final Booking booking) {
		this.bookingRepository.delete(booking);
	}
	
	public List<Booking> getOwnersBookings(final int ownerId){
		return this.bookingRepository.getOwnersBookings(ownerId);
	}
	
	
	
	
	
}
