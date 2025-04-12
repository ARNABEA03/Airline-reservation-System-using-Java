import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainView {
    private ReservationSystem system = new ReservationSystem();
    private ObservableList<String> reservationList = FXCollections.observableArrayList();

    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label header = new Label("✈️ Airline Reservation System");
        header.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        VBox flightBox = new VBox(5);
        flightBox.getChildren().add(new Label("Available Flights:"));

        for (Flight flight : system.getFlights()) {
            HBox flightRow = new HBox(10);
            Label flightLabel = new Label(flight.getDetails());
            Button bookBtn = new Button("Book");
            bookBtn.setOnAction(e -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Book Seat");
                dialog.setHeaderText("Enter passenger name:");
                dialog.showAndWait().ifPresent(name -> {
                    if (flight.bookSeat()) {
                        system.addReservation(name, flight);
                        reservationList.add(name + " on " + flight.getFlightNumber());
                    } else {
                        showAlert("No seats available.");
                    }
                });
            });
            flightRow.getChildren().addAll(flightLabel, bookBtn);
            flightBox.getChildren().add(flightRow);
        }

        ListView<String> reservationView = new ListView<>(reservationList);
        reservationView.setPrefHeight(150);
        VBox reservationBox = new VBox(5, new Label("Reservations:"), reservationView);

        root.getChildren().addAll(header, flightBox, reservationBox);

        stage.setTitle("Airline Reservation");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
