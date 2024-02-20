package ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Jogh");
        User user2 = new User("Nogh");
        System.out.printf("Name: %s - ID: %s\n", user1.getName(), user1.getId());
        System.out.printf("Name: %s - ID: %s\n", user2.getName(), user2.getId());
    }
}
