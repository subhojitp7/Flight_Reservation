<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
	<h2>Complete Reservation</h2>
	<pre>
Airline        : ${flight.operatingAirlines}
Departure City : ${flight.departureCity}
Arrival City   : ${flight.arrivalCity}
	</pre>
	<form action="completeReservation" method="post">
		<h2>Passenger Details:</h2>
		<pre>
First Name : <input type="text" name="firstName" />
last Name  : <input type="text" name="lastName" />
Email      : <input type="text" name="email" />
Phone      : <input type="text" name="phone" />
</pre>
		<h2>Card Details:</h2>
		<pre>
Card Number     : <input type="text" name="cardNumber" />
Name on card    : <input type="text" name="nameOnCard" />
Expiration Date : <input type="text" name="expirationDate" />
CVV Number      : <input type="text" name="cvvNumber" />
<input type="hidden" name="flightId" value="${flight.id}" />
<input type="submit" value="Confirm" />
</pre>
	</form>

</body>
</html>