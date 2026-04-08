package modele;

public class ExceptionPlanning extends Exception {
    private final ErreursPlanning chErreursPlanning;

    public ExceptionPlanning(ErreursPlanning parEP) {
        chErreursPlanning=parEP;
    }

    public ErreursPlanning getErreursPlanning(){
        return chErreursPlanning;
    }

    public boolean getTypeErreur() {
        return true;
    }
}