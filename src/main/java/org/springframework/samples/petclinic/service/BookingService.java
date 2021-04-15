
package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Booking;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.BookingRepository;
import org.springframework.samples.petclinic.service.exceptions.BookingSavingException;
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
	public void saveBooking(final Booking booking) throws BookingSavingException {
		final List<Booking> oldBookings = this.bookingRepository.getPetsBooking(booking.getPet());

		final LocalDate newStartDate = booking.getStartDate();
		final LocalDate newEndDate = booking.getEndDate();

		if (newStartDate.compareTo(newEndDate) > 0)
			throw new BookingSavingException("La fecha de inicio debe ser anterior a la fecha de fin");

		if (newStartDate.compareTo(LocalDate.now()) < 0 || newEndDate.compareTo(LocalDate.now()) < 0)
			throw new BookingSavingException("La reserva debe ser para días posteriores");

		boolean existsConcurrency = false;

		for (final Booking old : oldBookings) {

			final LocalDate oldStartDate = old.getStartDate();
			final LocalDate oldEndDate = old.getEndDate();

			existsConcurrency = (oldStartDate.compareTo(newStartDate) <= 0 
							&& oldEndDate.compareTo(newStartDate) >= 0) 
				
						|| (oldStartDate.compareTo(newEndDate) <= 0 
							&& oldEndDate.compareTo(newEndDate) >= 0)
						
						|| (newStartDate.compareTo(oldStartDate) <= 0 
							&& newEndDate.compareTo(oldStartDate) >= 0) 
						
						|| (newStartDate.compareTo(oldEndDate) <= 0 
							&& newEndDate.compareTo(oldEndDate) >= 0);

			if (existsConcurrency)
				throw new BookingSavingException("Concurrencia de fechas, intente otras distintas");
		}

		this.bookingRepository.save(booking);
	}

	@Transactional(readOnly = true)
	public List<Booking> getOwnersBookings(final Owner owner) {
		return this.bookingRepository.getOwnersBookings(owner);
	}

	@Transactional
	public void deleteBooking(final Booking booking) {
		this.bookingRepository.delete(booking);
	}

	@Transactional
	public void deleteBookingById(final int bookingId) {
		this.bookingRepository.deleteById(bookingId);

	}

	@Transactional(readOnly = true)
	public Optional<Booking> getBookingById(final int bookingId) {
		return this.bookingRepository.findById(bookingId);
	}

}
