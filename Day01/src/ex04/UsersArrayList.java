package ex04;

public class UsersArrayList implements UsersList {
    private int index = 0;
    private int sizeArray = 10;
    private User[] users = new User[sizeArray];

    private void dumpArray() {
        users = resizeAndCopyArray(users);
    }

    private User[] resizeAndCopyArray(User[] dst) {
        sizeArray *= 2;
        User[] buffer = new User[sizeArray];
        for (int i = 0; i < dst.length; ++i) {
            buffer[i] = dst[i];
        }
        return buffer;
    }

    @Override
    public void addUser(User user) {
        if (index >= sizeArray) {
            dumpArray();
        } else {
            users[index] = user;
            index++;
        }
    }

    @Override
    public User getById(int id) {
        User ret = null;
        for (int i = 0; i < index; ++i) {
            if (users[i].getId() == id) {
                ret = users[i];
                break;
            }
        }
        if (ret == null) {
            throw new UserNotFoundException();
        }
        return ret;
    }

    @Override
    public User getByIndex(int index) {
        if (index >= sizeArray) {
            throw new UserNotFoundException();
        }
        return users[index];
    }
}
