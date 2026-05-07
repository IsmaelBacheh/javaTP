package controleur;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import modele.PlanningCollections;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event){
        PlanningCollections planningCollections = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        //la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton toggleButton = (ToggleButton) event.getSource();
        }

        // la source de event est le bouton "Enregistrer" du formullaire de reservation
        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
        }
    }
}
