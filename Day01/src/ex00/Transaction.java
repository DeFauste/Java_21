package ex00;

import java.util.UUID;

public class Transaction {

    public Transaction(User recipient, User sender, TransferCategory category, Integer amount) {
        Recipient = recipient;
        Sender = sender;
        transferCategory = category;
        transferAmount = category == TransferCategory.CREDITS ? amount : -amount;
    }

    public enum TransferCategory {
        DEBITS,
        CREDITS
    }

    private UUID Identifier;

    public UUID getIdentifier() {
        return Identifier;
    }

    private User Recipient;

    public User getRecipient() {
        return Recipient;
    }

    private User Sender;

    public User getSender() {
        return Sender;
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
