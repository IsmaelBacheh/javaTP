package modele;

public class PlageHoraire {
    private static final int duree_min = 60;
    private Horaire chHoraireDebut;
    private Horaire chHoraireFin;

    public PlageHoraire(Horaire horaireDebut, Horaire horaireFin){
        chHoraireDebut = horaireDebut;
        chHoraireFin = horaireFin;
    }

    public static boolean estValide(PlageHoraire plageHoraire){
        return plageHoraire.chHoraireFin.toMinutes() - plageHoraire.chHoraireDebut.toMinutes() >= duree_min ;
    }
    public boolean estValide(){
        return this.chHoraireFin.toMinutes() - this.chHoraireDebut.toMinutes() >= duree_min ;
    }
    public int duree (){
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() ;
    }

    public int compareTo(PlageHoraire parPlageHoraire){
        if (this.chHoraireDebut.toMinutes() < parPlageHoraire.chHoraireDebut.toMinutes()){
            return -1;
        }
        if (this.chHoraireDebut.toMinutes() > parPlageHoraire.chHoraireDebut.toMinutes()){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return "Début: " + chHoraireDebut + " fin: " + chHoraireFin +" durée : "+ duree_min + "mn";

    }
}
