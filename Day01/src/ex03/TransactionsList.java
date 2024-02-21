package ex03;

import java.util.Iterator;
import java.util.UUID;

public interface TransactionsList {
    int add(Transaction item);

    void remove(UUID uuid);

    Transaction[] toArray();
}
