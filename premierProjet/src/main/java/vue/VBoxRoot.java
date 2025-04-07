package vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

import java.util.List;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot() {
        Date today = new Date();
        String moisActuel = MOIS [today.getMois()-1];

        Label labelMois = new Label(today.toString());
        StackPane stackPaneMois  = new StackPane();
        for(int i = 1; i <= 12; i ++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i, 2025);
            Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + " " + monthCalendar.getAnnee());
            VBox.setMargin( labelTitle, new Insets(14) );
            VBox boiteDates = new VBox ();
            ScrollPane scrollPaneMois = new ScrollPane();
            scrollPaneMois.setAccessibleText(MOIS[i-1]);
            scrollPaneMois.setContent(boiteDates);
            scrollPaneMois.setContent(labelMois);
            VBox.setMargin( scrollPaneMois, new Insets(4) );
            for (DateCalendrier date : monthCalendar.getDates()) {
                Label labelDate = new Label(date.toString());
                if (date.getMois()!= monthCalendar.getMois()) {
                    labelDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    labelDate.setId("today");
                }
                VBox.setMargin( labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }
            stackPaneMois.getChildren().add(scrollPaneMois);
        }
        Label labelGlobal = new Label("Calendrier 2025");
        VBox.setMargin(labelGlobal, new Insets(8));
        this.getChildren().add(stackPaneMois );
        List<Node> listeNode = stackPaneMois.getChildren();
        while(!listeNode.get(listeNode.size()-1).getAccessibleText().equals(moisActuel)){

        }
    }
}
