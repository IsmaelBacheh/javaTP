package vue;

import controleur.Controleur;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import modele.PlanningCollections;
import modele.Reservation;


public class HBoxRoot extends HBox {
    private static PlanningCollections planning;
    private static Controleur controleur;
    private static VBoxCalendrier calendrierPane;
    private static GridPaneFormulaireReservation reservationPane;

    public HBoxRoot() {
        this.planning = new PlanningCollections();
        this.controleur = new Controleur();
        this.calendrierPane = new VBoxCalendrier();
        this.reservationPane = new GridPaneFormulaireReservation();

        this.getChildren().add(calendrierPane);
        this.getChildren().add(reservationPane);
    }

    //Ajout des accesseurs pour les 4 champs --------------------------------
    public static PlanningCollections getPlanning() {
        return planning;
    }
    public static Controleur getControleur() {
        return controleur;
    }
    public static VBoxCalendrier getCalendrierPane() {
        return calendrierPane;
    }
    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

}
