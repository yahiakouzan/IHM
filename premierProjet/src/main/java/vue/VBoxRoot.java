package vue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;
import java.util.List;
public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot() {
        Date today = new Date();
        String moisActuel = MOIS[today.getMois()+2];
        //Label labelTitle = new Label(MOIS[mois - 1] + " " + monthCalendar.getAnnee());
        StackPane stackPaneMois = new StackPane();
        for (int mois = 1; mois <= 12; mois++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(mois, 2025);
            VBox boiteDates = new VBox();
            ScrollPane scrollPaneMois = new ScrollPane();
            scrollPaneMois.setContent(boiteDates);
            scrollPaneMois.setAccessibleText(MOIS[mois-1]);
            VBox.setMargin(scrollPaneMois, new Insets(4));
            for (DateCalendrier date : monthCalendar.getDates()) {
                Label labelDate = new Label(date.toString());
                if (date.getMois() != monthCalendar.getMois()) {
                    labelDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    labelDate.setId("today");
                }
                VBox.setMargin(labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }
            stackPaneMois.getChildren().add(scrollPaneMois);

        }
        List<Node> listNode = stackPaneMois.getChildren();
        while(!listNode.get(listNode.size()-1).getAccessibleText().equals(moisActuel)) {
            listNode.get(listNode.size()-1).toBack();
        }
        Button boutonArriere = new Button("<<");
        Button boutonArriere2 = new Button("<");
        Button boutonDevant = new Button(">");
        Button boutonDevant2 = new Button(">>");

        boutonArriere2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                listNode.get(11).toBack();
            }
        });
        boutonDevant.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                listNode.get(0).toFront();
            }
        });

        HBox bouton = new HBox(10,boutonArriere,boutonArriere2,boutonDevant,boutonDevant2);
        bouton.setPadding(new Insets(10));
        Label labelGlobal = new Label("Calendrier 2025");
        VBox.setMargin(labelGlobal, new Insets(14));
        this.getChildren().addAll(labelGlobal,bouton, stackPaneMois);
    }
}