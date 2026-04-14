package vue;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaireReservation extends GridPane {
    public GridPaneFormulaireReservation() {
        this.setHgap(10);
        this.setVgap(10);

        Label dateFormulaire = new Label("Date");
        this.add(dateFormulaire, 0, 0);

        Separator sep = new Separator(Orientation.HORIZONTAL);
        this.add(sep, 0, 1);

        Label lblCours = new Label("Cours");
        TextField txtCours = new TextField();
        this.add(lblCours, 0, 2);
        this.add(txtCours, 1, 2);

        Label lblNiveau = new Label("Niveau");
        this.add(lblNiveau, 0, 3);



    }
}
