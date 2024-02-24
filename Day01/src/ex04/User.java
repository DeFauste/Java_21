package ex04;

import ex02.UserIdsGenerator;

public class User {

    TransactionsLinkedList transactions = new TransactionsLinkedList();

    public User(String name) {
        id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
    }
    public User(String name, int balance) {
        this(name);
        this.balance = balance;
    }

    private int id;

    public int getId() {
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
