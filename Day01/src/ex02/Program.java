package ex02;


public class Program {
    public static void main(String[] args) {
        User user1 = new User("John");
        user1.setBalance(1000);
        User user2 = new User("Nohn");
        user2.setBalance(500);

        UsersArrayList arrayUsers = new UsersArrayList();

        arrayUsers.addUser(user1);
        arrayUsers.addUser(user2);

        User buffUser1 = arrayUsers.getByIndex(1);
        System.out.printf("%s - %s -> %d\n", buffUser1.getId(), buffUser1.getName(), buffUser1.getBalance());
        User buffUser2 = arrayUsers.getById(0);
        System.out.printf("%s - %s -> %d\n", buffUser2.getId(), buffUser2.getName(), buffUser2.getBalance());

        for(int i = 0; i < 10; i++) {
            arrayUsers.addUser(new User("John" + i));
        }
        User buffUser11 = arrayUsers.getById(11);
        System.out.printf("%s - %s -> %d\n", buffUser11.getId(), buffUser11.getName(), buffUser11.getBalance());

        try {
            User buffUser24 = arrayUsers.getById(24);
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
        try {
            User buffUser25 = arrayUsers.getByIndex(25);
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
    }
}
