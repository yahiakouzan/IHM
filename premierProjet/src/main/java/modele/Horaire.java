package modele;

public class Horaire {
    private int chHeure;
    private int chQuartHeure;

    public String toString() {
        return chHeure + "h" + chQuartHeure;
    }
    public Horaire(int parHeure, int parQuartHeure) {
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
    }

    public boolean estValide(){
        if (chHeure >= 0 && chHeure < 24 && chQuartHeure >= 0 && chQuartHeure <= 45 && chQuartHeure % 15 == 0) {
            return true;
        }
        return false;
    }

    public int compareTo(Horaire parHoraire) throws ExceptionHoraire {
        if ((parHoraire.chHeure > chHeure) || (parHoraire.chHeure == chHeure) && (parHoraire.chQuartHeure > chQuartHeure)){
            return -1;
        }
        if (parHoraire.chHeure == chHeure && parHoraire.chQuartHeure == chQuartHeure){
            return 0;
        }
        return 1;
    }

    public int toMinutes() {
        return chHeure * 60 + chQuartHeure;
    }

    public int getHeure() {
        return chHeure;
    }

    public int getQuartHeure() {
        return chQuartHeure;
    }

    public void setHeure(int parHeure) {
        chHeure = parHeure;
    }

    public void setQuartHeure(int parQuartHeure) {
        chQuartHeure = parQuartHeure;
    }




}
