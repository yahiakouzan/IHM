package vue;


import javafx.collections.ObservableList;
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
import modele.Date;
import modele.DateCalendrier;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot() {

        Button boutonSuivant = new Button(">");
        Button boutonPrecedent = new Button("<");
        Button boutonDernier = new Button(">>");
        Button boutonPremier = new Button("<<");

        Date today = new Date();
        StackPane stackPaneMois = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();
        for(int numMois = 1; numMois <= 12; numMois++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois, today.getAnnee());
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size()%7+1);
            tilePane.setId("opaque");
            for (String jourAb : JOURS_SEMAINE){
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }
            for(DateCalendrier date : monthCalendar.getDates()){
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));
                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);
                boutonDate.setUserData(date);
                boutonDate.setUserData(date);
                Controleur controleur = new Controleur();
                boutonDate.addEventHandler(ActionEvent.ACTION, controleur);
                if (date.getMois() != monthCalendar.getMois()){
                    boutonDate.setId("dateHorsMois");
                }
                if (date.compareTo(today) == 0) {
                    boutonDate.setId("today");
                }
            }
            Label labelMois = new Label(MOIS[numMois-1]);
            labelMois.setId("mois");
            tilePane.getChildren().add(labelMois);
            tilePane.setAccessibleText(MOIS[numMois-1]);
            stackPaneMois.getChildren().add(tilePane);
        }
        boutonSuivant.setOnAction(e -> {
            List <Node> childSuivant = stackPaneMois.getChildren();
            if(childSuivant.size() > 1){
                childSuivant.get(0).toFront();
            }
        });
        boutonPrecedent.setOnAction(e -> {
            List <Node> childPreced = stackPaneMois.getChildren();
            if(childPreced.size() > 1){
                childPreced.get(childPreced.size()-1).toBack();
            }
        });
        boutonDernier.setOnAction(e -> {
            List <Node> childD = stackPaneMois.getChildren();
            while(!childD.get(childD.size()-1).getAccessibleText().equals(MOIS[11])){
                childD.get(0).toFront();
            }
        });
        boutonPremier.setOnAction(e -> {
            List <Node> childP = stackPaneMois.getChildren();
            while(!childP.get(childP.size()-1).getAccessibleText().equals(MOIS[0])){
                childP.get(childP.size()-1).toBack();
            }
        });

        while (!stackPaneMois.getChildren().get(stackPaneMois.getChildren().size()-1).getAccessibleText().equals(MOIS[(new DateCalendrier()).getMois()-1])){
            stackPaneMois.getChildren().get(0).toFront();
        }

        HBox hBox = new HBox(10, boutonPrecedent, boutonSuivant, boutonPremier, boutonDernier);
        this.getChildren().addAll(stackPaneMois, hBox);
    }
}
