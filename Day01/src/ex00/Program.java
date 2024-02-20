package ex00;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("John");
        user1.setBalance(1000);
        System.out.printf("ID:%s User:%s , Balance: %d\n", user1.getIdentifier(), user1.getName(), user1.getBalance());
        User user2 = new User("Nohn");
        user2.setBalance(500);
        System.out.printf("ID:%s User:%s , Balance: %d\n", user2.getIdentifier(), user2.getName(), user2.getBalance());
        Transaction transactionDebit = new Transaction(user1, user2, Transaction.TransferCategory.DEBITS, 500);
        System.out.printf("Recipient: %s , Sender: %s , Transfer: %s , Amount: %d\n", transactionDebit.getRecipient().getName(),
                transactionDebit.getSender().getName(),
                transactionDebit.getTransferCategory(),
                transactionDebit.getTransferAmount());
        Transaction transactionCredit = new Transaction(user1, user2, Transaction.TransferCategory.CREDITS, 500);
        System.out.printf("Recipient: %s , Sender: %s , Transfer: %s , Amount: %d\n", transactionCredit.getRecipient().getName(),
                transactionCredit.getSender().getName(),
                transactionCredit.getTransferCategory(),
                transactionCredit.getTransferAmount());

    }
}
