package modele;

import java.util.*;

import exception.*;

public class PlanningCollections {
    private ArrayList<Reservation> chArrayList;
    private TreeSet<Reservation> chTreeSet;
    private TreeMap<Integer, List<Reservation>> chTreeMap = new TreeMap<>();

    public PlanningCollections() {
        chArrayList = new ArrayList<>();
        chTreeSet = new TreeSet<>();
    }


    public void ajout(Reservation parRes) throws ExceptionReservation {
        /** La methode ajout prends en parametre un objet parRes pour l ajouter a l'objet appelant this **/
        if (!parRes.estValide()) {
            throw new ExceptionReservation(0);
        }

        Iterator<Reservation> itr = chTreeSet.iterator();
        while (itr.hasNext()) {
            Reservation res = itr.next();
            if (res.compareTo(parRes) == 0) {
                throw new ExceptionReservation(2);
            }
        }
        chTreeSet.add(parRes);

        for (int i = 0; i < chArrayList.size(); i++) {
            Reservation res = chArrayList.get(i);
            if (res.compareTo(parRes) == 0) {
                throw new ExceptionReservation(2);
            }

        }

        chArrayList.add(parRes);

        int semaine = parRes.getSemaine();
        chTreeMap.put(semaine, new ArrayList<>());
    }

    public TreeSet<Reservation> getReservations(Date parDate) {
        TreeSet treeRes = new TreeSet<>() ;
        Iterator<Reservation> itr = chTreeSet.iterator();
        while (itr.hasNext()) {
            Reservation res = itr.next();
            if (parDate.compareTo(res.getDate()) == 0) {
                treeRes.add(res);
            }
        }
        return treeRes;
    }

    public TreeSet<Reservation> getReservations(String parTitre) {
        TreeSet treeRes = new TreeSet<>() ;
        Iterator<Reservation> itr = chTreeSet.iterator();
        while (itr.hasNext()) {
            Reservation res = itr.next();
            if (parTitre.equals(res.getIntitule())) {
                treeRes.add(res);
            }
        }
        return treeRes;
    }


    public String toString() {
        return chArrayList.toString() + " " + chArrayList.size() + " " + chTreeSet.toString() + " taille treemap : " + chTreeMap.size() + " " + chTreeMap.toString();
    }
}
