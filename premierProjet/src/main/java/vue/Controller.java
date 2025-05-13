package vue;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.PlanningCollections;

public class Controller {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationane = HBoxRoot.getReservationPane();
        if (event.getSource() instanceof ToggleButton) ;
        {

        }


        if (event.getSource() instanceof Button) {


        }
    }
}