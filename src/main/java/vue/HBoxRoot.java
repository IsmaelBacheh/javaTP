package vue;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;

public class HBoxRoot extends HBox {
    private VBoxCalendrier calendrier;
    private GridPaneFormulaireReservation formulaireReservation;

    public HBoxRoot() {
        calendrier = new VBoxCalendrier();
        formulaireReservation = new GridPaneFormulaireReservation();

        this.getChildren().add(calendrier);
        this.getChildren().add(formulaireReservation);
    }

}
