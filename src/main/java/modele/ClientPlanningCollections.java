package client;

import modele.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
// Importations de ton modèle (à ajuster selon ton projet)
// import modele.*;

public class ClientPlanningCollections {

    public static void main(String[] args) {

        PlanningCollections planning = new PlanningCollections();

        // Utilisation du try-with-resources pour fermer automatiquement le scanner
        try (Scanner scanner = new Scanner(new File("data" + File.separator + "planning.txt"))) {

            scanner.useDelimiter(",");

            // trim() ôte le retour à la ligne au début de l'intitulé
            while (scanner.hasNext()) {
                String intitule = scanner.next().trim();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();
                int heureD = scanner.nextInt();
                int quartHeureD = scanner.nextInt();
                int heureF = scanner.nextInt();
                int quartHeureF = scanner.nextInt();

                try {
                    planning.ajout(new Reservation(
                            new DateCalendrier(jour, mois, annee),
                            new PlageHoraire(
                                    new Horaire(heureD, quartHeureD),
                                    new Horaire(heureF, quartHeureF)
                            ),
                            intitule
                    ));
                } catch (ExceptionPlanning e) {
                    System.out.println(e.getTypeErreur());
                }
            } // Fin du while

        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé.");
        } catch (InputMismatchException e) {
            System.out.println("Entier attendu (problème de format dans le fichier).");
        } catch (NoSuchElementException e) {
            System.out.println("Scanner épuisé.");
        } catch (IllegalStateException e) {
            System.out.println("Scanner fermé.");
        }

        // Affichage du planning
        System.out.println(planning.toString());
    }
}