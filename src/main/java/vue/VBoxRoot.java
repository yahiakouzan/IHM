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
        /*

        Question 2.1 4

        DateCalendrier dateAujourdhui = new DateCalendrier();
        DateCalendrier dateDemain = dateAujourdhui.dateDuLendemain();

        Label aujourdhui = new Label(dateAujourdhui.toString());
        Label demain = new Label(dateDemain.toString());

        this.getChildren().addAll(aujourdhui, demain);


        Question 2.2 7

        CalendrierDuMois calendrierDuMois = new CalendrierDuMois(2,2025);
        Label moisAnnee = new Label(Integer.toString(calendrierDuMois.getMois()) + " " + Integer.toString(calendrierDuMois.getAnnee()));
        VBox date = new VBox();
        Collection<DateCalendrier> dates = calendrierDuMois.getDates();
        for (DateCalendrier dateCalendrier : dates) {
            Label dateLabel = new Label(dateCalendrier.toString());
            date.getChildren().add(dateLabel);
        }
        this.getChildren().addAll(moisAnnee, date);


        //Question 2.2 8

        CalendrierDuMois calendrierDuMois = new CalendrierDuMois(3,2025);
        Label moisAnnee = new Label(Integer.toString(calendrierDuMois.getMois()) + " " + Integer.toString(calendrierDuMois.getAnnee()));
        VBox date = new VBox();
        Collection<DateCalendrier> dates = calendrierDuMois.getDates();
        for (DateCalendrier dateCalendrier : dates) {
            if (dateCalendrier.compareTo(new DateCalendrier()) == 0) {
                Label dateLabel = new Label(dateCalendrier.toString());
                dateLabel.setId("today");
                date.getChildren().add(dateLabel);
            }
            else {
                Label dateLabel = new Label(dateCalendrier.toString());
                date.getChildren().add(dateLabel);
            }
        }
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(date);
        this.getChildren().addAll(moisAnnee, scrollPaneDates);

        // TD2
        // Question 1.1.1
        StackPane stackPaneMois = new StackPane();
        for(int i=1; i<=12; i++) {
            CalendrierDuMois calendrierDuMois = new CalendrierDuMois(i, 2025);
            VBox date = new VBox();
            Collection<DateCalendrier> dates = calendrierDuMois.getDates();
            for (DateCalendrier dateCalendrier : dates) {
                if (dateCalendrier.compareTo(new DateCalendrier()) == 0) {
                    Label dateLabel = new Label(dateCalendrier.toString());
                    dateLabel.setId("today");
                    date.getChildren().add(dateLabel);
                } else {
                    Label dateLabel = new Label(dateCalendrier.toString());
                    date.getChildren().add(dateLabel);
                }
            }
            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(date);
            scrollPaneDates.setAccessibleText(Integer.toString(i));
            stackPaneMois.getChildren().add(scrollPaneDates);
        }

        while (!stackPaneMois.getChildren().get(stackPaneMois.getChildren().size()-1).getAccessibleText().equals(Integer.toString((new DateCalendrier()).getMois()))){
                stackPaneMois.getChildren().get(0).toFront();
        }
        this.getChildren().add(stackPaneMois);

        // Question 1.2.1


        Button boutonSuivant = new Button(">");
        Button boutonPrecedent = new Button("<");
        Button boutonDernier = new Button(">>");
        Button boutonPremier = new Button("<<");
        StackPane stackPaneMois = new StackPane();
        for(int i=1; i<=12; i++) {
            CalendrierDuMois calendrierDuMois = new CalendrierDuMois(i, 2025);
            VBox date = new VBox();
            Collection<DateCalendrier> dates = calendrierDuMois.getDates();
            for (DateCalendrier dateCalendrier : dates) {
                if (dateCalendrier.compareTo(new DateCalendrier()) == 0) {
                    Label dateLabel = new Label(dateCalendrier.toString());
                    dateLabel.setId("today");
                    date.getChildren().add(dateLabel);
                } else {
                    Label dateLabel = new Label(dateCalendrier.toString());
                    date.getChildren().add(dateLabel);
                }
            }
            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(date);
            scrollPaneDates.setAccessibleText(Integer.toString(i));
            stackPaneMois.getChildren().add(scrollPaneDates);
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
            while(!childD.get(childD.size()-1).getAccessibleText().equals("12")){
                childD.get(0).toFront();
            }
        });
        boutonPremier.setOnAction(e -> {
            List <Node> childP = stackPaneMois.getChildren();
            while(!childP.get(childP.size()-1).getAccessibleText().equals("1")){
                childP.get(childP.size()-1).toBack();
            }
        });
        while (!stackPaneMois.getChildren().get(stackPaneMois.getChildren().size()-1).getAccessibleText().equals(Integer.toString((new DateCalendrier()).getMois()))){
                stackPaneMois.getChildren().get(0).toFront();
        }
        HBox hBox = new HBox(10, boutonPrecedent, boutonSuivant, boutonPremier, boutonDernier);
        this.getChildren().addAll(stackPaneMois, hBox);
        */

        // TP4

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
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println(date.getJour());
                    }
                });
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
