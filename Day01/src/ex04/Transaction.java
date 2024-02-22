package ex04;

import java.util.UUID;

public class Transaction {

    public Transaction(User recipient, User sender, TransferCategory category, Integer amount) {
        id = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        transferCategory = category;
        transferAmount = category == TransferCategory.CREDITS ? amount : -amount;
    }

    public enum TransferCategory {
        DEBITS,
        CREDITS
    }

    private UUID id;
    public void setUUID(UUID id) {
        this.id = id;
    }

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

    private TransferCategory transferCategory;

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    private Integer transferAmount;

    public Integer getTransferAmount() {
        return transferAmount;
    }
}
