// Reservation – Represents a booking/reservation.

public class Reservation {
    private String passengerName;
    private Flight flight;

    public Reservation(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public String getDetails() {
        return "Reservation for " + passengerName + " on " + flight.getFlightNumber();
    }
}
