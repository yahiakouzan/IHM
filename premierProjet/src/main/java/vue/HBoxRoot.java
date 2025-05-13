package vue;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.PlanningCollections;


public class HBoxRoot extends HBox  {
    private static PlanningCollections planning;
    private static VBoxCalendrier vBox;
    private static GridPane grid;
    public HBoxRoot() {

        VBoxCalendrier vboxCalendrier = new VBoxCalendrier();
        GridPaneFormulaireReservation formulaire = new GridPaneFormulaireReservation();
        this.getChildren().add(vboxCalendrier);
        this.getChildren().add(formulaire);


    }


}
