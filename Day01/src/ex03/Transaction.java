package ex03;

import java.util.UUID;

public class Transaction {

    public Transaction(User recipient, User sender, Transaction.TransferCategory category, Integer amount) {
        id = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        transferCategory = category;
        transferAmount = category == Transaction.TransferCategory.CREDITS ? amount : -amount;
    }

    public enum TransferCategory {
        DEBITS,
        CREDITS
    }

    private UUID id;

    public UUID getId() {
        return id;
    }

    private User recipient;

    public User getRecipient() {
        return recipient;
    }

    private User sender;

    public User getSender() {
        return sender;
    }

    private Transaction.TransferCategory transferCategory;

    public Transaction.TransferCategory getTransferCategory() {
        return transferCategory;
    }

    private Integer transferAmount;

    public Integer getTransferAmount() {
        return transferAmount;
    }
}
