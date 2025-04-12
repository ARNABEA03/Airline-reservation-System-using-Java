import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ReservationSystem() {
        flights.add(new Flight("AI101", "Delhi", "Mumbai", 5));
        flights.add(new Flight("AI102", "Mumbai", "Bangalore", 3));
        flights.add(new Flight("AI103", "Delhi", "Chennai", 4));
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Airline Reservation System ---");
            System.out.println("1. View Flights\n2. Book Flight\n3. View Reservations\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewFlights();
                case 2 -> bookFlight();
                case 3 -> viewReservations();
                case 4 -> {
                    System.out.println("Thank you for using the system.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void viewFlights() {
        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i).getDetails());
        }
    }

    private void bookFlight() {
        viewFlights();
        System.out.print("Enter flight number to book (1-" + flights.size() + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < flights.size()) {
            Flight selectedFlight = flights.get(index);
            System.out.print("Enter passenger name: ");
            String name = scanner.nextLine();

            if (selectedFlight.bookSeat()) {
                reservations.add(new Reservation(name, selectedFlight));
                System.out.println("Booking successful!");
            } else {
                System.out.println("Sorry, no seats available.");
            }
        } else {
            System.out.println("Invalid flight selection.");
        }
    }

    private void viewReservations() {
        System.out.println("\nCurrent Reservations:");
        for (Reservation r : reservations) {
            System.out.println(r.getDetails());
        }
    }
}
