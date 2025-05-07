package vue;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.PlanningCollections;

public class HBoxRoot extends HBox {
    private static PlanningCollections hPlanning ;
    private static Controleur controleur;
    private static VBoxRoot calendrierPane = new VBoxRoot();
    private static GridPaneFormulaireReservation reservationPane = new GridPaneFormulaireReservation();


    public HBoxRoot() {
        this.getChildren().add(calendrierPane);
        this.getChildren().add(reservationPane);

    }

    public static PlanningCollections getPlanning() {
        return hPlanning;
    }

    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

    public static Controleur getControleur() {
        return controleur;
    }

    public static VBoxRoot getCalendrierPane() {
        return calendrierPane;
    }

}
