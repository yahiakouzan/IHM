module org.example.premierprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.premierprojet to javafx.fxml;
    exports org.example.premierprojet;
    exports vue;
    exports modele;
}