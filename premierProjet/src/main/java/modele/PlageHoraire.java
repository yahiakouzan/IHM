package modele;

public class PlageHoraire {
    private Horaire debut;
    private Horaire fin;
    private static final int duree_minimale = 15;

    public PlageHoraire(Horaire horaire_debut, Horaire horaire_fin) throws ExceptionHoraire{
        if (horaire_debut.compareTo(horaire_fin) == 0) {
            throw new ExceptionHoraire(0);
        }
        debut = horaire_debut;
        fin = horaire_fin;
    }

    public boolean estValide() {
        if (debut.estValide() && fin.estValide() && debut.compareTo(fin) < 0) {
            return true;
        }
        return false;
    }

    public int duree(){
        return (fin.toMinutes() - debut.toMinutes());
    }

    public int compareTo(PlageHoraire par_plageHoraire) {
        if (debut.compareTo(par_plageHoraire.debut) < 0 && fin.compareTo(par_plageHoraire.debut) < 0) {
            return -1;
        }
        if (debut.compareTo(par_plageHoraire.debut) > 0 && fin.compareTo(par_plageHoraire.debut) > 0) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        int minutes = this.duree() % 60;
        int heures = this.duree() / 60;
        return debut + " - " + fin + ", durée : " + heures + "h" + minutes;
    }


}
