package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	public BookingService(final BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}
	
	@Transactional
	public void saveBooking(final Booking booking) {
		this.bookingRepository.save(booking);
	}
	
	@Transactional
	public void deleteBooking(final Booking booking) {
		this.bookingRepository.delete(booking);
	}
	
	@Transactional(readOnly = true)
	public List<Booking> getOwnersBookings(final Owner owner){
		return this.bookingRepository.getOwnersBookings(owner);
	}

	@Transactional
	public void deleteBookingById(final int bookingId) {
		this.bookingRepository.deleteById(bookingId);
		
	}
	
}
