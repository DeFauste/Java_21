package ex03;

import ex00.Transaction;

import java.util.UUID;

public interface TransactionsList {
    int add();
    Transaction remove(UUID uuid);
    Transaction[] toArray();
}
