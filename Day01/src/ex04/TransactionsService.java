package ex04;

import java.util.UUID;

public class TransactionsService {
    private final UsersArrayList usersArrayList = new UsersArrayList();

    public void addUser(String name, int balance) {
        User newUser = new User(name);
        newUser.setBalance(balance);
        usersArrayList.addUser(newUser);
    }
    public void addUser(User user) {
        usersArrayList.addUser(user);
    }

    public int getUserBalanceByID(int userID) {
        int balance = 0;
        try {
            balance = usersArrayList.getById(userID).getBalance();
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
        return balance;
    }

    public void addTransaction(int senderID, int recipientID, int amount) {
        User userSender = usersArrayList.getById(senderID);
        User userRecipient = usersArrayList.getById(recipientID);
        if (userSender.getBalance() < amount) {
            throw new IllegalTransactionException();
        }
        Transaction senderTr = new Transaction(userSender, userRecipient, Transaction.TransferCategory.DEBITS, amount);
        Transaction recipientTr = new Transaction(userSender, userRecipient, Transaction.TransferCategory.CREDITS, amount);
        recipientTr.setUUID(senderTr.getUUID());
        userSender.transactions.add(senderTr);
        userRecipient.transactions.add(recipientTr);

        userSender.setBalance(userSender.getBalance() - amount);
        userRecipient.setBalance(userRecipient.getBalance() + amount);
    }

    public void removeTransaction(int userID, UUID transfersUUID) {
        User user = usersArrayList.getById(userID);
        user.transactions.remove(transfersUUID);
    }

    public Transaction[] getUserTransfers(int userID) {
        User user = usersArrayList.getById(userID);
        int countSend = user.transactions.getCountDebit();
        Transaction[] allTransaction = user.transactions.toArray();
        Transaction[] sendTransact = new Transaction[countSend];
        for (int i = 0, j = 0; i < allTransaction.length; ++i) {
            if (allTransaction[i].getTransferCategory() == Transaction.TransferCategory.DEBITS) {
                sendTransact[j++] = allTransaction[i];
            }
        }
        return sendTransact;
    }

    public Transaction[] getUnpairedTransactions() {
        TransactionsLinkedList unpairTrans = new TransactionsLinkedList();
        int countUser = usersArrayList.getCountUser();
        User user = null;
        Transaction[] tranUser = null;
        for (int i = 0; i < countUser; ++i) {
            user = usersArrayList.getByIndex(i);
            tranUser = user.transactions.toArray();
            for (int u = 0; u < tranUser.length; ++u) {
                try {
                    unpairTrans.remove(tranUser[u].getUUID());
                } catch (TransactionNotFoundException e) {
                    unpairTrans.add(tranUser[u]);
                }
            }
        }
        return unpairTrans.toArray();
    }
}
