module com.example.deuxiemeprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.deuxiemeprojet to javafx.fxml;
    exports com.example.deuxiemeprojet;
    exports vue;
}