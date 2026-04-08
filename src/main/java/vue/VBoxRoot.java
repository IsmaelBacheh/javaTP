package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;

public class VBoxRoot extends VBox {
    StackPane monthsStackPane = new StackPane();
    Button precedentMoisButton = new Button("<");
    Button suivantMoisButton = new Button(">");
    Button dernierMoisButton = new Button(">>");
    Button premierMoisButton = new Button("<<");
    Label titleLabel;
    int annee;
    int moisCourant;

    public VBoxRoot(){
        DateCalendrier aujourdhui = new DateCalendrier();
        int mois = aujourdhui.getMois();
        annee = aujourdhui.getAnnee();
        moisCourant = mois;
        titleLabel = new Label(ConstantesCalendrier.Mois.values()[mois-1].toString() + "" + annee);
        CalendrierDuMois calendrier = new CalendrierDuMois(mois, annee);


        VBox.setMargin(suivantMoisButton, new Insets(14));
        VBox.setMargin(precedentMoisButton, new Insets(14));
        this.getChildren().add(precedentMoisButton);
        this.getChildren().add(suivantMoisButton);
        precedentMoisButton.setOnAction(e -> {
            moisCourant--;
            if(moisCourant == 0){moisCourant = 12;}
            this.allerAuMois(moisCourant);
            this.setTitle(moisCourant);
        });
        suivantMoisButton.setOnAction(e -> {
            moisCourant++;
            if(moisCourant == 13){moisCourant = 1;}
            this.allerAuMois(moisCourant);
            this.setTitle(moisCourant);
        });
        dernierMoisButton.setOnAction(e -> {
            moisCourant = 12;
            this.allerAuMois(moisCourant);
            this.setTitle(moisCourant);
        });
        premierMoisButton.setOnAction(e -> {
            moisCourant = 1;
            this.allerAuMois(moisCourant);
            this.setTitle(moisCourant);
        });
        HBox hBox = new HBox();


        ToggleGroup buttonGroup = new ToggleGroup();
        for (int monthIndex = 1; monthIndex <= 12; monthIndex++) {
            CalendrierDuMois monthCalendrier = new CalendrierDuMois(monthIndex, annee);

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendrier.getDates().size() / 7 + 1);
            tilePane.setId("opaque");

            //la boucle qui crée les labels de la 1er ligne
            for (ConstantesCalendrier.Jours jour : ConstantesCalendrier.Jours.values()) {
                Label dayLabel = new Label(jour.toString().substring(0,2));
                tilePane.getChildren().add(dayLabel);
            }

            VBox boxDates = new VBox();
            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boxDates);
            VBox.setMargin(scrollPaneDates, new Insets(4));
           // this.getChildren().add(scrollPaneDates);
            for(DateCalendrier date : monthCalendrier.getDates()) {
                //
                ToggleButton dateButton = new ToggleButton(Integer.toString(date.getJour()));

                dateButton.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(dateButton);

                dateButton.setUserData(date);
                dateButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println(dateButton.getUserData());
                    }
                });

                Label dateLabel = new Label(date.toString());
                VBox.setMargin(dateLabel, new Insets(8));
                boxDates.getChildren().add(dateLabel);
                if (date.getMois() != mois) {
                    dateLabel.setId("dateOutOfMonth");
                }
                if (date.compareTo(aujourdhui) == 0) {
                    dateLabel.setId("today");
                }
            }
            monthsStackPane.getChildren().add(scrollPaneDates);
            scrollPaneDates.setAccessibleText(ConstantesCalendrier.Mois.values()[monthIndex-1].toString());
        }
        this.getChildren().add(monthsStackPane);

        this.allerAuMois(moisCourant);
        hBox.getChildren().addAll(titleLabel,premierMoisButton, precedentMoisButton, suivantMoisButton, dernierMoisButton);
        this.getChildren().add(hBox);
    }

    void allerAuMois(int parMois) {
        String mois = ConstantesCalendrier.Mois.values()[parMois-1].toString();

        Node dernierElement = monthsStackPane.getChildren().get(monthsStackPane.getChildren().size()-1);

        while (dernierElement.getAccessibleText().compareTo(mois) != 0) {
            dernierElement.toBack();
            dernierElement = monthsStackPane.getChildren().get(monthsStackPane.getChildren().size()-1);
        }
    }
    void setTitle(int leMoisCourant) {
        titleLabel.setText(ConstantesCalendrier.Mois.values()[leMoisCourant-1].toString() + "" + annee);
    }

}