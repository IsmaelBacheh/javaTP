package modele;

public class Reservation implements Comparable<Reservation>{
    private PlageHoraire chPlageHoraireReservation;
    private Date chDateReservation;
    private String chTitre;

    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parTitre){
        chPlageHoraireReservation = parPlageHoraire;
        chDateReservation = parDate;
        chTitre = parTitre;
    }

    public String toString(){
        return chTitre + " le : " + chDateReservation + " "+ chPlageHoraireReservation;
    }

    public int compareTo(Reservation parReservation){
        if (this.chDateReservation.compareTo(parReservation.chDateReservation)>0)
            return 1;
        else if (this.chDateReservation.compareTo(parReservation.chDateReservation)<0){
            return -1;
        }
        else{
            if (this.chPlageHoraireReservation.compareTo(parReservation.chPlageHoraireReservation)>0) {
                return 1;
            }
            else if (this.chPlageHoraireReservation.compareTo(parReservation.chPlageHoraireReservation)<0){
                return -1;
            }
            return 0;
        }
    }
    public Date getDate(){
        return chDateReservation;
    }

    public boolean estValide(){
        return chDateReservation.estValide() && chPlageHoraireReservation.estValide();
    }
}
