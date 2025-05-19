package vue;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.Date;
import modele.PlanningCollections;

public class Controleur implements EventHandler{


    @Override
            public void handle(Event event) {

        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        if (event.getSource() instanceof ToggleButton){
            ToggleButton bouton = (ToggleButton) event.getSource();
            Object data = bouton.getUserData();

            if (data instanceof Date) {
                Date date = (Date) data;
                System.out.println("Jour sélectionné : " + date.getJour());
                reservationPane.setDateSelectionnee(date);
            }

        }
        if (event.getSource() instanceof Button){

        }

    }
}
