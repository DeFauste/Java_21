package ex04;

public class TransactionsService {
    private final UsersArrayList usersArrayList = new UsersArrayList();
    private final TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();
    public void addUser(String name, int balance) {
        User newUser = new User(name);
        newUser.setBalance(balance);
        usersArrayList.addUser(newUser);
    }

    public int getUserBalanceByID(int userID) {
        int balance = 0;
        try {
            balance =  usersArrayList.getById(userID).getBalance();
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
        return balance;
    }

    public void addTransaction(int senderID, int recipientID, int amount) {
        Transaction senderTr = new Transaction()
    }
}
