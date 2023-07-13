import java.util.ArrayList;
import java.util.List;

class Account {
    private int accountNo; // Numéro du compte
    private double balance; // Solde du compte
    private List<String> transactionHistory; // Historique des transactions
    private ClientAccount clientAccount; // Informations sur le client associé au compte

    public Account(int accountNo, ClientAccount clientAccount) {
        this.accountNo = accountNo;
        this.clientAccount = clientAccount;
        balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Dépôt : +" + amount + " €");
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactionHistory.add("Retrait : -" + amount + " €");
    }
}

class ClientAccount {
    private String clientName; // Nom du client
    private String clientFirstName; // Prénom du client
    private String address; // Adresse du client
    private String postalCode; // Code postal du client
    private String city; // Ville du client

    public ClientAccount(String clientName, String clientFirstName, String address, String postalCode, String city) {
        this.clientName = clientName;
        this.clientFirstName = clientFirstName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
