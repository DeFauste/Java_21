package ex04;

import java.util.UUID;

public interface TransactionsList {
    int add(Transaction item);

    void remove(UUID uuid);

    Transaction[] toArray();
}
