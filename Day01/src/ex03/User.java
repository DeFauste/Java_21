package ex03;

import java.util.UUID;

public class User {

    TransactionsLinkedList transactions = new TransactionsLinkedList();

    public User(String name) {
        this.name = name;
    }

    private UUID id;

    public UUID getId() {
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    private Integer balance = 0;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        if (balance < 0)
            System.err.println("Balance cannot be negative!");
        else this.balance = balance;
    }
}
