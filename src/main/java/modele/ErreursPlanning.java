package modele;

public enum ErreursPlanning {

        RESERVATION_NON_VALIDE, RESERVATION_INCOMPATIBLE;
        public String toString() {
            switch (this) {
                case RESERVATION_NON_VALIDE: return "Reservation non valide";
                case RESERVATION_INCOMPATIBLE: return "Reservation incompatible";
                default : return "Réservation déja existante";
            }
        }
    }
