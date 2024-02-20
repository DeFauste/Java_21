package ex00;

import java.util.UUID;

public class User {
    public User(String name) {
        Name = name;
    }

    private UUID Identifier;

    public UUID getIdentifier() {
        return Identifier;
    }

    private String Name;

    public String getName() {
        return Name;
    }

    private Integer Balance = 0;

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        if (balance < 0)
            System.err.println("Balance cannot be negative!");
        else Balance = balance;
    }
}
