package ex05;


import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private int sizeList = 0;
    private Node head = null;
    private Node tail = null;

    private int countDebit = 0;
    private int countCredit = 0;

    public int getCountDebit() {
        return countDebit;
    }

    public int getCountCredit() {
        return countCredit;
    }

    @Override
    public int add(Transaction item) {
        Node currentNode = new Node(item);
        if (currentNode.item.getTransferCategory() == Transaction.TransferCategory.DEBITS) {
            countDebit++;
        } else {
            countCredit++;
        }
        if (head == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            tail.next = currentNode;
            currentNode.prev = tail;
            tail = currentNode;
        }
        sizeList++;
        return 1;
    }

    @Override
    public void remove(UUID uuid) {
        Node iter = head;
        Node remove = null;
        for (int i = 0; i < sizeList; i++) {
            if (iter.item.getUUID().compareTo(uuid) == 0) {
                if (iter.item.getTransferCategory() == Transaction.TransferCategory.DEBITS) {
                    countDebit--;
                } else {
                    countCredit--;
                }
                remove = iter;
                if (remove.prev == null && remove.next == null) {
                    tail = null;
                    head = null;
                } else if (remove.prev == null) {
                    head = remove.next;
                } else if (remove.next == null) {
                    tail = remove.prev;
                }
                sizeList--;
                break;
            } else {
                iter = iter.next;
            }
        }
        if (remove == null) {
            throw new TransactionNotFoundException("Transaction with ID: " + uuid + "non-existent");
        }
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] array = new Transaction[sizeList];
        Node iter = head;
        for (int i = 0; i < sizeList; ++i) {
            array[i] = iter.item;
            iter = iter.next;
        }
        return array;
    }

    private class Node {
        Transaction item;
        Node next = null;
        Node prev = null;

        public Node(Transaction item) {
            this.item = item;
        }
    }
}
