module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jdk.jdi;

    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    exports vue;
    exports modele;
}