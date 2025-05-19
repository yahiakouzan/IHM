package vue;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import modele.Date;
import modele.DateCalendrier;
import static modele.ConstantesCalendrier.*;

public class GridPaneFormulaireReservation extends GridPane {
    private Label dateReservationLabel;
    GridPaneFormulaireReservation(){
        this.setHgap(10);
        this.setVgap(10);

        //Instanciation
        dateReservationLabel =  new Label(new DateCalendrier().toString());

        Separator separateur1 = new Separator();
        Separator separateur2 = new Separator();
        Label coursLabel = new Label("_"+"Cours :");
        coursLabel.setMnemonicParsing(true);

        TextField coursTextField = new TextField();

        coursLabel.setLabelFor(coursTextField);

        Label niveauLabel = new Label("Niveau :");

        ToggleGroup niveauBoutons = new ToggleGroup();
        for(String niveau : NIVEAUX){
            RadioButton radioButton = new RadioButton("_"+niveau);
            radioButton.setSelected(niveau.equals(NIVEAUX[0]));
            radioButton.setUserData(niveau);
            radioButton.setToggleGroup(niveauBoutons);
            radioButton.setPadding(new Insets(5));
        }



        Label horaireLabel = new Label("Horaire :");
        Label deLabel = new Label("de");

        ComboBox<String> heureDebut = peupleComboBox(HEURES);

        ComboBox<String> minutesDebut = peupleComboBox(MINUTES);

        Label heureLabelDebut = new Label("h");
        Label minutesLabelDebut = new Label("min");
        Label heureLabelFin = new Label("h");
        Label minutesLabelFin = new Label("min");
        Label aLabel = new Label("à");

        ComboBox<String> heureFin = peupleComboBox(HEURES);
        ComboBox<String> minutesFin = peupleComboBox(MINUTES);

        heureDebut.getSelectionModel().select(0);
        minutesDebut.getSelectionModel().select(0);
        heureFin.getSelectionModel().select(1);
        minutesFin.getSelectionModel().select(0);

        Button annulerBouton = new Button("_"+"Annuler");
        Button enregistrerBouton = new Button("_"+"Enregistrer");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Ajout des éléments au GridPaneFormulaireReservation

        //this.setGridLinesVisible(true); //Test

        //Ligne 0
        this.add(dateReservationLabel,2,0,3,1);

        //Ligne 1
        this.add(separateur1,0,1,6,1);

        //Ligne 2
        this.add(coursLabel,0,2);
        this.add(coursTextField,1,2,5,1);

        //Ligne 3
        this.add(niveauLabel,0,3);
        this.add((Node)niveauBoutons.getToggles().get(0),1,3,2,1); //Bouton débutant
        this.add((Node)niveauBoutons.getToggles().get(1),3,3,2,1); //Bouton moyen

        //Ligne 4
        this.add((Node)niveauBoutons.getToggles().get(2),1,4,2,1); //Bouton avancé
        this.add((Node)niveauBoutons.getToggles().get(3),3,4,2,1); //Bouton expert

        //Ligne 5
        this.add(horaireLabel,0,5);
        this.add(deLabel,1,5);
        this.add(heureDebut,2,5);
        this.add(heureLabelDebut,3,5);
        this.add(minutesDebut,4,5);
        this.add(minutesLabelDebut,5,5);

        //Ligne 6
        this.add(aLabel,1,6);
        this.add(heureFin,2,6);
        this.add(heureLabelFin,3,6);
        this.add(minutesFin,4,6);
        this.add(minutesLabelFin,5,6);

        //Ligne 7
        this.add(separateur2,0,7,6,1);

        //Ligne 8
        this.add(annulerBouton,2,8,2,1);
        this.add(enregistrerBouton,4,8,2,1);

        //Focus sur le textfield
        Platform.runLater(() -> coursTextField.requestFocus());

        annulerBouton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                heureDebut.getSelectionModel().select(0);
                minutesDebut.getSelectionModel().select(0);
                heureFin.getSelectionModel().select(1);
                minutesFin.getSelectionModel().select(0);
                coursTextField.setText("");
            }
        });
    }

    public void setDateSelectionnee(Date date) {
        this.dateReservationLabel.setText(date.toString()); // Mise à jour de l'affichage
    }


    private ComboBox<String> peupleComboBox(String [] strings){
        ComboBox<String> comboBox = new ComboBox<>();
        for(String string : strings){
            comboBox.getItems().add(string);
        }
        return comboBox;
    }
}
