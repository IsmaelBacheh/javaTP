package modele;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;

public class PlanningCollections {
    ArrayList <Reservation> reservationsArrayList;
    TreeSet<Reservation> reservationTreeSet;
    TreeMap<Integer,TreeSet<Reservation>> treeMap;

    public PlanningCollections() {
        this.reservationsArrayList = new ArrayList();
        this.reservationTreeSet = new TreeSet<>();
        this.treeMap = new TreeMap<>();
    }
    public void ajout(Reservation res) throws ExceptionPlanning {

        if(!res.estValide()){
            throw new ExceptionPlanning(ErreursPlanning.RESERVATION_NON_VALIDE);
        }
        for (Reservation reservation : reservationsArrayList){
            if(res.compareTo(reservation) == 0){
                throw new ExceptionPlanning(ErreursPlanning.RESERVATION_INCOMPATIBLE);
            }
        }

        reservationsArrayList.add(res);
        reservationTreeSet.add(res);

        int numSemaine = ((DateCalendrier)res.getDate()).getWeekOfYear();
        if (treeMap.containsKey(numSemaine)){
            treeMap.get(numSemaine).add(res);
        }
        else{
            TreeSet <Reservation> arbre = new TreeSet<> ();
            arbre.add(res);
            treeMap.put(numSemaine,arbre);
        }

    }

    public String toString(){
        return reservationsArrayList.size() + " " + reservationsArrayList + "\n" +
                reservationTreeSet.size() + " " + reservationTreeSet + "\n" +
                treeMap.size() + " " + treeMap + "\n";
    }
}
