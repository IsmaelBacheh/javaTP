package controleur;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import modele.Date;
import modele.DateCalendrier;
import modele.PlanningCollections;
import modele.Reservation;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event){
        PlanningCollections planningCollections = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        Reservation newReservation;

        //la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            DateCalendrier date = (DateCalendrier)((ToggleButton) event.getSource()).getUserData();
            reservationPane.update(date);
        }

        // la source de event est le bouton "Enregistrer" du formullaire de reservation
        if (event.getSource() instanceof Button) {
            String cours = reservationPane.getTxtCours().getText();
            String niveau = ((RadioButton)reservationPane.getLevelGroup().getSelectedToggle()).getUserData().toString();
            System.out.println(cours);
            System.out.println(niveau);
        }
    }
}
