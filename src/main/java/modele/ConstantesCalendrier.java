package modele;

public class ConstantesCalendrier {

    public enum Jours {
        LUNDI ,
        MARDI ,
        MERCREDI ,
        JEUDI ,
        VENDREDI ,
        SAMEDI,
        DIMANCHE;

        public String toString() {
            switch (this) {
                case LUNDI : return "lundi";
                case MARDI:  return "mardi";
                case MERCREDI:  return "mercredi";
                case JEUDI:  return "jeudi";
                case VENDREDI:  return "vendredi";
                case SAMEDI:  return "samedi";
                default : return "dimanche";
            }
        }
    }

    public enum Mois {
        JANVIER ("janvier"),
        FEVRIER ("février"),
        MARS ("mars"),
        AVRIL ("avril"),
        MAI ("mai"),
        JUIN ("juin"),
        JUILLET ("juillet"),
        AOUT ("août"),
        SEPTEMBRE ("septembre"),
        OCTOBRE ("octobre"),
        NOVEMBRE ("novembre"),
        DECEMBRE ("décembre");

        private final String mois ;

        private Mois (String mois) {
            this.mois = mois;
        }

        public String toString() {
            return mois;
        }
    }







}
