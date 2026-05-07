package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Platform;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class GridPaneFormulaireReservation extends GridPane {
    public GridPaneFormulaireReservation() {
        Controleur controleur = new Controleur();
        this.setHgap(10);
        this.setVgap(10);

        Label dateFormulaire = new Label("Date");
        this.add(dateFormulaire, 0, 0);

        Separator sep = new Separator(Orientation.HORIZONTAL);
        this.add(sep, 0, 1, 6, 1);

        Label lblCours = new Label("_Cours");
        TextField txtCours = new TextField();
        lblCours.setMnemonicParsing(true);
        this.add(lblCours, 0, 2);
        this.add(txtCours, 1, 2, 5, 1);
        Platform.runLater(()-> txtCours.requestFocus());

        // Affichage des Niveau ------------------------------------------------------
        ToggleGroup levelGroup = new ToggleGroup();

        Label lblNiveau = new Label("Niveau");
        this.add(lblNiveau, 0, 3);

        RadioButton rbDebutant = new RadioButton("_débutant");
        rbDebutant.setToggleGroup(levelGroup);
        rbDebutant.setMnemonicParsing(true);
        this.add(rbDebutant, 1, 3,2,1);

        RadioButton rbMoyen = new RadioButton("_moyen");
        rbMoyen.setToggleGroup(levelGroup);
        rbMoyen.setMnemonicParsing(true);
        this.add(rbMoyen, 3, 3,2,1);

        RadioButton rbAvance = new RadioButton("_avancé");
        rbAvance.setToggleGroup(levelGroup);
        rbAvance.setMnemonicParsing(true);
        this.add(rbAvance, 1, 4,2,1);

        RadioButton rbExpert = new RadioButton("_expert");
        rbExpert.setToggleGroup(levelGroup);
        rbExpert.setMnemonicParsing(true);
        this.add(rbExpert, 3, 4,2,1);

        // Affichage des Horaires --------------------------------------------------

        Label lblHoraire = new Label("Horaire");
        this.add(lblHoraire, 0, 5);

        Label lblDe = new Label("de");
        this.add(lblDe, 1, 5);
        ComboBox<String> heureDebut = new ComboBox<>();
        for (int i = 0; i <= 23; i++) {
            heureDebut.getItems().add(String.format("%02d", i));
        }
        heureDebut.setValue("07");
        this.add(heureDebut, 2, 5);
        Label lblhDebut =  new Label("h");
        this.add(lblhDebut, 3, 5);

        ComboBox<String> minDebut = new ComboBox<>();
        for (int i = 0; i < 60; i += 15) {
            minDebut.getItems().add(String.format("%02d", i));
        }
        minDebut.setValue("00");
        this.add(minDebut, 4, 5);
        Label lblmmDebut =  new Label("mm");
        this.add(lblmmDebut, 5, 5);

        Label lblA = new Label("à");
        this.add(lblA, 1, 6);

        ComboBox<String> heureFin = new ComboBox<>();
        for (int i = 0; i <= 23; i++) {
            heureFin.getItems().add(String.format("%02d", i));
        }
        heureFin.setValue("08");
        this.add(heureFin, 2, 6);
        Label lblhFin =  new Label("h");
        this.add(lblhFin, 3, 6);

        ComboBox<String> minFin = new ComboBox<>();
        for (int i = 0; i < 60; i += 15) {
            minFin.getItems().add(String.format("%02d", i));
        }
        minFin.setValue("00");
        this.add(minFin, 4, 6);
        Label lblmmFin =  new Label("mm");
        this.add(lblmmFin, 5, 6);

        // Bas de page -----------------------------------------------------------
        Separator sep2 = new Separator(Orientation.HORIZONTAL);
        this.add(sep2, 0, 7, 6, 1);

        Button btnAnnuler = new Button("_Annuler");
        Button btnEnregistrer = new Button("_Enregistrer");

        btnEnregistrer.addEventHandler(ActionEvent.ACTION, controleur);

        btnAnnuler.setMnemonicParsing(true);
        btnEnregistrer.setMnemonicParsing(true);

        this.add(btnAnnuler, 2, 8,2,1);
        this.add(btnEnregistrer, 3, 8,3,1);
    }
}
