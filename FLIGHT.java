//Airline reservation system
// flight.java
public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int totalSeats;
    private int bookedSeats;

    public Flight(String flightNumber, String origin, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public boolean bookSeat() {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDetails() {
        return "Flight " + flightNumber + ": " + origin + " -> " + destination + 
               " | Seats: " + bookedSeats + "/" + totalSeats;
    }
}
