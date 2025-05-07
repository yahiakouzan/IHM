package modele;

public class ClientCalendrierDuMois {
    public static void main(String[] args) {
        CalendrierDuMois c1 = new CalendrierDuMois(1,2024);
        System.out.println(c1);
        System.out.println(c1.getMois());
        System.out.println(c1.getAnnee());
        System.out.println(c1.getDates());

    }
}
