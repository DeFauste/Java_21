package ex04;

public class Program {

    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();
        User user1 = new User("John", 5000);
        User user2 = new User("Ohn", 1000);
        User user3 = new User("Pokn", 100);
        User user4 = new User("Alohn", 0);
        service.addUser(user1);
        service.addUser(user2);
        service.addUser(user3);
        service.addUser(user4);

        System.out.println("Get balance:");
        int balance = service.getUserBalanceByID(user1.getId());
        System.out.printf("%s -- %d\n", user1.getName(), balance);

        balance = service.getUserBalanceByID(user2.getId());
        System.out.printf("%s -- %d\n", user2.getName(), balance);

        service.addTransaction(user1.getId(), user2.getId(), 200);
        service.addTransaction(user1.getId(), user3.getId(), 200);
        System.out.println("Transaction balance exception:");
        try {
            service.addTransaction(user4.getId(), user3.getId(), 200);
        } catch (Exception e) {
            System.out.println(e);
        }

        balance = service.getUserBalanceByID(user1.getId());
        System.out.printf("%s -- %d\n", user1.getName(), balance);
        balance = service.getUserBalanceByID(user2.getId());
        System.out.printf("%s -- %d\n", user2.getName(), balance);

        System.out.println("All sender transaction John:");
        Transaction[] transactions = service.getUserTransfers(user1.getId());
        for (int i = 0; i < transactions.length; ++i) {
            System.out.printf("%s -> %d -> %s\n", transactions[i].getSender().getName(), transactions[i].getTransferAmount(), transactions[i].getRecipient().getName());
        }
        System.out.println("Remove transaction John -> Ohn:");
        service.removeTransaction(user1.getId(), transactions[0].getUUID());

        transactions = service.getUserTransfers(user1.getId());
        for (int i = 0; i < transactions.length; ++i) {
            System.out.printf("%s -> %d -> %s\n", transactions[i].getSender().getName(), transactions[i].getTransferAmount(), transactions[i].getRecipient().getName());
        }

        System.out.println("All sender transaction Ohn:");
        try {
            transactions = service.getUserTransfers(user2.getId());
            for (int i = 0; i < transactions.length; ++i) {
                System.out.printf("%s -> %d -> %s\n", transactions[i].getSender().getName(), transactions[i].getTransferAmount(), transactions[i].getRecipient().getName());
            }
            System.out.println("Empty");
        } catch (Exception e) {
            System.out.println(e);
        }

        Transaction[] unpairTransactions = service.getUnpairedTransactions();
        for (int i = 0; i < unpairTransactions.length; ++i) {
            System.out.printf("UUID: %s - Sender: %s - Recipient: %s - Amount: %d - Category: %s", unpairTransactions[i].getUUID(), unpairTransactions[i].getSender().getName(), unpairTransactions[i].getRecipient().getName(), unpairTransactions[i].getTransferAmount(), unpairTransactions[i].getTransferCategory());
        }
    }

}
