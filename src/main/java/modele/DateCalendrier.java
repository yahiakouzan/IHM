package modele;

import java.util.Calendar;


public class DateCalendrier extends Date implements Comparable<Date>, ConstantesCalendrier{
    private int chJourSemaine;

    public DateCalendrier(){
        Calendar today = Calendar.getInstance();
        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH) + 1;
        chJour  = today.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek = 8;
        }
        chJourSemaine = dayOfWeek - 1;
    }

    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour, parMois, parAnnee);
        Calendar jours = Calendar.getInstance();
        jours.set(parAnnee,parMois-1,parJour);
        chJourSemaine = jours.get(Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1) {
            chJourSemaine = 8;
        }
        chJourSemaine --;
    }

    public DateCalendrier dateDuLendemain() {
        Date lendemain = super.dateDuLendemain();
        return new DateCalendrier(lendemain.chJour, lendemain.chMois, lendemain.chAnnee);
    }

    public DateCalendrier dateDeLaVeille() {
        Date veille = super.dateDeLaVeille();
        return new DateCalendrier(veille.chJour, veille.chMois, veille.chAnnee);
    }
    public String toString() {
        return JOURS_SEMAINE[chJourSemaine-1] + " " + chJour + " " + MOIS[chMois-1] + " " + chAnnee;
    }

    public int getMois(){return chMois;}

    public int getJourSemaine(){return chJourSemaine;}
}
