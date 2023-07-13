import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        boolean exit = false;

        while (!exit) {
            System.out.println("=== ATM Menu ===");
            String firstName = atm.getClientFirstName();
            if (firstName != null) {
                System.out.println("Bonjour " + firstName + " !");
            }
            System.out.println("1. Créer un compte"); // Option pour créer un compte
            System.out.println("2. Afficher les informations du compte"); // Option pour afficher les informations d'un compte
            System.out.println("3. Déposer de l'argent"); // Option pour déposer de l'argent
            System.out.println("4. Retirer de l'argent"); // Option pour retirer de l'argent
            System.out.println("5. Afficher l'historique des opérations"); // Option pour afficher l'historique des opérations
            System.out.println("6. Quitter"); // Option pour quitter l'application
            System.out.print("Saisissez votre choix : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.createAccount(); // Appeler la méthode pour créer un compte
                    break;
                case 2:
                    atm.displayAccountInfo(); // Appeler la méthode pour afficher les informations d'un compte
                    break;
                case 3:
                    atm.depositMoney(); // Appeler la méthode pour déposer de l'argent
                    break;
                case 4:
                    atm.withdrawMoney(); // Appeler la méthode pour retirer de l'argent
                    break;
                case 5:
                    atm.displayTransactionHistory(); // Appeler la méthode pour afficher l'historique des opérations
                    break;
                case 6:
                    exit = true; // Sortir de la boucle pour quitter l'application
                    System.out.println("Merci d'avoir utilisé notre ATM !");
                    break;
                default:
                    System.out.println("Choix invalide !"); // Afficher un message en cas de choix invalide
            }

            System.out.println();
        }
    }
}
