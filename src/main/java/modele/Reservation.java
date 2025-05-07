package modele;


import exception.ExceptionReservation;

public class Reservation implements Comparable<Reservation>{
    private String intitule;
    private Date date;
    private PlageHoraire plagehoraire;


    public String toString() {
        return intitule + "\n" + date.toString() + "\n" + plagehoraire.toString();
    }
    public Reservation(String parintitule, Date pardate, PlageHoraire parplagehoraire) throws ExceptionReservation{
        if (parintitule == null || parintitule.equals("")) {
            throw new ExceptionReservation(0);
        }
        intitule = parintitule;
        date = pardate;
        plagehoraire = parplagehoraire;
    }

    public Date getDate() {
        return date;
    }
    public String getIntitule() {return intitule;}
    public int getSemaine(){
        return this.getDate().getJour()/7 + (this.getDate().getMois()-1)*4 ;
    }

    public boolean estValide() {
        if (plagehoraire.estValide() && date.estValide()) {
            return true;
        }
        else{
            return false;
        }
    }

    public int compareTo(Reservation r) {
        if (date.compareTo(r.date) < 0 || (date.compareTo(r.date) == 0 && plagehoraire.compareTo(r.plagehoraire) < 0)) {
            return -1;
        }
        if (date.compareTo(r.date) > 0 || (date.compareTo(r.date) == 0 && plagehoraire.compareTo(r.plagehoraire) > 0)) {
            return 1;
        }
        return 0;
    }


}
