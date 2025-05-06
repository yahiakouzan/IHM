package vue;
import javafx.scene.layout.HBox;



public class HBoxRoot extends HBox  {

    private static 

    public HBoxRoot() {

        VBoxCalendrier vboxCalendrier = new VBoxCalendrier();
        GridPaneFormulaireReservation formulaire = new GridPaneFormulaireReservation();
        this.getChildren().add(vboxCalendrier);
        this.getChildren().add(formulaire);


    }


}
