package ex05;

public interface UsersList {
    void addUser(User user);
    User getById(int id);
    User getByIndex(int index);
    int getCountUser();
}
