package modele;

import java.util.Calendar;

public class Date implements Comparable<Date>{
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date() {
        Calendar today = Calendar.getInstance();
        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH) + 1;
        chJour  = today.get(Calendar.DAY_OF_MONTH);
    }

    public String toString() {
        return chJour + "/" + chMois + "/" + chAnnee;
    }
    public Date(int jour, int mois, int annee) {
        chJour = jour;
        chMois = mois;
        chAnnee = annee;
    }
    public Date(int annee) {
        chAnnee = annee;
        chJour = 1;
        chMois = 1;
    }
    public static int dernierJourMois(int parMois,int parAnnee){
        switch(parMois){
            case 2: if(estBissextile(parAnnee))
                    return 29;
            return 28;
            case 4: case 6 : case 8:
                            return 30;
            default: return 31;
        }
    }
    public static boolean estBissextile(int parAnnee){
        if (parAnnee%400 == 0 || (parAnnee%4 == 0 && parAnnee%100 != 0))
            return true;
        return false;

    }
    public boolean estValide() {
        if (chAnnee < 1583)
            return false;
        if (chMois < 1 || chMois > 12)
            return false;
        if (chJour < 1 || chJour > dernierJourMois(chMois,chAnnee))
            return false;
        return true;
    }
    public int compareTo(Date parDate) {
        if (chAnnee < parDate.chAnnee || (chMois < parDate.chMois && chAnnee == parDate.chAnnee) || (chJour < parDate.chJour && chMois == parDate.chMois && chAnnee == parDate.chAnnee)){
            return -1;
        }
        if (chJour == parDate.chJour && chMois == parDate.chMois && chAnnee == parDate.chAnnee){
            return 0;
        }
        return 1;
    }

    /**
     * Prend une date et retourne la date du lendemain de celle-ci
     * @return Date datelendemain, la date du lendemain
     */
    public Date dateDuLendemain(){
        if (chJour == dernierJourMois(chMois,chAnnee)){
            if (chMois == 12) {
                return new Date(chAnnee + 1);
            }
            return new Date(1,chMois + 1,chAnnee);
        }
        return new Date(chJour + 1,chMois,chAnnee);
    }

    /**
     * Prend une date et retourne la date de la veille de celle-ci
     * @return Date dateveille, la date de la veille
     */
    public Date dateDeLaVeille(){
        if (chJour == 1){
            if (chMois == 1){
                return new Date(31,12,chAnnee - 1);
            }
            return new Date(dernierJourMois(chMois-1,chAnnee),chMois - 1,chAnnee);
        }
        return new Date(chJour - 1,chMois,chAnnee);
    }

    public int getJour(){
        return chJour;
    }

    public int getAnnee(){
        return chAnnee;
    }

    public int getMois() { return chMois; }
}