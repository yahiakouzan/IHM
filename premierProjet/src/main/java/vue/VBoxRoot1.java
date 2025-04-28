package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import modele.CalendrierDuMois;
import modele.Date;
import modele.DateCalendrier;

import static modele.ConstantesCalendrier.JOURS_SEMAINE;
import static modele.ConstantesCalendrier.MOIS;
/*
public class VBoxRoot1 {
    Date today = new Date();
    StackPane stackPaneMois = new StackPane();
    ToggleGroup buttonGroup = new ToggleGroup();
    for (int numMois = 1; numMois<=12 ; numMois++){
        CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois, today.getAnnee());
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(7);
        tilePane.setPrefRows(monthCalendar.getDates().size() % 7 + 1);
        tilePane.setId("opaque");
        for (String jourAb : JOURS_SEMAINE) {
            Label labelJour = new Label(jourAb);
            tilePane.getChildren().add(labelJour);
        }
        for (DateCalendrier date : monthCalendar.getDates()) {
            ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));
            boutonDate.setToggleGroup(buttonGroup);
            tilePane.getChildren().add(boutonDate);
            boutonDate.setUserData(date);
            boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    System.out.println("bouton next");
                }
            });
            if (date.getMois() != monthCalendar.getMois()) {
                boutonDate.setId("dateHorsMois");
            }
            if (date.isToday()) {
                boutonDate.setId("today");
            }
        }
        tilePane.setAccessibleText(MOIS[numMois - 1]);
        stackPaneMois.getChildren().add(tilePane);
    }
}
*/

