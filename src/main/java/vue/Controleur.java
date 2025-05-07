package vue;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.PlanningCollections;

public class Controleur implements EventHandler{


    @Override
            public void handle(Event event) {

        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        if (event.getSource() instanceof ToggleButton){

        }
        if (event.getSource() instanceof Button){

        }

    }
}
