package ex03;

import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("John_1");
        User user2 = new User("John_2");
        User user3 = new User("John_3");

        Transaction transaction1 = new Transaction(user1, user2, Transaction.TransferCategory.DEBITS, 200);
        Transaction transaction2 = new Transaction(user2, user3, Transaction.TransferCategory.CREDITS, 300);
        Transaction transaction3 = new Transaction(user3, user1, Transaction.TransferCategory.DEBITS, 400);
        Transaction transaction4 = new Transaction(user3, user2, Transaction.TransferCategory.CREDITS, 500);

        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();
        transactionsLinkedList.add(transaction1);
        transactionsLinkedList.add(transaction2);
        transactionsLinkedList.add(transaction3);

        System.out.println("Output array transaction:");
        Transaction[] arrayTr = transactionsLinkedList.toArray();
        for (Transaction i: arrayTr) {
            System.out.println(i.getRecipient().getName());
        }

        try {
            System.out.println("Delete transaction 1");
            transactionsLinkedList.remove(transaction1.getId());
        } catch (TransactionNotFoundException e) {
            System.out.println(e);
        }        arrayTr = transactionsLinkedList.toArray();
        System.out.println("Output new array transaction:");
        for (Transaction i: arrayTr) {
            System.out.println(i.getRecipient().getName());
        }

        try {
            System.out.println("Delete transaction 3");
            transactionsLinkedList.remove(transaction3.getId());
        } catch (TransactionNotFoundException e) {
            System.out.println(e);
        }        arrayTr = transactionsLinkedList.toArray();
        System.out.println("Output new array transaction:");
        for (Transaction i: arrayTr) {
            System.out.println(i.getRecipient().getName());
        }

        try {
            System.out.println("Delete transaction 2");
            transactionsLinkedList.remove(transaction2.getId());
        } catch (TransactionNotFoundException e) {
            System.out.println(e);
        }        arrayTr = transactionsLinkedList.toArray();
        System.out.println("Output new array transaction:");
        for (Transaction i: arrayTr) {
            System.out.println(i.getRecipient().getName());
        }

        try {
            System.out.println("Delete transaction 4");
            transactionsLinkedList.remove(transaction4.getId());
        } catch (TransactionNotFoundException e) {
            System.out.println(e);
        }
    }
}
