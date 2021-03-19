<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<petclinic:layout pageName="petHotel">
	<h2>Your bookings</h2>

	<table id="bookingsTable" class="table table-striped">
		<thead>
			<tr>
				<th>Start date</th>
				<th>End date</th>
				<th>Pet</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myBookings}" var="booking">
				<tr>
					<td><c:out value="${booking.startDate}" /></td>
					<td><c:out value="${booking.endDate}" /></td>
					<td><c:out value="${booking.pet.name}" /></td>
					<td><spring:url value="/petHotel/{bookingId}/cancel"
							var="cancelBookingUrl">
							<spring:param name="bookingId" value="${booking.id}" />
						</spring:url> 
						<a href="${fn:escapeXml(cancelBookingUrl)}"> 
						<span aria-hidden="true">Cancel booking </span>
						</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<spring:url value="/petHotel/newBooking" var="newBookingUrl">
	</spring:url>
	<a href="${fn:escapeXml(newBookingUrl)}"> <span aria-hidden="true">Request
			booking</span>
	</a>

</petclinic:layout>
