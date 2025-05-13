package modele;

public class Planning {
    private Reservation[] reservations;
    private final int taille;

    public String toString() {
        String mess = "";
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null) {
                mess = mess + reservations[i].toString() + "\n" + "\n";
            }
        }
        return mess;
    }

    public Planning(int taille_tableau) {
        taille = taille_tableau;
        reservations = new Reservation[taille];
    }

    public void ajout(Reservation reservation) throws ExceptionPlanning{
        if (reservations[taille-1]!= null) {
            throw new ExceptionPlanning(1);
        }

        if (!reservation.estValide()) {
            throw new ExceptionPlanning(0);
        }


        for (int i = 0; i < taille; i++) {
            if (reservations[i] != null && reservations[i].compareTo(reservation) == 0) {
                reservations[i] = reservation;
                throw new ExceptionPlanning(2);
            }
            if (reservations[i] == null){
                reservations[i] = reservation;
                break;
            }
        }
    }

    public Reservation getReservation(Date parDate) {
        for (int i = 0; i < taille; i++) {
            if (reservations[i] == null) {
                return null;
            }
            if (reservations[i].getDate().compareTo(parDate) == 0) {
                return reservations[i];
            }
        }
        return null;
    }

    public Reservation[] getReservations(Date parDate) {
        Reservation[] reservationDate = new Reservation[taille];
        for (int i = 0; i < taille; i++) {
            if (reservations[i] != null) {
                if (reservations[i].getDate().compareTo(parDate) == 0) {
                    reservationDate[i] = reservations[i];
                }
            }
        }
        return reservationDate;
    }
    public int plusAncienneReservation(int parDebut, int parFin) {
        int plusAncienne = parDebut;
        for (int i = parDebut + 1; i <= parFin; i++) {
            if (reservations[i] != null) {
                if (reservations[i].getDate().compareTo(reservations[plusAncienne].getDate()) < 0) {
                    plusAncienne = i;
                }
            }
        }
        return plusAncienne;
    }



}