import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ATM {
    private List<Account> accounts; // Liste des comptes bancaires
    private List<String> transactionHistory; // Historique des opérations
    private String clientFirstName; // Prénom du client actuel

    public ATM() {
        accounts = new ArrayList<>();
        transactionHistory = new ArrayList<>();
        clientFirstName = null;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Création d'un nouveau compte bancaire");
        System.out.print("Numéro du compte : ");
        int accountNo = scanner.nextInt();

        for (Account account : accounts) {
            if (account.getAccountNo() == accountNo) {
                System.out.println("Erreur : Le compte existe déjà !");
                return;
            }
        }

        scanner.nextLine();

        System.out.print("Nom du client : ");
        String clientName = scanner.nextLine();
        System.out.print("Prénom du client : ");
        clientFirstName = scanner.nextLine();
        System.out.print("Adresse du client : ");
        String address = scanner.nextLine();
        System.out.print("Code postal du client : ");
        String postalCode = scanner.nextLine();
        System.out.print("Ville du client : ");
        String city = scanner.nextLine();

        ClientAccount clientAccount = new ClientAccount(clientName, clientFirstName, address, postalCode, city);
        Account newAccount = new Account(accountNo, clientAccount);
        accounts.add(newAccount);

        transactionHistory.add("Création du compte - Numéro du compte : " + accountNo);

        System.out.println("Compte créé avec succès !");
    }

    public void displayAccountInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numéro du compte : ");
        int accountNo = scanner.nextInt();

        Account account = findAccount(accountNo);
        if (account != null) {
            ClientAccount clientAccount = account.getClientAccount();
            System.out.println("\nInformations du compte bancaire :");
            System.out.println("Numéro du compte : " + accountNo);
            System.out.println("Client : " + clientAccount.getClientFirstName() + " " + clientAccount.getClientName());
            System.out.println("Adresse : " + clientAccount.getAddress());
            System.out.println("Code postal : " + clientAccount.getPostalCode());
            System.out.println("Ville : " + clientAccount.getCity());
            System.out.println("Solde : " + account.getBalance() + " €");
        } else {
            System.out.println("Compte non trouvé !");
        }
    }

    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numéro du compte : ");
        int accountNo = scanner.nextInt();

        Account account = findAccount(accountNo);
        if (account != null) {
            System.out.print("Montant du dépôt : ");
            double amount = scanner.nextDouble();

            account.deposit(amount);
            transactionHistory.add("Dépôt sur le compte " + accountNo + " : +" + amount + " €");

            System.out.println("Dépôt effectué avec succès !");
        } else {
            System.out.println("Compte non trouvé !");
        }
    }

    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numéro du compte : ");
        int accountNo = scanner.nextInt();

        Account account = findAccount(accountNo);
        if (account != null) {
            System.out.print("Montant du retrait : ");
            double amount = scanner.nextDouble();

            if (amount <= account.getBalance()) {
                account.withdraw(amount);
                transactionHistory.add("Retrait sur le compte " + accountNo + " : -" + amount + " €");

                System.out.println("Retrait effectué avec succès !");
            } else {
                System.out.println("Solde insuffisant !");
            }
        } else {
            System.out.println("Compte non trouvé !");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Historique des opérations :");
        for (String operation : transactionHistory) {
            System.out.println(operation);
        }
    }

    private Account findAccount(int accountNo) {
        for (Account account : accounts) {
            if (account.getAccountNo() == accountNo) {
                return account;
            }
        }
        return null;
    }
}
