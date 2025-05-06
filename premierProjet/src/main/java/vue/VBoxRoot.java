package vue;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

import java.util.List;

public class VBoxRoot extends VBox implements ConstantesCalendrier {


    public VBoxRoot() {


        StackPane stackPaneMois = new StackPane();

        for (int i = 1; i <= 12; i++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i, 2025);
//System.out.println (monthCalendar);

            VBox boiteDates = new VBox();
            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteDates);
            scrollPaneDates.setAccessibleText(MOIS[ i -1]);
            VBox.setMargin(scrollPaneDates, new Insets(4));
            for (DateCalendrier date : monthCalendar.getDates()) {
                Label labelDate = new Label(date.toString());
// les attributs id sont utilisés dans la feuille de style
                if (date.getMois() != monthCalendar.getMois()) {
                    labelDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    labelDate.setId("today");
                }
                VBox.setMargin(labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }
            stackPaneMois.getChildren().add(scrollPaneDates);
        }
        Date today = new Date();
        Label labelTitle = new Label(MOIS[today.getMois() - 1] + " " + today.getAnnee());
        VBox.setMargin(labelTitle, new Insets(14));
        this.getChildren().add( labelTitle);
        this.getChildren().add( stackPaneMois);




        List<Node> listScrollPanes = stackPaneMois.getChildren();
        String moisActuel = MOIS[today.getMois() - 1];


        while (! moisActuel.equals(listScrollPanes.get(11).getAccessibleText())){

            System.out.println(listScrollPanes.get(11).getAccessibleText());

            listScrollPanes.get(0).toFront();

        }

        Button boutonNext = new Button(">");
        Button boutonPrevious = new Button("<");
        this.getChildren().addAll(boutonNext,boutonPrevious);


        boutonNext.setOnAction(event -> {

            listScrollPanes.get(0).toFront();

        });

        boutonPrevious.setOnAction(event -> {


            listScrollPanes.get(11).toBack();


        });

    }
}
